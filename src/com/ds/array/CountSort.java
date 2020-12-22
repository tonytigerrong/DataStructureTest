package com.ds.array;

import java.util.Arrays;

public class CountSort {
	
	private static int[]  countsort(int[] arr) {
		int max=arr[0];
		int min=arr[0];
		
		//step1:�õ����ֵ����Сֵ��ȷ�����������鳤��
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i]>max) {
				max=arr[i];
			}
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		
		//step2:����һ�����飬�������ÿһ������Ӧ���ֵĴ���
		int d=max-min;
		int [] countArray=new int [d+1];
		//ͳ�ƴ���
		for (int i = 0; i < arr.length; i++) {
			countArray[arr[i]-min]++;
		}
		System.out.println("ͳ�Ʋ�ͬԪ�س��ֵĴ�����"+Arrays.toString( countArray));
		
		//step3:�Դ�ʱ������������,ͳ������ӵڶ���Ԫ�ؿ�ʼ��ÿһ��Ԫ�ص�������������ǰ������Ԫ��֮�͡�
		for(int i=1;i<countArray.length;i++) {
			countArray[i]+=countArray[i-1];
		}
		System.out.println("���κ�����飺"+Arrays.toString( countArray));
		
		//step4:�������ԭʼ���У���ͳ�������ҵ���ȷλ�ã�������������,ȷ���ȶ���
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
		System.out.println("��������"+Arrays.toString(sortedArray));
	}
 
}
