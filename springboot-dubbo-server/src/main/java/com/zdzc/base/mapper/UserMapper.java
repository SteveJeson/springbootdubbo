package com.zdzc.base.mapper;

import com.zdzc.base.model.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAllUsers();

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}