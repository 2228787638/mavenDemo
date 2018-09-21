package com.how2java.mapper;

import com.how2java.domain.User;
import java.util.List;

/**
 * @author Administrator
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUserList();

    User getUserByLoginName(String loginName);

    List<User> selectUserByDepartid(Integer id);
}