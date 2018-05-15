package org.nix.movieticketingsystem.web.contorller;

import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.commons.utils.ResultMvcMap;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.nix.movieticketingsystem.pojo.server.OrderServer;
import org.nix.movieticketingsystem.web.annotation.Authority;
import org.nix.movieticketingsystem.web.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/5/15.
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderServer orderServer;

    @PostMapping(value = "/createOrder")
    @Authority(role = RoleEnum.ROLE_USER)
    public Map<String, Object> createOrder(@CurrentUser User user,
                                           @RequestParam("tobeReleasedId") int tobeReleasedId,
                                           @RequestParam("seatsId") int[] seatsId) {
        if (orderServer.createOrder(user, tobeReleasedId, seatsId)) {
            return new ResultMvcMap()
                    .success()
                    .send();
        } else {
            return new ResultMvcMap()
                    .fail(HttpStatus.BAD_REQUEST, "订单生成失败")
                    .send();
        }
    }

    @PostMapping(value = "/paymentOrder")
    @Authority(role = RoleEnum.ROLE_USER)
    public Map<String, Object> paymentOrder(@CurrentUser User user,
                                            @RequestParam("orderId") int orderId) {
        if (orderServer.paymentOrder(user, orderId)) {
            return new ResultMvcMap()
                    .success()
                    .send();
        } else {
            return new ResultMvcMap()
                    .fail(HttpStatus.BAD_REQUEST, "支付订单失败")
                    .send();
        }
    }

    @PostMapping(value = "/paymentOrder")
    @Authority(role = {RoleEnum.ROLE_USER,RoleEnum.ROLE_CINEMA,RoleEnum.ROLE_MANGER})
    public Map<String,Object> findOrderById(@CurrentUser User user,
                                            @RequestParam("orderId") int orderId){
        return new ResultMvcMap()
                .success(orderServer.findOrderById(user,orderId))
                .send();
    }


}
