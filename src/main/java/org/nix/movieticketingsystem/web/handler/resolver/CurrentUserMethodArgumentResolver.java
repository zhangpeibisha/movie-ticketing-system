package org.nix.movieticketingsystem.web.handler.resolver;

import org.nix.movieticketingsystem.commons.enums.SessionEnum;
import org.nix.movieticketingsystem.commons.exceptions.AuthorityException;
import org.nix.movieticketingsystem.web.annotation.CurrentUser;
import org.nix.movieticketingsystem.pojo.entity.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * Create by zhangpe0312@qq.com on 2018/5/13.
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 检测这个参数上是否有这个注解和User对象，如果有则继续处理，若无则不处理
     * @param methodParameter 方法参数
     * @return 如果满足判断判断条件则继续处理
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(User.class)
                && methodParameter.hasParameterAnnotation(CurrentUser.class);
    }

    /**
     * 如果用户不为空则将用户注入到参数中
     * @return 注入的用户信息
     * @throws Exception 如果用户为空，则抛出异常
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        User user = (User) nativeWebRequest
                .getAttribute(SessionEnum.SESSION_USER.getKey(), RequestAttributes.SCOPE_SESSION);
        if (user != null) {
            return user;
        }
        throw new AuthorityException();
//        return null;
    }
}
