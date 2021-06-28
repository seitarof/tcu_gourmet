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
			String sql = "SELECT GOOD_ID, POST_ID, USER_ID, GOOD_COUNT";
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
}
