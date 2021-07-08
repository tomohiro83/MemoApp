package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Edit {
	
	
	private static Connection getConnection() throws URISyntaxException, SQLException {
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	

	public static void frag_Delete(String s_id) {
		
		PG pos = new PG();
		
		try (Connection con = Edit.getConnection()) {

			String sql = "delete from t2 where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			int id = Integer.parseInt(s_id);			
			ps.setInt(1,id);

			ResultSet rs = ps.executeQuery();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void title_Delete(String title) {
		
		PG pos = new PG();
		
		try (Connection con = Edit.getConnection()) {

			String sql = "delete from t1 where title=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, title);

			ResultSet rs = ps.executeQuery();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void all_Delete(String title) {
		
		PG pos = new PG();
		
		try (Connection con = Edit.getConnection()) {

			String sql = "delete from t2 where title=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,title);

			ResultSet rs = ps.executeQuery();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
