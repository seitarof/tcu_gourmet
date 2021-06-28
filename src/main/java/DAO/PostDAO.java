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
}
