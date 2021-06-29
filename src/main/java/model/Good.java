package model;

import java.io.Serializable;

public class Good implements Serializable {
    private int goodID;
    private int postID;
    private int userID;
    private int goodCount;

    public Good(int goodID, int postID, int userID, int goodCount) {
        this.goodID = goodID;
        this.postID = postID;
        this.userID = userID;
        this.goodCount = goodCount;
    }
    
    public Good(int postID, int userID) {
        this.postID = postID;
        this.userID = userID;
        this.goodCount = 0;
    }

    public Good() {

    }

    public void setGoodID(int goodID) {
        this.goodID = goodID;
    }

    public int getGoodID() {
        return this.goodID;
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

    public void setGoodCount(int goodCount) {
        this.goodCount = goodCount;
    }

    public void plusGoodCount() {
        this.goodCount++;
    }

    public int getGoodCount() {
        return this.goodCount;
    }

}
