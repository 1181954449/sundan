package com.lanou.impl;

import com.lanou.dao.AddressDao;
import com.lanou.entity.Address;
import com.lanou.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaozhichao on 2018/4/3.
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressDao addressDao;


    public int addAddress(Address address) {
        // 先这样使用, 过后整合 的时候 结合登陆后的Session中的userId存值
        address.setUserId(1);
        return addressDao.addAddress(address);
    }

    public int updateAddress(Address address) {

        return addressDao.updateAddress(address);
    }

    public int insertSelective(Address address) {
        address.setUserId(2);
        return addressDao.insertSelective(address);
    }

    public List<Address> lookAddress(int userId){

        return addressDao.lookAddress(userId);
    }

    public Address selectDefaultAddress() {
        return addressDao.selectDefaultAddress();
    }

    public int deleteAddress(int addressId) {
        return addressDao.deleteAddress(addressId);
    }

    @Override
    public int updateDefault(Address address) {
        address.setIsDefault(1);
        Address address1 = new Address();
        int defultaddressId = addressDao.findDefultaddressId();
        address1.setAddressId(defultaddressId);
        address1.setIsDefault(0);
        System.out.println(defultaddressId);
        int count = addressDao.updateAddress(address1);
        int i = addressDao.updateAddress(address);
        return i;
    }
}
