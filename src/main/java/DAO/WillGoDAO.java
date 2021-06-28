package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.WillGo;

public class WillGoDAO implements DAO {
	public List<WillGo> findAll() {
		List<WillGo> willGoList = new ArrayList<>();
		
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備
			String sql = "SELECT WILLGO_ID, POST_ID, USER_ID, GOOD_COUNT";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容をCommentインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int willGoID = rs.getInt("WILLGO_ID");
				int postID = rs.getInt("POST_ID");
				int userID = rs.getInt("USER_ID");
				int willGoDate = rs.getInt("WILLGO_DATE");
				WillGo willGo = new WillGo(willGoID, postID, userID, willGoDate);
				willGoList.add(willGo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return willGoList;
	}
	
	public Boolean createWillGo(WillGo willGo) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {			
			// INSERT文を準備
			String sql = "INSERT INTO POST(POST_ID, USER_ID, WILLGO_DATE) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setInt(1, willGo.getPostID());
			pStmt.setInt(2, willGo.getUserID());
			pStmt.setInt(3, willGo.getWillGoDate());
			
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
	
	public Boolean updateWillGo() {
		// TODO
		return true;
	}
	
	public Boolean deleteWillGo(int willGo_id) {
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// DELETE文を準備
			String sql = "DELETE FROM WILLGO WHERE WILLGO_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, willGo_id);
			
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
