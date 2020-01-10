package com.lj.service.userservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lj.common.PageRequest;
import com.lj.common.enums.ErrorMsgEnum;
import com.lj.exception.UserException;
import com.lj.mapper.usermapper.UserMapper;
import com.lj.response.user.UserLimitResonse;
import com.lj.response.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : liangjun
 * @ClassName : UserService
 * @Description :
 * @Date : 2019/11/21 10:55
 */
@Service
@Transactional
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public UserResponse findUserInfo(Long id) throws UserException {
        UserResponse userResponse = userMapper.selectUserInfo(id);
        if (null == userResponse) {
            throw new UserException(ErrorMsgEnum.NOT_USER_ERROR);
        }
        return userResponse;
    }

    /**
     * 分页插件查询
     *
     * @param userLimitResonsePageRequest
     * @return
     */
    public PageInfo<UserLimitResonse> findUserAll(PageRequest<UserLimitResonse> userLimitResonsePageRequest) {
        PageHelper.startPage(userLimitResonsePageRequest.getPageNo(), userLimitResonsePageRequest.getPageSize());
        List<UserLimitResonse> userLimitResonses = userMapper.selectUserLimit(userLimitResonsePageRequest.getObj());
        PageInfo<UserLimitResonse> pageInfo = new PageInfo<UserLimitResonse>(userLimitResonses);
        return pageInfo;
    }

    /**
     * @return java.util.List<java.lang.Long>
     * @Author liangjun
     * @Description 查询过期的用户
     * @Param []
     * @Date 2019/12/20 16:01
     **/
    public List<Long> queryExpireUser() {
        List<Long> longs = userMapper.selectExpireUser();
        return longs;
    }

    public int modifyUserStatus(Long id) {
        int i = userMapper.updateUserStatus(id);
        return i;
    }
}
