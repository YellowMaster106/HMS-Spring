package com.health.pojo;

import java.io.Serializable;

public class TbUser implements Serializable {
    private Integer id;

    private String keyword;

    private String phonenumber;

    private Integer idIdentity;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", keyword=").append(keyword);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", idIdentity=").append(idIdentity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}