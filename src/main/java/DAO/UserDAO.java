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
				User user = new User(name, userID, email, pass, admin);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}

	public Boolean createUser(User user) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// INSERT文を準備
			String sql = "INSERT INTO USER(NAME, PASS, EMAIL, ADMIN) VALUES(?, ?, ?, false)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// INSERT文中の「？」に使用する値を設定しSQLを完成
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getHashedPass());
			pStmt.setString(3, user.getEmail());
			
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
	
	public User readUser(String emailString) {
		User user = null;
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// SELECT文を準備
			String sql = "SELECT USER_ID, NAME, PASS, EMAIL, ADMIN FROM USER WHERE EMAIL = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emailString);
			
			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表に格納されたレコードの内容をUserインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int userID = rs.getInt("USER_ID");
				String name = rs.getString("NAME");
				String pass = rs.getString("PASS");
				String email = rs.getString("EMAIL");
				Boolean admin = rs.getBoolean("ADMIN");
				user = new User(name, userID, email, pass, admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	public Boolean updateUser(String name, String pass, String email, String admin) {
		// TODO 更新メソッドを書く
		return false;
	}
	
	public Boolean deleteUser(String emailString) {
		// DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			// DELETE文を準備
			String sql = "DELETE FROM USER WHERE EMAIL = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, emailString);
			
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
