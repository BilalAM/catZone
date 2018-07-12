package com.bilal.catZone.models;


import com.bilal.catZone.models_embedded.Address;
import com.bilal.catZone.models_embedded.OwnerImage;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ownerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Role role;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "catId")
    private List<Cat> cats = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    @JoinColumn(name = "followerId")
    private List<Owner> followers = new ArrayList<>();

    @Embedded
    private OwnerImage ownerImage;

    private String ownerEmail;

    private String ownerName;

    private String ownerPassword;

    private boolean isFirstTime;

    private Owner() {

    }

    public Owner(String name) {
        this.ownerName = name;
    }

    public Owner(String name, OwnerImage ownerImage) {
        this.ownerName = name;
        this.ownerImage = ownerImage;
    }

    public Owner ownerFactory(String ownerName) {
        Owner owner = new Owner(ownerName);
        return this;
    }

    // Getter And Setters.. nothing much about a user..

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }


    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(Cat... cats) {
        this.cats = List.of(cats);
    }

    public OwnerImage getOwnerImage() {
        return ownerImage;
    }

    public void setOwnerImage(OwnerImage ownerImage) {
        this.ownerImage = ownerImage;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }


    public String getOwnerPassword() {
        return ownerPassword;
    }

    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Owner> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Owner> followers) {
        this.followers = followers;
    }


    public boolean getFirstTime() {
        return isFirstTime;
    }

    public void setIsFirstTime(boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }
}
