package org.nix.movieticketingsystem.web.handler.interceptors;

import org.apache.log4j.Logger;
import org.nix.movieticketingsystem.commons.enums.RoleEnum;
import org.nix.movieticketingsystem.commons.enums.SessionEnum;
import org.nix.movieticketingsystem.commons.exceptions.AuthorityException;
import org.nix.movieticketingsystem.pojo.dao.UserRepository;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.nix.movieticketingsystem.web.annotation.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 * 权限拦截器
 */
public class AuthorityInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(AuthorityInterceptor.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AuthorityException {

        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {

            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Authority authority = method.getAnnotation(Authority.class);

            logger.info("0000000000000000000000000000000000");

            if (authority == null)
                return true;

            logger.info("11111111111111111111111111111111111");

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute(SessionEnum.SESSION_USER.getKey());

            logger.info("3333333333333333333333333333333");

            if (user == null)
                throw new AuthorityException();

            if (checkUserRole(user, authority.role()))
                return true;
            else
                // 权限不足
                throw new AuthorityException();
        }else {
            return true;
        }
    }

    private boolean checkUserRole(User user, RoleEnum[] roleEnum) {

        user = userRepository.findById(user.getAccount());
        for (RoleEnum role : roleEnum) {
            if (role == user.getRole())
                return true;
        }
        return false;
    }
}
