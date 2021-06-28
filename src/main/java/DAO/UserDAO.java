package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO implements DAO {	
	public List<User> findAll() {
		List<User> userList = new ArrayList<>();
		
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備
			String sql = "SELECT USER_ID, NAME, PASS, EMAIL, ADMIN";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容をUserインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int userID = rs.getInt("USER_ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String email = rs.getString("EMAIL");
				Boolean admin = rs.getBoolean("ADIMN");
				User user = new User(userID, name, pass, email, admin);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}

}
