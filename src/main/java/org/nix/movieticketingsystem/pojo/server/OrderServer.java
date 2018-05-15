package org.nix.movieticketingsystem.pojo.server;

import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.pojo.dao.OrderRepository;
import org.nix.movieticketingsystem.pojo.dao.SeatRepository;
import org.nix.movieticketingsystem.pojo.dao.ToBeReleasedRepository;
import org.nix.movieticketingsystem.pojo.dao.UserRepository;
import org.nix.movieticketingsystem.pojo.dao.entitymanger.session.SeatDao;
import org.nix.movieticketingsystem.pojo.dto.FindOrderDto;
import org.nix.movieticketingsystem.pojo.dto.base.BaseResultDto;
import org.nix.movieticketingsystem.pojo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/5/14.
 */
@Service
public class OrderServer {

    @Autowired
    private ToBeReleasedRepository toBeReleasedRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatDao seatDao;
    @Autowired
    private OrderRepository orderRepository;
    /**
     * 发起订单
     * @param user 消费用户
     * @param tobeReleasedId 待放映电影id
     * @param seatsId
     * @return
     */
    public boolean createOrder(User user,int tobeReleasedId,int[] seatsId){

        // 1.查询准备购买电影的信息
        ToBeReleased toBeReleased = toBeReleasedRepository.findById(tobeReleasedId);
        if (toBeReleased!=null){
            //查询座位是否被购买
            List<BuySeat> buySeats = toBeReleased.getBuySeats();
            for (BuySeat buySeat : buySeats) {
                for (int value : seatsId) {
                    if (buySeat.getSeat().getId() == value)
                        return false;
                }
            }

            // 获取位子并选中
            List<Seat> seats = seatDao.findSeatsByIds(seatsId);
            List<BuySeat> currSeat = new ArrayList<>();
            for (Seat seat : seats ) {
                BuySeat buySeat = new BuySeat();
                buySeat.setSeat(seat);
                buySeat.setToBeReleased(toBeReleased);
            }
            Order order = new Order();
            order.setBuySeat(currSeat);
            order.setCinema(toBeReleased.getHall().getCinema());
            order.setHall(toBeReleased.getHall());
            order.setMoney(toBeReleased.getMoney());
            order.setMovie(toBeReleased.getMovie());
            order.setPlayTime(toBeReleased.getPlayTime());
            order.setUser(user);
            orderRepository.saveAndFlush(order);

            return true;
        }
        return false;
    }

    /**
     * 支付订单
     * @param user
     * @param orderId
     * @return
     */
    public boolean paymentOrder(User user , int orderId){
        // 1.查询订单
        Order order = orderRepository.findById(orderId);
        List<Order> orders = orderRepository.findAllByUser(user.getId());
        for (Order values : orders) {
            if (order.getUser().getAccount().equals(values.getUser().getAccount())){
                if (user.getMoney() >= values.getMoney()){
                    user.setMoney(user.getMoney()-order.getMoney());
                    order.setPayment(true);

                    userRepository.saveAndFlush(user);
                    orderRepository.saveAndFlush(order);

                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * 查询订单详情
     * @param user
     * @param orderId
     * @return
     */
    public BaseResultDto findOrderById(User user , int orderId){

        Order order = orderRepository.findById(orderId);

        if (order == null)
            return null;

        if (!user.getRole().equals(RoleEnum.ROLE_USER))
            return new FindOrderDto(order).result();

        List<Order> orders = orderRepository.findAllByUser(user.getId());
        for (Order values : orders) {
            if (order.getUser().getAccount().equals(values.getUser().getAccount())){
                return new FindOrderDto(order).result();
            }
        }
        return null;
    }
}
