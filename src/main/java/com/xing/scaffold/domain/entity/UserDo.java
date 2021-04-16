package com.xing.scaffold.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 用户信息对数据库映射
 *
 * @author xingzhe
 * @date 2021/4/1 19:57
 */
@Table(name = "user")
@Data
@NoArgsConstructor
@Entity
@DynamicInsert
public class UserDo {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 用户email
     */
    @Column(name = "email")
    private String email;

    /**
     * 用户状态 0正常 1删除 2异常 3冻结
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 插入时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;
}
