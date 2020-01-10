package com.lj.job;

import com.lj.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

/**
 * @author : liangjun
 * @ClassName : Job
 * @Description :
 * @Date : 2019/12/20 13:44
 */
@Configuration
@EnableScheduling
@Service
public class Job {

    private UserService userService;

    @Autowired
    public Job(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param
     * @Author : LiAng_Jun
     * @Description :
     * @Date : 2019/12/23 14:48
     * @Return : void
     **/
//    @Scheduled(initialDelay = 3000, fixedRate = 5000)
//    public void pintDate() {
//        List<Long> ids = userService.queryExpireUser();
//        if (CollectionUtils.isEmpty(ids)) {
//            return;
//        }
//
//        for (Long id : ids) {
//            userService.modifyUserStatus(id);
//        }
//    }
}
