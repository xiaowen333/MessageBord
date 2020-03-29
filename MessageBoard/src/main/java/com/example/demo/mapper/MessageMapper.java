package com.example.demo.mapper;

import com.example.demo.domain.Message;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("select * from message")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result(column = "message", property = "message"),
            @Result(column = "image", property = "image"),
            @Result(column = "id", property = "userMessage", one = @One(select = "com.example.demo.mapper.UserMessageMapper.SelectId",fetchType = FetchType.EAGER)
            )
    })
    public List<Message> findAll();

    @Insert("insert into message(message,image) values(#{message},#{image})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public Long InsertMessage(Message message);
}
