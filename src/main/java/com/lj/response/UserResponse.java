package com.lj.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @author : liangjun
 * @ClassName : UserResponse
 * @Description :
 * @Date : 2019/11/21 10:54
 */
public class UserResponse {

    private String name;

    private String address;


    @JsonIgnore
    private Date createTime;

    private String date;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
