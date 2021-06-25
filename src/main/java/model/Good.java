package model;

public class Good {
    private int goodID;
    private int postID;
    private int userID;
    private int goodCount;

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
        return postID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setGoodCount(int goodCount) {
        this.goodCount = goodCount;
    }

    public void plusGoodCount() {
        this.goodCount++;
    }

    public int getGoodCount() {
        return goodCount;
    }

}
