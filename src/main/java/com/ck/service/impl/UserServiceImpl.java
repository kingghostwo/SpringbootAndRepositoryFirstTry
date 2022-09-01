package com.ck.service.impl;

import com.ck.dao.UserDao;
import com.ck.entity.User;
import com.ck.service.UserService;
import com.ck.vo.ResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> queryUserAll() {
        return userDao.queryUserAll();
    }

    @Override
    public User queryUserById(int userId) {
        return userDao.queryUserById(userId);
    }

    @Override
    public PageInfo<User> queryUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.queryUserAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public User queryUserByUserName(String userName) {
        return userDao.queryUserByUserName(userName);
    }


//    登录认证
    @Override
    public ResultInfo login(String userName, String userPassword) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
        try {
            subject.login(token);
            subject.checkRoles();
        } catch (Exception e) {
            User user = (User) subject.getSession().getAttribute("u");
            if (user == null) {
                return new ResultInfo("500", "账号错误");
            } else {
                return new ResultInfo("500","密码输入错误");
            }
        }

        return new ResultInfo("200","success");
    }

    @Override
    public User queryUserAndRoleByUserName(String userName) {
        return userDao.queryUserAndRoleByUserName(userName);
    }
}
