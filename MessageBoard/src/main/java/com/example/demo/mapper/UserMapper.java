package com.example.demo.mapper;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findAll();

    @Select("select * from user where id = #{id}")
    public User selectById(Long id);

    @Select("select * from user where username = #{username}")
    @Results({
            @Result(id = true, property = "id",column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "avatar", property = "avatar"),
            @Result(column = "id", property = "authoritys", javaType = List.class,many =
            @Many(select = "com.example.demo.mapper.AuthorityMapper.findByIdAuthority"))
    })
    public User selectByName(String username);

    @Delete("delete from user where username=#{username}")
    public void DeleteByName(String username);

    @Insert("insert into user(username,email,password) values(#{username},#{email},#{password})")
    public void InsertUser(User user);
}
