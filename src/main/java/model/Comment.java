package model;

public class Comment {
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
        return postID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

}
