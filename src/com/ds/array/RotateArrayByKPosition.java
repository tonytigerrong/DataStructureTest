package com.ds.array;

import java.util.Arrays;

public class RotateArrayByKPosition {

	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6};
		rotateBruteForce(nums,3);
	}
	public static int[] rotateBruteForce(int[] nums, int k) {
		 for (int i = 0; i < k; i++) { 
			 for (int j = nums.length - 1; j > 0; j--) {
				 // move each number by 1 place
				 int temp = nums[j];
				 nums[j] = nums[j - 1];
				 nums[j - 1] = temp;
			 }
			 System.out.println("Array rotation after "+(i+1)+" step");
			 
			 System.out.println();
		 }
		 printArray(nums);
		 return nums;
	}
	
	public static void printArray(int[] ns){
		Arrays.stream(ns).forEach(
					(a) -> System.out.println("("+a+")")
				);
	}
}
