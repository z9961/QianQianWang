package com.niit.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Users {
    private String uPhone;
    private String uName;
    private String uPwd;
    private int uType;
    private int uFlag;
    private Collection<Orders> ordersByUPhone;
    private Collection<Project> projectsByUPhone;
    private Collection<ProjectComment> projectCommentsByUPhone;
    private Collection<UsersAddress> usersAddressesByUPhone;
    private UsersInfo usersInfoByUPhone;

    @Override
    public String toString() {
        return "Users{" +
                "uPhone='" + uPhone + '\'' +
                ", uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                ", uType=" + uType +
                ", uFlag=" + uFlag +
                ", ordersByUPhone=" + ordersByUPhone +
                '}';
    }

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

    @OneToMany(mappedBy = "usersByUPhone")
    public Collection<Orders> getOrdersByUPhone() {
        return ordersByUPhone;
    }

    public void setOrdersByUPhone(Collection<Orders> ordersByUPhone) {
        this.ordersByUPhone = ordersByUPhone;
    }

    @OneToMany(mappedBy = "usersByUPhone")
    public Collection<Project> getProjectsByUPhone() {
        return projectsByUPhone;
    }

    public void setProjectsByUPhone(Collection<Project> projectsByUPhone) {
        this.projectsByUPhone = projectsByUPhone;
    }

    @OneToMany(mappedBy = "usersByUPhone")
    public Collection<ProjectComment> getProjectCommentsByUPhone() {
        return projectCommentsByUPhone;
    }

    public void setProjectCommentsByUPhone(Collection<ProjectComment> projectCommentsByUPhone) {
        this.projectCommentsByUPhone = projectCommentsByUPhone;
    }

    @OneToMany(mappedBy = "usersByAUPhone")
    public Collection<UsersAddress> getUsersAddressesByUPhone() {
        return usersAddressesByUPhone;
    }

    public void setUsersAddressesByUPhone(Collection<UsersAddress> usersAddressesByUPhone) {
        this.usersAddressesByUPhone = usersAddressesByUPhone;
    }

    @OneToOne(mappedBy = "usersByUPhone")
    public UsersInfo getUsersInfoByUPhone() {
        return usersInfoByUPhone;
    }

    public void setUsersInfoByUPhone(UsersInfo usersInfoByUPhone) {
        this.usersInfoByUPhone = usersInfoByUPhone;
    }
}
