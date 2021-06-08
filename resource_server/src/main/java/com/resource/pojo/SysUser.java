package com.resource.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// 登录用户的模型
// 需要实现springSecurity专门提供的UserDetails接口
public class SysUser implements UserDetails {

    private Integer id;
    private String username;
    private String password;
    private int status;
    private List<SysRole> sysRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public List<SysRole> getSysRole() {
        return sysRole;
    }

    public void setSysRole(List<SysRole> sysRole) {
        this.sysRole = sysRole;
    }

    // 用户的角色role列表
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return sysRole;
    }

    // 密码
    @Override
    public String getPassword() {
        return password;
    }

    // 登陆用户名
    @Override
    public String getUsername() {
        return username;
    }


    // 下面的这四个布尔值方法是用来判断这个用户是否处于禁用状态的
    // 四个都为true就能登陆成功
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
