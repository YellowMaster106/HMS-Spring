package com.health.request;

public class ResidentUserRequest {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getIdIdentity() {
        return idIdentity;
    }

    public void setIdIdentity(Integer idIdentity) {
        this.idIdentity = idIdentity;
    }

    private String name;
    private Integer idAddress;
    //
    private String keyword;
    private String phonenumber;
    private Integer idIdentity;
}
