package com.ck.spring_boot_try.modules.account.mapper;

import com.ck.spring_boot_try.modules.account.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user(user_Name, password, create_date) " +
            "values (#{userName},#{password},#{createDate})")
    void insertUser(User user);

    @Select("select * from user where user_name = #{userName}")
    User getUserByUserName(String userName);

}
