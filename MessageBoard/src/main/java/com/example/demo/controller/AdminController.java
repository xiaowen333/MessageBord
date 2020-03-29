package com.example.demo.controller;

import com.example.demo.domain.Message;
import com.example.demo.domain.User;
import com.example.demo.domain.UserMessage;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserMessageMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 是小文啊
 * QQ: 1612902996
 * 博客: wenshijin.cn
 * 描述:
 * 类名: AdminController
 * 编辑日期: 2020/3/6
 * 编辑时间: 15:18
 *
 * @Description:
 */
@RestController
public class AdminController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    UserMessageMapper userMessageMapper;

    @GetMapping("/user")
    public ModelAndView AdminUser(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "5") int pageSize) {
        ModelAndView modelAndView = new ModelAndView();

        PageHelper.startPage(pageNo, pageSize);
        List<User> all = userMapper.findAll();

        PageInfo pageInfo = new PageInfo(all);


        modelAndView.addObject("users", pageInfo);
        modelAndView.setViewName("user");

        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteUser(@RequestParam(defaultValue = "") String username) {
        userMapper.DeleteByName(username);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:user");
        return modelAndView;
    }


    @PostMapping("/registered")
    public ModelAndView registeredPost(User user) {

        userMapper.InsertUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:index");

        return modelAndView;
    }

    @PostMapping("/message")
    public ModelAndView messagePost(Message message) {

        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        User user = (User) auth.getPrincipal();


        ModelAndView modelAndView = new ModelAndView();
       Long i = messageMapper.InsertMessage(message);
        UserMessage userMessage = new UserMessage(user.getId(),message.getId());
        userMessageMapper.InsertUserMessage(userMessage);


        modelAndView.setViewName("redirect:index");

        return modelAndView;
    }

    @GetMapping("/index")
    public ModelAndView messageBoard(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "4")int pageSize) {

        ModelAndView modelAndView = new ModelAndView();

        PageHelper.startPage(pageNo,pageSize);
        List<Message> all = messageMapper.findAll();
        PageInfo pageInfo = new PageInfo(all);


//        List<Message> messages =pageInfo.getList();
//        List<Message> messages1 = new ArrayList<>();
//        for ( Message message: messages
//             ) {
//
//            UserMessage userMessage = userMessageMapper.SelectId(message.getId());
//            User user = userMapper.selectById(userMessage.getUserId());
//            message.setUser(user);
//            messages1.add(message);
//
//
//        }
//        PageInfo pageInfo1 = new PageInfo(messages1);
        modelAndView.addObject("messages",pageInfo);
        modelAndView.setViewName("index");


        return modelAndView;

    }
}