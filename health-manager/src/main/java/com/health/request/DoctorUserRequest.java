package com.health.request;

public class DoctorUserRequest {
    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(Integer idHospital) {
        this.idHospital = idHospital;
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

    private Integer idDoctor;
    //
    private String name;
    private Integer status;
    private Integer idHospital;
    //
    private String keyword;
    private String phonenumber;
    private Integer idIdentity;
}
