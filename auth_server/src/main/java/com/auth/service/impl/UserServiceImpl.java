package com.auth.service.impl;


import com.auth.mapper.SysUserMapper;
import com.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 继承UserService接口
@Service
public class UserServiceImpl implements UserService {

    // 调用写好的SysUserMapper接口
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     *
     * @param s 就是提交表单传递进来的username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return sysUserMapper.getUser(s);
    }
}
