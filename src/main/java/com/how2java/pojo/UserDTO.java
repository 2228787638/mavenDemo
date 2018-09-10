package com.how2java.pojo;

import com.how2java.domain.Depart;
import com.how2java.domain.User;

public class UserDTO extends User{
    /**
     * 用户部门
     */
    private Depart depart;

    public Depart getDepart() {
        return depart;
    }

    public void setDepart(Depart depart) {
        this.depart = depart;
    }
}
