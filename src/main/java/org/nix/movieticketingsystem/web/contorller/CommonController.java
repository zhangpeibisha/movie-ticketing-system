package org.nix.movieticketingsystem.web.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Create by zhangpe0312@qq.com on 2018/5/11.
 */
@Controller
public class CommonController {

    @GetMapping("/")
    public String index() {
        return "redirect:templates/login";
    }
}
