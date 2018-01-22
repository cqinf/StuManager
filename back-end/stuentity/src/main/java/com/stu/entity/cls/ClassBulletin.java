package com.stu.entity.cls;

import com.stu.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by LARK on 2018/1/10.
 * 封装班级公告信息的实体类
 */
@Entity
@Table(name = "cls_bulletin")
public class ClassBulletin implements Serializable {
    private int cbno;
    private String cbtitle;
    private String cbcontext;
    private String cbimage;
    private Date cbtime;

    private User user;
    private Classes cls;

    public ClassBulletin() {
        super();
    }

    public ClassBulletin(int cbno, String cbtitle, String cbcontext, String cbimage, Date cbtime) {
        this.cbno = cbno;
        this.cbtitle = cbtitle;
        this.cbcontext = cbcontext;
        this.cbimage = cbimage;
        this.cbtime = cbtime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCbno() {
        return cbno;
    }

    public void setCbno(int cbno) {
        this.cbno = cbno;
    }

    public String getCbtitle() {
        return cbtitle;
    }

    public void setCbtitle(String cbtitle) {
        this.cbtitle = cbtitle;
    }

    public String getCbcontext() {
        return cbcontext;
    }

    public void setCbcontext(String cbcontext) {
        this.cbcontext = cbcontext;
    }

    public String getCbimage() {
        return cbimage;
    }

    public void setCbimage(String cbimage) {
        this.cbimage = cbimage;
    }

    @Column(columnDefinition = "date")
    public Date getCbtime() {
        return cbtime;
    }

    public void setCbtime(Date cbtime) {
        this.cbtime = cbtime;
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
