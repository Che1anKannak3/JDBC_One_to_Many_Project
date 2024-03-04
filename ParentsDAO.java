package max.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import max.UtilityJDBC;
import max.DTO.ChildDTO;
import max.DTO.FatherDTO;
import max.DTO.ParentsDTO;

public class ParentsDAO {
	
	public List<ParentsDTO> getParentsDetails(int fid)
	{
		List<ParentsDTO> l = new ArrayList<ParentsDTO>();
		try {
			
			Connection con = UtilityJDBC.getConnnnnnnn();
			PreparedStatement ps = con.prepareStatement("select f.name as fname,  f.add, c.name as childname, c.gndr f.fid, c.cid from f_mst f inner join c_mst c on f.fid=c.fid where f.fid=?");
			ps.setInt(1, fid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ParentsDTO parentsDTO = new ParentsDTO();
				parentsDTO.setFname(rs.getString("fname"));
				parentsDTO.setAdd(rs.getString("add"));
                parentsDTO.setCname(rs.getString("childname"));
                parentsDTO.setFid(rs.getInt("fid"));
                parentsDTO.setCfid(rs.getInt("cid"));
                parentsDTO.setGndr(rs.getString("gndr").equalsIgnoreCase("M")?"Male":"Female");
                l.add(parentsDTO);
			}
			
		} catch (Exception e) {
           e.printStackTrace();
		}
		return l;
		
		
	}
	
	
	
	public  Map<String, Object> getParentsDetails()
	{
		List<FatherDTO> fl = new ArrayList<FatherDTO>();
        List<ChildDTO> cl = new ArrayList<ChildDTO>();
        
        Map<String, Object> m = new HashMap<String, Object>();
        
        
		try {
			
			Connection con = UtilityJDBC.getConnnnnnnn();
			PreparedStatement ps = con.prepareStatement("select * from f_mst");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				FatherDTO fd = new FatherDTO();
				fd.setFid(rs.getInt(1));
				fd.setFname(rs.getString(2));
				fd.setAdd(rs.getString(3));
				fl.add(fd);
				
			}
			
			ps=con.prepareStatement("select * from c_mst");
			rs=ps.executeQuery();
			while(rs.next())
			{
				ChildDTO childDTO = new ChildDTO();
				childDTO.setCname(rs.getString(2));
				childDTO.setGndr(rs.getString(3));
				childDTO.setFid(rs.getInt(4));
				cl.add(childDTO);
				m.put("Flist", fl);
				m.put("Clist", cl);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
		
	}
	
	
	
	
	
	

	public boolean insertParentsDetails(FatherDTO fatherDTO, List<ChildDTO> clist)
	{
		Connection con = UtilityJDBC.getConnnnnnnn();
		try {
			
			con.setAutoCommit(false);
			int cd = UtilityJDBC.getCID(con);
			int cdd = UtilityJDBC.getCID(con);
			PreparedStatement ps = con.prepareStatement("insert into f_mst values (?,?,?)");
			ps.setInt(1, cdd);
			ps.setString(2, fatherDTO.getFname());
			ps.setString(3, fatherDTO.getAdd());
			int i = ps.executeUpdate();
			
			if(i>0)
			{
				ps=con.prepareStatement("insert into c_mst values (?,?,?,?)");
				
				for(ChildDTO p:clist)
				{
				
				ps.setInt(1, ++cd);
				ps.setString(2, p.getCname());
				ps.setString(3, p.getGndr());
				ps.setInt(4, cdd);
				ps.addBatch();
				
				}
				int[] k = ps.executeBatch();
				if(k.length>0)
				{
					con.commit();
					return true;
				}
			}
			
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
		
		
		
		
//		System.out.println("DAO "+fatherDTO.getFname()+" "+fatherDTO.getAdd());
//		System.out.println("------Child------");
//		for(ChildDTO q:clist)
//		{
//			
//			System.out.println(q.getCname()+" "+q.getGndr());
//			
//		}
		
		return false;
		
	}
	
	
}
