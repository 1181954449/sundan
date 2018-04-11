package com.lanou.dao;

import com.lanou.entity.Address;

import java.util.List;

/**
 * Created by gaozhichao on 2018/4/3.
 */

public interface AddressDao {
    public int addAddress(Address address);
    public int updateAddress(Address address);
    public int insertSelective(Address address);
    public List<Address> lookAddress(int userId);
    public Address selectDefaultAddress();
    public int deleteAddress(int addressId);
    // 查找  默认地址id
    public int findDefultaddressId();

}
