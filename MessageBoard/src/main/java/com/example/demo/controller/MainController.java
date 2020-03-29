package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 作者: 是小文啊
 * QQ: 1612902996
 * 博客: wenshijin.cn
 * 描述:
 * 类名: MainController
 * 编辑日期: 2020/3/4
 * 编辑时间: 11:11
 *
 * @Description:
 */
@Controller
public class MainController {

    @Autowired
    UserMapper userMapper;
    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/registered")
    public String registered() {
        return "registered";
    }

    @GetMapping("/message")
    public String message() {
        return "message";
    }

}
