package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostDAO implements DAO {	
	public List<Post> findAll() {
		List<Post> postList = new ArrayList<>();
		
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備
			String sql = "SELECT POST_ID, USER_ID, SHOP_NAME, REVIEW, PHOTO";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容をPostインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int postID = rs.getInt("POST_ID");
				int userID = rs.getInt("USER_ID");
				String shopName = rs.getString("SHOP_NAME");
				String review = rs.getString("REVIEW");
				String photoPath = rs.getString("PHOTO");
				Post post = new Post(postID, userID, shopName, review, photoPath);
				postList.add(post);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return postList;
	}
	
	public Post readPost(int postID) {
		Post post = null;
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備
			String sql = "SELECT POST_ID, USER_ID, SHOP_NAME, REVIEW, PHOTO FROM USER WHERE POST_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, postID);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容をUserインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int userID = rs.getInt("USER_ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String email = rs.getString("EMAIL");
				Boolean admin = rs.getBoolean("ADIMN");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return post;
	}
	
	
	public Boolean createPost(Post post) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {			
			// INSERT文を準備
			String sql = "INSERT INTO POST(USER_ID, SHOP_NAME, REVIEW, PHOTO) VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setInt(1, post.getUserID());
			pStmt.setString(2, post.getShopName());
			pStmt.setString(3, post.getReview());
			pStmt.setString(4, post.getPhotoPath());
			
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
	
	public Boolean updatePost(int userID, String shopName, String review, String photoPath) {
		// TODO 更新メソッドを書く
		return false;
	}
	
	public Boolean deletePost(int post_id) {
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// DELETE文を準備
			String sql = "DELETE FROM POST WHERE POST_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, post_id);
			
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
