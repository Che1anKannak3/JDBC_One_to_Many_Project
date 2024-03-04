package max;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtilityJDBC {

	private UtilityJDBC()
	{
		
	}
	private static Connection con;
	
	static
	{
		try {
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "Postgres");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnnnnnnn()
	{
		return con;
		
	}
	
	public static int getCID(Connection con)
	{
		try {
			
			PreparedStatement ps = con.prepareStatement("select max(cid) as cd from c_mst");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int cid = rs.getInt("cd");
				return cid+1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
      
	
}


















