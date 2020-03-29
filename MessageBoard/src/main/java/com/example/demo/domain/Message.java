package com.example.demo.domain;

import java.io.Serializable;

/**
 * 作者: 是小文啊
 * QQ: 1612902996
 * 博客: wenshijin.cn
 * 描述:
 * 类名: Message
 * 编辑日期: 2020/3/7
 * 编辑时间: 18:54
 *
 * @Description:
 */
public class Message implements Serializable {
    private Long id;
    private String message;
    private String image;

    private UserMessage userMessage;


    public UserMessage getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(UserMessage userMessage) {
        this.userMessage = userMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
