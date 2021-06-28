package model;

import java.io.Serializable;

public class Comment implements Serializable {
    private int commentID;
    private int postID;
    private int userID;
    private String comment;

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getCommentID() {
        return this.commentID;
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

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }

}
