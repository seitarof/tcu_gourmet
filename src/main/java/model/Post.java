package model;

import java.io.Serializable;

public class Post implements Serializable{
    private int postID;
    private int userID;
    private String shopName;
    private String review;
    // フィールドにvarは許されないらしい
    // private var photo;
    private int goodCount;
    private int commentCount;

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getPostID() {
        return this.postID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReview() {
        return this.review;
    }

    // public void setPhoto(var photo){
    // this.photo = photo;
    // }

    // public var getPhoto(){
    // return this.photo;
    // }

    public void setGoodCount(int goodCount) {
        this.goodCount = goodCount;
    }

    public void plusGoodCount() {
        this.goodCount++;
    }

    public int getGoodCount() {
        return this.goodCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void plusCommentCount() {
        this.commentCount++;
    }

    public int getCommentCount() {
        return commentCount;
    }

}
