package com.yipai.pojo;

public class Sitename {
    private Integer id;

    private String icpRecordNumber;

    private String address;

    private String phone;

    private String companyName;

    private String siteName;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIcpRecordNumber() {
        return icpRecordNumber;
    }

    public void setIcpRecordNumber(String icpRecordNumber) {
        this.icpRecordNumber = icpRecordNumber == null ? null : icpRecordNumber.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}