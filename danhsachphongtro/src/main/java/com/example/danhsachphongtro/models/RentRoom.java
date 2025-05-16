package com.example.danhsachphongtro.models;

public class RentRoom {
    private int id;
    private String tenantName;
    private String phoneNumber;
    private String startDate;
    private int paymentTypeId;
    private String paymentTypeName;
    private String note;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTenantName() { return tenantName; }
    public void setTenantName(String tenantName) { this.tenantName = tenantName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public int getPaymentTypeId() { return paymentTypeId; }
    public void setPaymentTypeId(int paymentTypeId) { this.paymentTypeId = paymentTypeId; }

    public String getPaymentTypeName() { return paymentTypeName; }
    public void setPaymentTypeName(String paymentTypeName) { this.paymentTypeName = paymentTypeName; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
