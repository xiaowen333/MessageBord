package com.example.demo.mapper;


import com.example.demo.domain.UserMessage;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

@Mapper
public interface UserMessageMapper {

    @Insert("insert into user_message(user_id,message_id) values(#{userId},#{messageId})")
    public void InsertUserMessage(UserMessage userMessage);

    @Select("select * from user_message where message_id = #{messageId}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "message_id", property = "messageId"),
            @Result(column = "user_id", property = "user", one = @One(select = "com.example.demo.mapper.UserMapper.selectById",fetchType = FetchType.EAGER))
    })
    public UserMessage SelectId(Long messageId);
}
