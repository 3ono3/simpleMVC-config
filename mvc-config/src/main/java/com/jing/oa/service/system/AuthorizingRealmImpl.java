package com.jing.oa.service.system;

import com.jing.oa.common.CustomerException;
import com.jing.oa.common.ResultCodeEnum;
import com.jing.oa.model.LoginVerifyToken;
import com.jing.oa.model.User;
import com.jing.oa.service.PermissionService;
import com.jing.oa.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author GuoJingyuan
 * @date 2019/8/21
 */
public class AuthorizingRealmImpl extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(AuthorizingRealmImpl.class);

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        try {
            User user = (User) principalCollection.getPrimaryPrincipal();
            List<com.jing.oa.model.Permission> userPermissions = permissionService.getUserPermissions(user);
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            Set<Permission> permissions = new LinkedHashSet<>();
            for (com.jing.oa.model.Permission p : userPermissions) {
                permissions.add(new WildcardPermission(p.getTitle()));
            }
            info.setObjectPermissions(permissions);
            return info;
        } catch (Exception e) {
            logger.error("授权异常：", e);
            throw new CustomerException(ResultCodeEnum.AUTHORIZATION_ERROR);
        }
    }

    /**
     * 登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LoginVerifyToken token = (LoginVerifyToken) authenticationToken;
        String account = token.getUsername();
        String password = new String(token.getPassword());
        User user = null;
        try {
            user = userService.loginVerify(account, password);
        } catch (CustomerException e) {
            throw new AuthenticationException(e.getDesc(), e);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), user.getAccount());
        return info;
    }
}
