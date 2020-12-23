package com.corejava;

public class ParamsTest {
	ParamsTest psi;
	int i = 5;
	void test(ParamsTest pt){
		i = pt.i;
		pt.i = 5;
		System.out.println("i,in"+this.i);
	}
	void test2(int i){
		this.i = i;
		System.out.println("i,in"+this.i);
	}
	public static void main(String[] args){
		ParamsTest ps = new ParamsTest();
		/**
		 *  test if object1 = object2; object1 = object3 then the three objects refer to the same mem address
		 *  and if you change any one, all of three changed
		 */
		
		ParamsTest ps_copy = ps;
		ParamsTest ps_copy2 = ps;
		System.out.println("ps_copy is:"+ps_copy.i);
		System.out.println("ps_copy2 is:"+ps_copy2.i);
		ps.i = 1;
		System.out.println("ps_copy is:"+ps_copy.i);
		System.out.println("ps_copy2 is:"+ps_copy2.i);
		ps_copy.i = 2;
		System.out.println("ps is:"+ps.i);
		System.out.println("ps refer address should be same as ps_copy and ps_copy2");
		System.out.println("ps refer address" + ps + "\r\n"+
				           "ps_copy refer address"+ ps_copy+"\r\n"+
				           "ps_copy2 refer address"+ ps_copy2);
		/**
		 * 
		 */
		ps.i = 6;
		ps.test(ps);
		ps.i = 6;
		ps.test2(ps.i);
		System.out.println("i,out"+ps.i);
		ParamsTest ps1 = ps;
		ps.i = 10;
		System.out.println("ps1.i,out"+ps1.i);
		
		/**
		 * 
		 */
		ParamsTest pt1 = new ParamsTest(); pt1.i = 1;
		ParamsTest pt2 = new ParamsTest(); pt2.i = 2;
		ParamsTest pt3 = new ParamsTest(); pt3.i = 3;
		ParamsTest pt4 = new ParamsTest(); pt4.i = 4;
		ParamsTest pt5 = new ParamsTest(); pt5.i = 5;
		
		ParamsTest temp = pt1; // assign the address of pt1 to temp, so both temp and pt1 refer to the same mem address of object pool
		
		for(int i=0 ; i<4 ; i++){
			switch(i){
			case 0:
				//temp's address not changed, just change inner property of psi
				temp.psi = pt2; // this change will affect pt1 outside the loop
				continue;
			case 1:
				// temp's address changed to pt3's address, so temp and pt3 refer to same object
				temp = pt3; // this change will not affect pt1, since temp is refer to different object, not refer the same object with pt1 any more
				continue;
//			case 2:
//				temp = temp.psi; // temp's address changed
//				continue;
			default:
				continue;
			}
		}

	}
}
