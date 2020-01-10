package com.lj.response.user;

/**
 * @author : liangjun
 * @ClassName : UserLimitResonse
 * @Description :
 * @Date : 2019/11/22 15:19
 */
public class UserLimitResonse {

    private String userName;

    private String userSex;

    private int userAge;

    private String userAddress;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
