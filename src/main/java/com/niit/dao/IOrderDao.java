package com.niit.dao;

import com.niit.entity.Orders;

import java.util.List;

public interface IOrderDao {

    boolean saveorder(Orders o);

    List<Orders> findAllOrder(String s);
}
