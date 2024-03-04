package max.Bean;

import java.util.List;

public class FatherBean {

	private String fname;
	private String add;
	
	List<ChildBean> clist;
	
	
	
	public List<ChildBean> getClist() {
		return clist;
	}
	public void setClist(List<ChildBean> clist) {
		this.clist = clist;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	
	
	
	
	
}
