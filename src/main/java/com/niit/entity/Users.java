package com.niit.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Users {
    private String uPhone;
    private String uName;
    private String uPwd;
    private int uType;
    private int uFlag;

    @Id
    @Column(name = "UPhone")
    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    @Basic
    @Column(name = "UName")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "UPwd")
    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    @Basic
    @Column(name = "UType")
    public int getuType() {
        return uType;
    }

    public void setuType(int uType) {
        this.uType = uType;
    }

    @Basic
    @Column(name = "UFlag")
    public int getuFlag() {
        return uFlag;
    }

    public void setuFlag(int uFlag) {
        this.uFlag = uFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return uType == users.uType &&
                uFlag == users.uFlag &&
                Objects.equals(uPhone, users.uPhone) &&
                Objects.equals(uName, users.uName) &&
                Objects.equals(uPwd, users.uPwd);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uPhone, uName, uPwd, uType, uFlag);
    }
}
