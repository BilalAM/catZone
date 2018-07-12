package com.bilal.catZone.models;


import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;

    private String postMessage;

    private String postImageContentPath;

    private int likes;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Owner owner;


    private Post() {

    }

    public Post(String postMessage) {

    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostMessage() {
        return postMessage;
    }

    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }

    public String getPostImageContentPath() {
        return postImageContentPath;
    }

    public void setPostImageContentPath(String postImageContentPath) {
        this.postImageContentPath = postImageContentPath;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return postId + " --- " + postMessage + " --- " + postImageContentPath;
    }


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}
