package com.auth.mapper;

import com.auth.pojo.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMapper {

    // 查询所有角色
    List<SysRole> roleList();

    // 根据id获取角色
    SysRole getRoleById(@Param("rId") Integer rId);

    // 根据UID获取roles列表
    List<SysRole> getRolesByUid(@Param("UID") Integer uId);
}
