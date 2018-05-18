package com.niit.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Orders {
    private int orderId;
    private BigDecimal money;
    private Integer expect;
    private Integer expectType;
    private String exceptOther;
    private Timestamp orderDate;
    private Users usersByUPhone;
    private Project projectByPId;
    private UsersAddress usersAddressByAId;

    public Orders(BigDecimal money, Integer expect, Integer expectType, String exceptOther, Timestamp orderDate, Users usersByUPhone, Project projectByPId, UsersAddress usersAddressByAId) {
        this.money = money;
        this.expect = expect;
        this.expectType = expectType;
        this.exceptOther = exceptOther;
        this.orderDate = orderDate;
        this.usersByUPhone = usersByUPhone;
        this.projectByPId = projectByPId;
        this.usersAddressByAId = usersAddressByAId;
    }

    public Orders() {
    }

    public Orders(int orderId, BigDecimal money, Integer expect, Integer expectType, String exceptOther, Timestamp orderDate, Users usersByUPhone, Project projectByPId, UsersAddress usersAddressByAId) {
        this.orderId = orderId;
        this.money = money;
        this.expect = expect;
        this.expectType = expectType;
        this.exceptOther = exceptOther;
        this.orderDate = orderDate;
        this.usersByUPhone = usersByUPhone;
        this.projectByPId = projectByPId;
        this.usersAddressByAId = usersAddressByAId;
    }

    @Id
    @Column(name = "OrderId")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "Money")
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Basic
    @Column(name = "Expect")
    public Integer getExpect() {
        return expect;
    }

    public void setExpect(Integer expect) {
        this.expect = expect;
    }

    @Basic
    @Column(name = "ExpectType")
    public Integer getExpectType() {
        return expectType;
    }

    public void setExpectType(Integer expectType) {
        this.expectType = expectType;
    }

    @Basic
    @Column(name = "ExceptOther")
    public String getExceptOther() {
        return exceptOther;
    }

    public void setExceptOther(String exceptOther) {
        this.exceptOther = exceptOther;
    }

    @Basic
    @Column(name = "OrderDate")
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId &&
                Objects.equals(money, orders.money) &&
                Objects.equals(expect, orders.expect) &&
                Objects.equals(expectType, orders.expectType) &&
                Objects.equals(exceptOther, orders.exceptOther) &&
                Objects.equals(orderDate, orders.orderDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, money, expect, expectType, exceptOther, orderDate);
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
    @JoinColumn(name = "PId", referencedColumnName = "PId")
    public Project getProjectByPId() {
        return projectByPId;
    }

    public void setProjectByPId(Project projectByPId) {
        this.projectByPId = projectByPId;
    }

    @ManyToOne
    @JoinColumn(name = "AId", referencedColumnName = "AId")
    public UsersAddress getUsersAddressByAId() {
        return usersAddressByAId;
    }

    public void setUsersAddressByAId(UsersAddress usersAddressByAId) {
        this.usersAddressByAId = usersAddressByAId;
    }
}
