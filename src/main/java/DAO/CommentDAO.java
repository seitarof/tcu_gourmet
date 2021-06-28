package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment;

public class CommentDAO implements DAO {
	public List<Comment> findAll() {
		List<Comment> goodList = new ArrayList<>();
		
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備
			String sql = "SELECT COMMENT_ID, POST_ID, USER_ID, COMMENT";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容をCommentインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int commentID = rs.getInt("COMMENT_ID");
				int postID = rs.getInt("POST_ID");
				int userID = rs.getInt("USER_ID");
				String comment = rs.getString("COMMENT");
				Comment comm = new Comment(commentID, postID, userID, comment);
				goodList.add(comm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return goodList;
	}
	
	public Boolean createComment(Comment comment) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {			
			// INSERT文を準備
			String sql = "INSERT INTO POST(POST_ID, USER_ID, COMMENT) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setInt(1, comment.getPostID());
			pStmt.setInt(2, comment.getUserID());
			pStmt.setString(3, comment.getComment());
			
			//INSERTを実行
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean updateComment() {
		// TODO
		return true;
	}
	
	public Boolean deleteComment(int comment_id) {
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// DELETE文を準備
			String sql = "DELETE FROM COMMENT WHERE COMMENT_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, comment_id);
			
			//DELETEを実行し、結果表を取得
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
