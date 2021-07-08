package dao;

class PG {

	private String url = "jdbc:postgresql://localhost/postgres";
	private String user ="postgres";
	private String pass ="wonda9127";
	
	public String getUrl() {
		return url;
	}
	public String getUser() {
		return user;
	}
	public String getPass() {
		return pass;
	}
}
