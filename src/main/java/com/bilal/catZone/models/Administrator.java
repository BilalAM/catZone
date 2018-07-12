package com.bilal.catZone.models;


import javax.persistence.*;
import javax.validation.OverridesAttribute;
import java.util.List;

@Entity
@DiscriminatorColumn(name = "AType")
@AttributeOverride(name = "userId",column = @Column(name = "userId"))
public class Administrator extends User {


    @OneToMany
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
