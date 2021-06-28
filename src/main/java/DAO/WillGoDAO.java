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
}
