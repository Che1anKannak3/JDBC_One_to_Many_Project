package max.BO;

import java.util.ArrayList;
import java.util.List;

import max.Bean.ChildBean;
import max.Bean.FatherBean;
import max.DAO.ParentsDAO;
import max.DTO.ChildDTO;
import max.DTO.FatherDTO;

public class ParentsBOIMPL implements ParentsBO {

	@Override
	public boolean getParentsDetails(FatherBean fatherBean) {
		
		List<ChildDTO> ll = new ArrayList<ChildDTO>();
		String fn = fatherBean.getFname();
		fn=fn.substring(0, 1).toUpperCase()+fn.substring(1).toLowerCase();
		
		FatherDTO fdto = new FatherDTO();
		fdto.setFname(fn);
		fdto.setAdd(fatherBean.getAdd().toLowerCase());
		
		List<ChildBean> clist = fatherBean.getClist();
		
		for(ChildBean p:clist)
		{
			ChildDTO cdto = new ChildDTO();
			cdto.setCname(p.getCname().toUpperCase());
			cdto.setGndr(p.getGndr().toUpperCase());
			ll.add(cdto);
		}
		
		
		return new ParentsDAO().insertParentsDetails(fdto, ll);
	}

}
