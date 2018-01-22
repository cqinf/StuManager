package com.stu.entity.stu;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stu.entity.cls.Classes;
import com.stu.entity.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by LARK on 2018/1/10.
 * 封装stu信息的实体类
 */
@Entity
@Table(name = "stu_info")
public class Stu implements Serializable {
    private int sno;
    private String sname;
    private int sage;
    private int ssex;
    private String saddress;
    private String stel;
    private String simage;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date sbirthday;
    private int sidentity = 0; //0：学生，1：班长

    private User user;

    private Classes cls;

    public Stu() {
        super();
    }

    public Stu(int sno, String sname, int sage, int ssex, String saddress, String stel, String simage, Date sbirthday, int sidentity, User user, Classes cls) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.saddress = saddress;
        this.stel = stel;
        this.simage = simage;
        this.sbirthday = sbirthday;
        this.sidentity = sidentity;
        this.user = user;
        this.cls = cls;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getSsex() {
        return ssex;
    }

    public void setSsex(int ssex) {
        this.ssex = ssex;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }

    @Column(columnDefinition = "date")
    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public int getSidentity() {
        return sidentity;
    }

    public void setSidentity(int sidentity) {
        this.sidentity = sidentity;
    }

    @OneToOne
    @JoinColumn(name = "uno")
    @MapsId
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "cno")
    public Classes getCls() {
        return cls;
    }

    public void setCls(Classes cls) {
        this.cls = cls;
    }
}
