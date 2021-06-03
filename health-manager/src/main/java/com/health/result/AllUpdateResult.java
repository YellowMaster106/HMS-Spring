package com.health.result;

public class AllUpdateResult {
    private int id;
    private String content;
    private String title;
    private String name;
    private String phonenumber;
    private String address;
    private int idIdentity;
    private String keyword;
    private String identity;
    private int idHospital;

    public int getIdHospital(){
        return idHospital;
    }

    public void setIdHospital(int idHospital){
        this.idHospital = idHospital;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getIdIdentity() {
        return idIdentity;
    }

    public void setIdIdentity(int idIdentity) {
        this.idIdentity = idIdentity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


}
