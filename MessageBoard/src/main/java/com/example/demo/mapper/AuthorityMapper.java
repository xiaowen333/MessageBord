package com.example.demo.mapper;

import com.example.demo.domain.Authority;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthorityMapper {
    @Select("select * from authority where id = #{id}")
    public List<Authority> findByIdAuthority(Long id);
}
