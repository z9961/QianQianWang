package com.niit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UsersInfo {
    private String uPhone;
    private String uName;
    private String uZipCode;
    private String uEmail;
    private String uCardNumber;
    private Users usersByUPhone;

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
    @Column(name = "UCardNumber")
    public String getuCardNumber() {
        return uCardNumber;
    }

    public void setuCardNumber(String uCardNumber) {
        this.uCardNumber = uCardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersInfo usersInfo = (UsersInfo) o;
        return Objects.equals(uPhone, usersInfo.uPhone) &&
                Objects.equals(uName, usersInfo.uName) &&
                Objects.equals(uZipCode, usersInfo.uZipCode) &&
                Objects.equals(uEmail, usersInfo.uEmail) &&
                Objects.equals(uCardNumber, usersInfo.uCardNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uPhone, uName, uZipCode, uEmail, uCardNumber);
    }

    @OneToOne
    @JoinColumn(name = "UPhone", referencedColumnName = "UPhone", nullable = false)
    public Users getUsersByUPhone() {
        return usersByUPhone;
    }

    public void setUsersByUPhone(Users usersByUPhone) {
        this.usersByUPhone = usersByUPhone;
    }
}
