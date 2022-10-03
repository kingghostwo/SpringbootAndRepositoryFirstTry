package com.ck.spring_boot_try.modules.account.mapper;

import com.ck.spring_boot_try.modules.account.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select * from role")
    List<Role> getRoles();

    @Select("select * from role role left join user_role userRole "
            + "on role.role_id = userRole.role_id where userRole.user_id = #{userId}")
    List<Role> getRoleByUserId(int userId);

}
