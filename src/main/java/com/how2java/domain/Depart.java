package com.how2java.domain;

public class Depart {
    private Integer id;

    private String departname;

    private String description;

    private Integer personcount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname == null ? null : departname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getPersoncount() {
        return personcount;
    }

    public void setPersoncount(Integer personcount) {
        this.personcount = personcount;
    }
}