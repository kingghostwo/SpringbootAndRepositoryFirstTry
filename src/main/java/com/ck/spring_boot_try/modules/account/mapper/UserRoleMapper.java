package com.ck.spring_boot_try.modules.account.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper {

    @Delete("delete from user_role where user_id = #{userId}")
    void deleteUserRoleByUserId(int userId);

    @Insert("insert user_role(role_id, user_id) values(#{roleId}, #{userId})")
    void addUserRole(@Param("roleId") int roleId,@Param("userId") int userId);

}
