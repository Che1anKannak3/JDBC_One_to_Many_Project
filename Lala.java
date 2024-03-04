package max;

import java.util.List;
import java.util.Map;

import max.DAO.ParentsDAO;
import max.DTO.ChildDTO;
import max.DTO.FatherDTO;

public class Lala {

public static void main(String[] args) {
	
	ParentsDAO p = new ParentsDAO();
	Map<String, Object> s = p.getParentsDetails();
	List<FatherDTO> fll = (List<FatherDTO>)s.get("Flist");
	List<ChildDTO> cll = (List<ChildDTO>)s.get("Clist");
	
	for(FatherDTO f:fll)
	{
		System.out.println("Father-----"+f.getFname()+" "+f.getAdd());
		
		for(ChildDTO c:cll)
		{
			if(f.getFid()==c.getFid())
			{
				System.out.println("Child--- "+c.getCname()+" "+c.getGndr());
			}
		}
	}
	
}
	
	
	
	
}
