package com.stu.entity.stu;

import com.stu.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by LARK on 2018/1/10.
 * 封装学生出勤信息的实体类
 */
@Entity
@Table(name = "stu_attendance")
public class StuAttendance implements Serializable {
    private int sano;
    private String sacontext;
    private Date satime;
    private double sascoring = 0;
    private double satotalscore = 100;
    private int state = 0; //0：未查看，1：已查看

    private Stu stu;
    private User user;

    public StuAttendance() {
        super();
    }

    public StuAttendance(int sano, String sacontext, Date satime, double sascoring, double satotalscore, int state, Stu stu, User user) {
        this.sano = sano;
        this.sacontext = sacontext;
        this.satime = satime;
        this.sascoring = sascoring;
        this.satotalscore = satotalscore;
        this.state = state;
        this.stu = stu;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSano() {
        return sano;
    }

    public void setSano(int sano) {
        this.sano = sano;
    }

    public String getSacontext() {
        return sacontext;
    }

    public void setSacontext(String sacontext) {
        this.sacontext = sacontext;
    }

    @Column(columnDefinition = "date")
    public Date getSatime() {
        return satime;
    }

    public void setSatime(Date satime) {
        this.satime = satime;
    }

    public double getSascoring() {
        return sascoring;
    }

    public void setSascoring(double sascoring) {
        this.sascoring = sascoring;
    }

    public double getSatotalscore() {
        return satotalscore;
    }

    public void setSatotalscore(double satotalscore) {
        if(satotalscore == 0 || satotalscore == 0.0){
            this.satotalscore += this.sascoring;
            return;
        }
        this.satotalscore = satotalscore;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @ManyToOne
    @JoinColumn(name = "sno")
    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }

    @ManyToOne
    @JoinColumn(name = "uno")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
