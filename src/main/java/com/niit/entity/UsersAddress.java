package com.niit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UsersAddress {
    private int aId;
    private String address;
    private String uPhone;
    private Users usersByUPhone;
    private Users usersByUPhone_0;

    @Id
    @Column(name = "AId")
    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "UPhone")
    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersAddress that = (UsersAddress) o;
        return aId == that.aId &&
                Objects.equals(address, that.address) &&
                Objects.equals(uPhone, that.uPhone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aId, address, uPhone);
    }

    @ManyToOne
    @JoinColumn(name = "UPhone", referencedColumnName = "UPhone")
    public Users getUsersByUPhone() {
        return usersByUPhone;
    }

    public void setUsersByUPhone(Users usersByUPhone) {
        this.usersByUPhone = usersByUPhone;
    }

    @ManyToOne
    @JoinColumn(name = "UPhone", referencedColumnName = "UPhone")
    public Users getUsersByUPhone_0() {
        return usersByUPhone_0;
    }

    public void setUsersByUPhone_0(Users usersByUPhone_0) {
        this.usersByUPhone_0 = usersByUPhone_0;
    }
}
