package com.niit.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UsersAddress {
    private int aId;
    private String address;
    private Users usersByAUPhone;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersAddress that = (UsersAddress) o;
        return aId == that.aId &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(aId, address);
    }

    @ManyToOne
    @JoinColumn(name = "aUPhone", referencedColumnName = "UPhone")
    public Users getUsersByAUPhone() {
        return usersByAUPhone;
    }

    public void setUsersByAUPhone(Users usersByAUPhone) {
        this.usersByAUPhone = usersByAUPhone;
    }
}
