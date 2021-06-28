package model;

import java.io.Serializable;

public class WillGo implements Serializable {
    private int willGoID;
    private int postID;
    private int userID;
    private int willGoDate;

    public WillGo(int willGoID, int postID, int userID, int willGoDate) {
        this.willGoID = willGoID;
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

    public void setWillGoDate(int willGoDate) {
        this.willGoDate = willGoDate;
    }

    public int getWillGoDate() {
        return this.willGoDate;
    }

}
