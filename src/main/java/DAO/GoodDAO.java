package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Good;

public class GoodDAO implements DAO {	
	public List<Good> findAll() {
		List<Good> goodList = new ArrayList<>();
		
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備
			String sql = "SELECT GOOD_ID, POST_ID, USER_ID, GOOD_COUNT FROM GOOD GROUP BY POST_ID";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容をGoodインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int goodID = rs.getInt("GOOD_ID");
				int postID = rs.getInt("POST_ID");
				int userID = rs.getInt("USER_ID");
				int goodCount = rs.getInt("GOOD_COUNT");
				Good good = new Good(goodID, postID, userID, goodCount);
				goodList.add(good);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return goodList;
	}
	
	
	public Boolean createGood(Good good) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {			
			// INSERT文を準備
			String sql = "INSERT INTO GOOD(POST_ID, USER_ID, GOOD_COUNT) VALUES(?, ?, 0)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setInt(1, good.getPostID());
			pStmt.setInt(2, good.getUserID());
			
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
	
	public Boolean updateGood() {
		// TODO
		return true;
	}
	
	public Boolean deleteGood(int good_id) {
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// DELETE文を準備
			String sql = "DELETE FROM GOOD WHERE GOOD_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, good_id);
			
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
	
	public int goodCount(int postID) {
		int count = 0;
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備
			String sql = "SELECT COUNT(*) FROM GOOD WHERE POST_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, postID);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容をUserインスタンスに設定し、ArrayListインスタンスに追加
			rs.next();
			count = rs.getInt("COUNT(*)");
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return count;
	}
}
