package com.ds.array;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
 
public class SlidingWindowMax {
 
	static int[] sarr;
 
	public static void main(String[] args) {
 
//		Scanner scn = new Scanner(System.in);
//		int[] arr = new int[scn.nextInt()];
// 
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = scn.nextInt();
//		}
// 
//		System.out.print("arr[]: {");
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(" "+arr[i]);
//		}
// 
//		System.out.println(" }");
// 
//		int windowSize = scn.nextInt();
 
		int[] arr = new int[6];
		int i=0;
		while(i<6){
			arr[i] = ThreadLocalRandom.current().nextInt(0,10);
			i++;
		}
		solveEfficient(arr, 3);
 
	}
 
	public static void solveEfficient(int[] arr, int k) {
		LinkedList<Integer> deque = new LinkedList<>();
 
		for (int i = 0; i < arr.length; i++) {
 
			/* keep removing the elements from deque 
			 * which are smaller than the current element, 
			 * because we need to keep our deque sorted in dec order 
			 */
			while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i]) {
				deque.removeLast();
			}
 
			/* removing the i-k element, because that element does not belong 
			 * to the subarray we are currently working on.
			 */
			while (!deque.isEmpty() && deque.getFirst() <= i - k) {
				deque.removeFirst();
			}
 
			deque.addLast(i);
 
			if(i >= k-1)
			{   
			/* only print when we have processed atleast k elements 
			 * to make the very first subarray
			 */
				System.out.print(" "+arr[deque.getFirst()]);
			}
 
		}
	}
}
