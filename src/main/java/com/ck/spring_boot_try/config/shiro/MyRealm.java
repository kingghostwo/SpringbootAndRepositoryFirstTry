package com.ck.spring_boot_try.config.shiro;

import com.ck.spring_boot_try.modules.account.entity.Resource;
import com.ck.spring_boot_try.modules.account.entity.Role;
import com.ck.spring_boot_try.modules.account.entity.User;
import com.ck.spring_boot_try.modules.account.service.RoleService;
import com.ck.spring_boot_try.modules.account.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        String userName = (String) principalCollection.getPrimaryPrincipal();
//        User user = userService.getUserByUserName(userName);
//        if (user == null) {
//            return null;
//        }
//        List<Role> roles = roleService.getRolesByUserId(user.getUserId());
//        for (Role role : roles) {
//            authorizationInfo.addRole(role.getRoleName());
//            List<Resource> resources = resourceService.getResourcesByRoleId(role.getRoleId());
//            for (Resource resource : resources) {
//                authorizationInfo.addStringPermission(resource.getPermission());
//            }
//        }
//        return authorizationInfo;
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        String userName = (String) authenticationToken.getPrincipal();
//        User user = userService.getUserByUserName(userName);
//        if (user == null) {
//            throw new UnknownAccountException("this userName do not exist");
//        }
////        principal:?????????????????????????????????????????????????????????
////        credentials:??????????????????????????????
////        realmName:??????realm???????????????????????????????????????getName()??????
//
//        return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
        return null;
    }
}
