package model;

import java.io.Serializable;

public class Post implements Serializable {
    private int postID;
    private int userID;
    private String shopName;
    private String review;
    private String photoPath;
    private int goodCount;
    private int commentCount;

    public Post(){
        
    }
    
    public Post(int postID, int userID, String shopName, String review, String photoPath) {
        this.postID = postID;
        this.userID = userID;
        this.shopName = shopName;
        this.review = review;
        this.photoPath = photoPath;
    }
    
    public Post(int userID, String shopName, String review, String photoPath) {
        this.userID = userID;
        this.shopName = shopName;
        this.review = review;
        this.photoPath = photoPath;
    }


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
        return this.shopName;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReview() {
        return this.review;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoPath() {
        return this.photoPath;
    }

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
        return this.commentCount;
    }

}
