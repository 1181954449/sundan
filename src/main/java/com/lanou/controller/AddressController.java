package com.lanou.AddressController;

import com.lanou.entity.Address;
import com.lanou.service.AddressService;
import com.lanou.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaozhichao on 2018/4/3.
 */
@Controller("addressController")
@RequestMapping("/user")
public class AddressController {
    @Autowired
    private AddressService addressService;
    // 添加收货地址请求
    @RequestMapping("/addAddress")
    public void addAddress(HttpServletResponse response, Address address){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        int count = addressService.addAddress(address);
        String json = null;
        if (count > 0){
            json = Util.convertJson(1, "添加收货地址成功");
        }else {
            json = Util.convertJson(0, "添加收货地址失败");
        }
        writer.append(json);

    }
    // 修改地址
    @RequestMapping("/updateAddress")
    public void updateAddress(HttpServletResponse response, Address address){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        int count = addressService.updateAddress(address);
        String json = null;
        if (count > 0 ){
            json = Util.convertJson(1, "修改收货地址成功");
        } else {
            json = Util.convertJson(0, "修改收货地址失败");
        }
       writer.append(json);
    }
    // 订单中的地址添加 添加部分信息并显示所有的收货地址
    @RequestMapping("/insertSelective")
    public void insertSelective(HttpServletResponse response, Address address){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        int count = addressService.insertSelective(address);
        List<Address> addresses = addressService.lookAddress(address.getUserId());
        String json = null;
        if(count > 0 ){
            json = Util.creatJson(1, "添加成功", addresses);
        } else {
            json = Util.creatJson(1, "添加失败", addresses);
        }
        writer.append(json);
    }
    // 查询默认地址
    @RequestMapping("/lookDefault")
    public void selectDefaultAddress(HttpServletResponse response){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        Address address = addressService.selectDefaultAddress();
        if (address == null){
            json = Util.creatJson(1, "查询默认地址失败", address);
        }else {
            json = Util.creatJson(0, "查询默认地址成功", address);
        }
        writer.append(json);
    }
    // 更换默认地址\
    @RequestMapping("/updateDefault")
    public void  updateDefault(HttpServletResponse response, Address address){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        int count = addressService.updateDefault(address);
        if (count > 0){
            json = Util.convertJson(1, "修改默认地址成功");
        }else {
            json = Util.convertJson(0, "修改默认地址成失败");
        }
        writer.append(json);
    }
    // 删除地址
    @RequestMapping("/deleteAddress")
    @ResponseBody
    public void deleteAddress(HttpServletResponse response, int addressId){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        int count = addressService.deleteAddress(addressId);
        if(count > 0){
            json = Util.convertJson(1, "删除成功");
        } else {
            json = Util.convertJson(0, "删除失败");
        }
        writer.append(json);
    }
}
