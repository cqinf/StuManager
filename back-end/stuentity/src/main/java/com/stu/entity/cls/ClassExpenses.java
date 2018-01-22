package com.stu.entity.cls;

import com.stu.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by LARK on 2018/1/10.
 * 封装班费信息的实体类
 */
@Entity
@Table(name = "cls_expenses")
public class ClassExpenses implements Serializable {
    private int ceno;
    private double cecost = 0;
    private double cetotalcost = 0;
    private Date cetime;

    private User user;
    private Classes cls;

    public ClassExpenses() {
        super();
    }

    public ClassExpenses(int ceno, double cecost, double cetotalcost, Date cetime) {
        this.ceno = ceno;
        this.cecost = cecost;
        this.cetotalcost = cetotalcost;
        this.cetime = cetime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCeno() {
        return ceno;
    }

    public void setCeno(int ceno) {
        this.ceno = ceno;
    }

    public double getCecost() {
        return cecost;
    }

    public void setCecost(double cecost) {
        this.cecost = cecost;
    }

    public double getCetotalcost() {
        return cetotalcost;
    }

    public void setCetotalcost(double cetotalcost) {
        if(cetotalcost == 0 || cetotalcost == 0.0){
            this.cetotalcost += this.cecost;
            return;
        }
        this.cetotalcost = cetotalcost;
    }

    @Column(columnDefinition = "date")
    public Date getCetime() {
        return cetime;
    }

    public void setCetime(Date cetime) {
        this.cetime = cetime;
    }

    @ManyToOne
    @JoinColumn(name = "uno")
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
