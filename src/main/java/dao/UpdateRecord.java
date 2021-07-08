package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateRecord {
	
	
	private static Connection getConnection() throws URISyntaxException, SQLException {
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	

//	タイトルの更新
	public static void Title(String old_title,String new_title){
		
		PG pos = new PG();
		
//2つのSQLを一気に実行できなかったので、アクションを分けてみた		
		try (Connection con = UpdateRecord.getConnection()) {

//			db:t1を書き変える
			String sql ="update t1 set title=? where title=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,new_title );
			ps.setString(2,old_title );
			
			ps.executeQuery();
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try (Connection con = UpdateRecord.getConnection()) {

//			db:t2を書き変える
			String sql ="update t2 set title=? where title=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,new_title );
			ps.setString(2,old_title );
			
			ps.executeQuery();
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
//	idからコンテンツを取得
	public static String get(String s_id) {
		
		PG pos = new PG();
		int id = Integer.parseInt(s_id);
		String fragment="";
		
		try (Connection con = UpdateRecord.getConnection()) {

//			db:t2を書き変える
			String sql ="select fragment from t2 where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id );
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				fragment = rs.getString("fragment");
			}
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fragment;
	}
	
	
//	メモの更新
	public static void fragment(String s_id,String new_f){
		
		PG pos = new PG();
		
		int id = Integer.parseInt(s_id);
		
		try (Connection con = UpdateRecord.getConnection()) {

//			db:t2を書き変える
			String sql ="update t2 set fragment=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,new_f );
			ps.setInt(2,id );
			
			ps.executeQuery();
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
