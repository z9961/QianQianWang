package com.niit.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class UsersInfo {
    private int uId;
    private String uName;
    private String uZipCode;
    private String uEmail;
    private String uIdentityNumber;

    @Id
    @Column(name = "UId")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
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
    @Column(name = "UZipCode")
    public String getuZipCode() {
        return uZipCode;
    }

    public void setuZipCode(String uZipCode) {
        this.uZipCode = uZipCode;
    }

    @Basic
    @Column(name = "UEmail")
    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    @Basic
    @Column(name = "UIdentityNumber")
    public String getuIdentityNumber() {
        return uIdentityNumber;
    }

    public void setuIdentityNumber(String uIdentityNumber) {
        this.uIdentityNumber = uIdentityNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersInfo usersInfo = (UsersInfo) o;
        return uId == usersInfo.uId &&
                Objects.equals(uName, usersInfo.uName) &&
                Objects.equals(uZipCode, usersInfo.uZipCode) &&
                Objects.equals(uEmail, usersInfo.uEmail) &&
                Objects.equals(uIdentityNumber, usersInfo.uIdentityNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uId, uName, uZipCode, uEmail, uIdentityNumber);
    }
}
