package com.example.State_Pattern.mapper;

import com.example.State_Pattern.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM public.user WHERE id = #{id}")
    User getUser(String id);

    @Update("UPDATE public.user SET state = #{state} WHERE id = #{id}")
    void updateUser(User user);
}