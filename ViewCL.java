package max;

import java.util.List;

import max.DAO.ParentsDAO;
import max.DTO.ParentsDTO;

public class ViewCL {

	public static void main(String[] args) {
		
		ParentsDAO parentsDAO = new ParentsDAO();
		List<ParentsDTO> lis = parentsDAO.getParentsDetails(1);
		
		for(ParentsDTO q:lis)
		{
			System.out.println(q.getFname()+" "+q.getAdd()+" "+q.getCname()+" "+q.getGndr());
		}
		
		
	}
	
	
	
	
}
