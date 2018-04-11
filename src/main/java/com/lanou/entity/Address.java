package com.lanou.entity;

/**
 * Created by gaozhichao on 2018/4/3.
 */
public class Address {
    private int addressId;
    // 用户Id
    private int userId;
    // 收货人姓名
    private String consName;
    // 收货人电话
    private String consPhone;
    // 省份
    private String province;
    // 城市
    private String city;
    // 县级
    private String county;
    // 详细地址
    private String detAddress;
    //邮箱
    private int zipCode;
    // 是否设置为默认地址
    private int isDefault;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDetAddress() {
        return detAddress;
    }

    public void setDetAddress(String detAddress) {
        this.detAddress = detAddress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public Address() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getConsName() {
        return consName;
    }

    public void setConsName(String consName) {
        this.consName = consName;
    }

    public String getConsPhone() {
        return consPhone;
    }

    public void setConsPhone(String consPhone) {
        this.consPhone = consPhone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", consName='" + consName + '\'' +
                ", consPhone='" + consPhone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", detAddress='" + detAddress + '\'' +
                ", zipCode=" + zipCode +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}
