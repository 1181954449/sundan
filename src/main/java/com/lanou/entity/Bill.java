package com.lanou.entity;

/**
 * Created by lanou on 2018/4/4.
 */
public class Bill {
    // 发票类
    private int billId;
    private String billCompanyName;
    private String billCompanyAddress;
    private String billOpenBank;
    private String billPayTaxes;
    private String billBankCard;
    private String billBankCardPhone;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillCompanyName() {
        return billCompanyName;
    }

    public void setBillCompanyName(String billCompanyName) {
        this.billCompanyName = billCompanyName;
    }

    public String getBillCompanyAddress() {
        return billCompanyAddress;
    }

    public void setBillCompanyAddress(String billCompanyAddress) {
        this.billCompanyAddress = billCompanyAddress;
    }

    public String getBillOpenBank() {
        return billOpenBank;
    }

    public void setBillOpenBank(String billOpenBank) {
        this.billOpenBank = billOpenBank;
    }

    public String getBillPayTaxes() {
        return billPayTaxes;
    }

    public void setBillPayTaxes(String billPayTaxes) {
        this.billPayTaxes = billPayTaxes;
    }

    public String getBillBankCard() {
        return billBankCard;
    }

    public void setBillBankCard(String billBankCard) {
        this.billBankCard = billBankCard;
    }

    public String getBillBankCardPhone() {
        return billBankCardPhone;
    }

    public void setBillBankCardPhone(String billBankCardPhone) {
        this.billBankCardPhone = billBankCardPhone;
    }

    public Bill() {
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", billCompanyName='" + billCompanyName + '\'' +
                ", billCompanyAddress='" + billCompanyAddress + '\'' +
                ", billOpenBank='" + billOpenBank + '\'' +
                ", billPayTaxes='" + billPayTaxes + '\'' +
                ", billBankCard='" + billBankCard + '\'' +
                ", billBankCardPhone='" + billBankCardPhone + '\'' +
                '}';
    }
}
