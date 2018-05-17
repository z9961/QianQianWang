package com.niit.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Orders {
    private int orderId;
    private Integer aId;
    private BigDecimal money;
    private Integer expect;
    private Integer expectType;
    private String exceptOther;
    private Timestamp orderDate;
    private Users usersByUPhone;
    private Project projectByPId;

    @Id
    @Column(name = "OrderId")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "AId")
    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
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
                Objects.equals(aId, orders.aId) &&
                Objects.equals(money, orders.money) &&
                Objects.equals(expect, orders.expect) &&
                Objects.equals(expectType, orders.expectType) &&
                Objects.equals(exceptOther, orders.exceptOther) &&
                Objects.equals(orderDate, orders.orderDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId, aId, money, expect, expectType, exceptOther, orderDate);
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
}
