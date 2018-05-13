package org.nix.movieticketingsystem.web.annotation;


import org.nix.movieticketingsystem.commons.enums.RoleEnum;

import java.lang.annotation.*;

@Target(ElementType.METHOD)          // 可用在方法的参数上
@Retention(RetentionPolicy.RUNTIME)     // 运行时有效
@Documented
public @interface Authority {

    RoleEnum[] role() default RoleEnum.ROLE_USER;

}
