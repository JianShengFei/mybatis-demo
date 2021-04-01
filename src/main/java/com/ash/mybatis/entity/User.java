package com.ash.mybatis.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName User.java
 * @createTime 2021年03月29日 10:37
 * @Description TODO 请标注类具体的用途
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String password;

    private String real_Name;

}
