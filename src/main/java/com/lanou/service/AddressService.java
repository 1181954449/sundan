package com.lanou.service;

import com.lanou.entity.Address;

import java.util.List;

/**
 * Created by gaozhichao on 2018/4/3.
 */
public interface AddressService {
    // 添加地址
    public int addAddress(Address address);
    // 修改地址
    public int updateAddress(Address address);
    // 添加部分收货地址
    public int insertSelective(Address address);
    // 查看所有地址
    public List<Address> lookAddress(int userId);
    // 查询默认地址
    public Address selectDefaultAddress();
    // 删除地址
    public int deleteAddress(int addressId);

    // 修改默认地址
    public int  updateDefault(Address address);
}
