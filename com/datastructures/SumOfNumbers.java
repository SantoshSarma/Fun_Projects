//$Id$
package com.datastructures;

public class SumOfNumbers {

	static String numbers="1,2,3,4,5,6,7,8,9,10";
	public static void main(String[] args) {
		int start=0,end=0;
		int sum=0;
		for(int i=0;i<numbers.length();i++) {
			if(i==0) {
				start=0;
			} 
			if(numbers.charAt(i)==','||i==numbers.length()-1) {
				if(i==numbers.length()-1)
					i++;
				int num=getNumber(start,i);
				start=i+1;
				sum+=num;
			}
		}
		System.out.println(sum);
	}
	
	static int getNumber(int start,int end) {
		return Integer.parseInt(numbers.substring(start, end));
	}

}
