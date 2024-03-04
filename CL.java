package max;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import max.BO.ParentsBO;
import max.BO.ParentsBOIMPL;
import max.Bean.ChildBean;
import max.Bean.FatherBean;

public class CL {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		FatherBean f = new FatherBean();
		
		List<ChildBean> l = new ArrayList<ChildBean>();
		
		System.out.println("-------Enter Father Details------");
		System.out.println("Enter Father Name");
		String n = sc.nextLine();
		f.setFname(n);
		System.out.println("Enter Add");
		String ad = sc.nextLine();
		f.setAdd(ad);
		
		System.out.println("----Enter Child Details-----");
		while(true)
		{
			ChildBean cb = new ChildBean();
			System.out.println("Enter Child Name");
			String cn = sc.nextLine();
			cb.setCname(cn);
			System.out.println("Gnder");
			String gndr = sc.nextLine();
			cb.setGndr(gndr);
			l.add(cb);
			System.out.println("Y/N");
			String yn = sc.nextLine();
			if(yn.equalsIgnoreCase("N"))
			{
				break;
			}
		}
		
		f.setClist(l);
		
		ParentsBO parentsBO=new ParentsBOIMPL();
		if(parentsBO.getParentsDetails(f))
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("Failll");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
