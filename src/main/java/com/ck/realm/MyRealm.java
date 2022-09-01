package com.ck.realm;

import com.ck.entity.Permission;
import com.ck.entity.Role;
import com.ck.entity.User;
import com.ck.service.RoleService;
import com.ck.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        User u = userService.queryUserAndRoleByUserName(userName);
        List<Role> roles = u.getRole();
        Set<String> roleNames = new HashSet<>();
        Set<String> perimissionDesc = new HashSet<>();
        for (Role role:
             roles) {
            String roleName = role.getRoleName();
            roleNames.add(roleName);
            Role role1 = roleService.queryRoleAndPermission(roleName);
            List<Permission> permissions = role1.getPermissions();
            for (Permission permission : permissions) {
                perimissionDesc.add(permission.getPermissionDesc());
            }
        }
        simpleAuthorizationInfo.addRoles(roleNames);
        simpleAuthorizationInfo.addStringPermissions(perimissionDesc);
        return simpleAuthorizationInfo;
    }

    //    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
//        获取当前登录用户名（token是登录凭证）
        String userName = (String) authenticationToken.getPrincipal();
        User u = userService.queryUserByUserName(userName);
        SecurityUtils.getSubject().getSession().setAttribute("u", u);
//        该用户不存在
        if (u == null) {
            return null;
        }
        ByteSource salt = ByteSource.Util.bytes(userName);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, u.getUserPassword(), salt, getName());
//        System.out.println(simpleAuthenticationInfo);
        return simpleAuthenticationInfo;
    }
}
