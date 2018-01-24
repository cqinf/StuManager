package com.stu.entity.cls;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by LARK on 2018/1/10.
 */

@Entity
@Table(name = "class_info")
public class Classes implements Serializable {
    private int cno;
    private String cname;
    private String cslogan;

    public Classes() {
        super();
    }

    public Classes(int cno, String cname, String cslogan) {
        this.cno = cno;
        this.cname = cname;
        this.cslogan = cslogan;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCslogan() {
        return cslogan;
    }

    public void setCslogan(String cslogan) {
        this.cslogan = cslogan;
    }
}
