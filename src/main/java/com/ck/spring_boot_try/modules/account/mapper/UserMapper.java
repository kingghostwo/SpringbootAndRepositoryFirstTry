package com.ck.spring_boot_try.modules.account.mapper;

import com.ck.spring_boot_try.modules.account.entity.User;
import com.ck.spring_boot_try.modules.common.vo.SearchVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user(user_Name, password, create_date) " +
            "values (#{userName},#{password},#{createDate})")
    @Options(useGeneratedKeys = true, keyColumn = "user_id", keyProperty = "userId")
    void insertUser(User user);

    @Select("select * from user where user_name = #{userName}")
    User getUserByUserName(String userName);

    @Select("<script>" +
            "select * from user "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + "and user_name like '%${keyWord}%' "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + "order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + "order by create_date desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<User> getUsersBySearchVo(SearchVo searchVo);

    @Select("select * from user where user_id = #{userId}")
    @Results(id = "userResult", value = {
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_id", property = "roles",
                    javaType = List.class,
                    many = @Many(select = "com.ck.spring_boot_try.modules.account.mapper." +
                            "RoleMapper.getRoleByUserId"))
    })
    User getUserById(int userId);

    @Update("update user set user_name=#{userName} where user_id=#{userId}")
    void updateUser(User user);

    @Delete("delete from user where user_id=#{userId}")
    void deleteUser(int userId);

}
