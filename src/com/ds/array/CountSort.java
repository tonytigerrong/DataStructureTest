package com.ds.array;

import java.util.Arrays;

public class CountSort {
	
	private static int[]  countsort(int[] arr) {
		int max=arr[0];
		int min=arr[0];
		
		//step1:得到最大值和最小值，确定构建的数组长度
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i]>max) {
				max=arr[i];
			}
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		
		//step2:构建一个数组，用来存放每一个数对应出现的次数
		int d=max-min;
		int [] countArray=new int [d+1];
		//统计次数
		for (int i = 0; i < arr.length; i++) {
			countArray[arr[i]-min]++;
		}
		System.out.println("统计不同元素出现的次数："+Arrays.toString( countArray));
		
		//step3:对此时的数组做变形,统计数组从第二个元素开始，每一个元素等于它本身都加上前面所有元素之和。
		for(int i=1;i<countArray.length;i++) {
			countArray[i]+=countArray[i-1];
		}
		System.out.println("变形后的数组："+Arrays.toString( countArray));
		
		//step4:倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组,确保稳定性
		int[] sortedArray = new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			
			sortedArray[countArray[arr[i]-min]-1]=arr[i];
			countArray[arr[i]-min]--;
			
		}
		return sortedArray;
	}
	
	public static void main(String[] args) {
		int arr[]={93,95,98,98,94,92,96,91};
		int[] sortedArray=countsort(arr);
		System.out.println("结果输出："+Arrays.toString(sortedArray));
	}
 
}
