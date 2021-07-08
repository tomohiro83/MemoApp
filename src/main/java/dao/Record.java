package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Fragments;
import util.Today;

public class Record {
	
	
	private static Connection getConnection() throws URISyntaxException, SQLException {
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	

//	db:t1にタイトルを登録するメソッド
	public static void title_push(String title) {

		PG pos = new PG();

		try (Connection con = Record.getConnection()) {

			String sql = "insert into t1 values(?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, title);

			ResultSet rs = ps.executeQuery();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
//	db:t1からタイトル一覧を取得する（HOME画面）
	public static List<Fragments> getTitle(){
		
		PG pos = new PG();
		List<Fragments> list = new ArrayList<>();
		
		try (Connection con = Record.getConnection()) {

			String sql ="select title from t1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				Fragments frag = new Fragments();
				frag.setTitle(rs.getString("title"));
				list.add(frag);
			}
			

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		"新しい順"にする
		Collections.reverse(list);
		return list;
		
	}

	
//	db:t2からidの末尾を取得するメソッド
	public static int get_id() {
		
		PG pos = new PG();
		int id =0;
		
		try (Connection con = Record.getConnection()) {

			String sql ="select id from t2 order by id desc limit 1";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
			}
			
			id++;

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	

//	db:t2にメモを登録するメソッド
	public static void frag_push(String title,String fragment) {

		PG pos = new PG();

		try (Connection con = Record.getConnection()) {

//			idの末尾を取得
			int id = Record.get_id();
			String dotw = Today.dotw();

			String sql = "insert into t2 values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);
			
			String day = Today.get();
			ps.setString(2, day);
			
			ps.setString(3, title);
			ps.setString(4, fragment);

			ResultSet rs = ps.executeQuery();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
//	db:t2からメモ一覧を取得する
	public static List<Fragments> get(String title){
		
		PG pos = new PG();
		List<Fragments> list = new ArrayList<>();
		
		try (Connection con = Record.getConnection()) {

			String sql ="select * from t2 where title = ? order by id asc";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				Fragments frag = new Fragments();
				frag.setId(rs.getInt("id"));
				frag.setDay(rs.getString("day"));
				frag.setTitle(rs.getString("title"));
				frag.setFragment(rs.getString("fragment").replaceAll("\n", "<br>").replaceAll("(https?://.*\\b)", "<a href=\"$1\" target=\"_blank\">$1</a>"));
				list.add(frag);
			}
			

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		"新しい順"にする
		Collections.reverse(list);
		return list;

	}
	
	
//	idからメモを取得する
	public static String change_id_fragment(String s_id) {
		
		PG pos = new PG();
		
		String fragment ="";
		int id =Integer.parseInt(s_id);
		
		try (Connection con = Record.getConnection()) {

			String sql ="select fragment from t2 where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				fragment = rs.getString("fragment");
			}
			

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fragment;
		
	}
	
	

}
