package Amz_Nov_2018;

import Amz_Onsite_Jan_2019.EmailRead;

public class CodeTester {
	public static void main(String[] args) {
		Emp e1 = new Emp("e1",1,0);
		
		Emp e2 = new Emp("e2",5,0);
		Emp e3 = new Emp("e3",5,0);
		Emp e4 = new Emp("e4",10,0);
		
		
		Emp e5 = new Emp("e5",15,0);
		Emp e6 = new Emp("e6",20,0);
		
		Emp e7 = new Emp("e7",15,0);
		Emp e8 = new Emp("e8",10,0);
		Emp e9 = new Emp("e9",5,0);
		
		Emp e10 = new Emp("e10",20,0);
		Emp e11 = new Emp("e11",5,0);
		
		
		
		Emp[] r1 = {e2,e3,e4};
		Emp[] r2 = {e5,e6};
		
		Emp[] r3 = {e7,e8,e9};
		Emp[] r4 = {e10,e11};
		
		e1.reportees = r1;
		
		e2.reportees = r2;
		
		e3.reportees = r3;
		
		e4.reportees = r4;
		
		EmailRead er = new EmailRead(e1);
		
		while(er.hasNext())
		{
			Emp ee = er.next();
			System.out.println(ee.name +"," + String.valueOf((ee.efficiency+ee.rollingTimeTaken)));
		}
		
	}
}
