package model;

import java.io.Serializable;

public class WillGo implements Serializable {
    private int willGoID;
    private int postID;
    private int userID;
    private String willGoDate;

    public WillGo(int postID, int userID, String willGoDate) {
        this.postID = postID;
        this.userID = userID;
        this.willGoDate = willGoDate;
    }

    public WillGo() {

    }

    public void WillGoID(int willGoID) {
        this.willGoID = willGoID;
    }

    public int getWillGoID() {
        return this.willGoID;
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

    public void setWillGoDate(String willGoDate) {
        this.willGoDate = willGoDate;
    }

    public String getWillGoDate() {
        return this.willGoDate;
    }

}
