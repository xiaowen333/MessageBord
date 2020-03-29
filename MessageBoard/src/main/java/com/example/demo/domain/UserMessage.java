package com.example.demo.domain;

import java.io.Serializable;

/**
 * 作者: 是小文啊
 * QQ: 1612902996
 * 博客: wenshijin.cn
 * 描述:
 * 类名: UserMessage
 * 编辑日期: 2020/3/7
 * 编辑时间: 19:26
 *
 * @Description:
 */
public class UserMessage implements Serializable {

    private Long userId;
    private Long messageId;
    private  User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserMessage(Long userId, Long messageId) {
        this.userId = userId;
        this.messageId = messageId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
