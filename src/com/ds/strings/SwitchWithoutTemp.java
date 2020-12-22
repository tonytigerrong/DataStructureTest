package com.ds.strings;

public class SwitchWithoutTemp {
	public static void main(String[] args){
		int a = 3;
		int b = 6;
		System.out.println("a:"+a+", b:"+b);
		a = a + b; //a = 9; b=6
		b = a - b; // b=3
		a = a - b; // a=6
		System.out.println("a:"+a+", b:"+b);
		
	}
}
