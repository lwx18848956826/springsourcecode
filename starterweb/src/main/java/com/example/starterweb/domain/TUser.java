package com.example.starterweb.domain;

import com.example.starterweb.gener.UuidGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/16 11:30
 */
@Data
@Table(name = "t_user")
public class TUser {

    @Id
    @KeySql(genId = UuidGenId.class)
    private String id;

    @Column(name = "user_name",unique = true)
    private String username;

    private String password;

    private String salt;

    private String name;
    /**
     * 0 未知
     * 1 男
     * 2 女
     */
    private Integer sex;

    private String phone;

    private String address;

    private String notes;

    /**
     * 停用状态
     * true  停用
     * false 启用
     */
    private Boolean disabled;

    /**
     * 用户角色
     * admin    管理员
     * public   普通用户
     */
    private String role;

    /**
     * 创建时间
     */
    private Date at;

    /**
     * 登录时间
     */
    private Date loginAt;

}
