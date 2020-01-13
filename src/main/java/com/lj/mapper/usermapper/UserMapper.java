package com.lj.mapper.usermapper;

import com.lj.response.UserLimitResonse;
import com.lj.response.UserResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : liangjun
 * @ClassName : UserMapper
 * @Description :
 * @Date : 2019/11/21 10:56
 */
@Mapper
public interface UserMapper {

    UserResponse selectUserInfo(@Param("id") Long id);

    List<UserLimitResonse> selectUserLimit(@Param("obj") UserLimitResonse obj);


    List<Long> selectExpireUser();

    /**
     * @return int
     * @Author liangjun
     * @Description 修改用户状态
     * @Param [id 用户id]
     * @Date 2019/12/20 16:07
     **/
    int updateUserStatus(@Param("id") Long id);
}
