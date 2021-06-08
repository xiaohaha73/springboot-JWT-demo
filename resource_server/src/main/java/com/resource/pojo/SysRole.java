package com.resource.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

// 用户角色信息
// 需要实现springSecurity提供的一个接口GrantedAuthority
public class SysRole implements GrantedAuthority{

    private Integer id;
    private String roleName;
    private String roleDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    // 以后这个对象可能需要和json数据接触有些属性没必要转成json
    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}
