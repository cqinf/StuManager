package com.stu.entity.user;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LARK on 2018/1/10.
 * 封装用户信息的实体类
 */

@Entity
@Table(name = "user_info")
public class User implements Serializable {
    private int uno;
    private String uname;
    private String upwd = "666666";

    public User() {
        super();
    }

    public User(int uno, String uname, String upwd) {
        this.uno = uno;
        this.uname = uname;
        this.upwd = upwd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
