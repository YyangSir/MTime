package com.yang.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Admin {
    @Id
    @Column(name = "adminId")
    private Integer adminid;

    private String name;

    private String password;

    private Integer privilege;

    @Override
    public String toString() {
        return "Admin{" +
                "adminid=" + adminid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", privilege=" + privilege +
                '}';
    }

    /**
     * @return adminId
     */
    public Integer getAdminid() {
        return adminid;
    }

    /**
     * @param adminid
     */
    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return privilege
     */
    public Integer getPrivilege() {
        return privilege;
    }

    /**
     * @param privilege
     */
    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }
}