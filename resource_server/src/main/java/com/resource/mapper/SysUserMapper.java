package com.resource.mapper;

import com.resource.pojo.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {

    // 查询所有用户
    List<SysUser> userList();

    // 根据username值查找相关用户和他对应的角色值
    SysUser getUser(@Param("username") String username);
}
