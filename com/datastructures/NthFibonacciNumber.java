//$Id$
package com.datastructures;

public class NthFibonacciNumber {

	public static void main(String[] args) {
		
		int n=8;
		int a=-1,b=1,c=0;
		while(n>0) {
			c=a+b;
			a=b;
			b=c;
			n--;
		}
		System.out.println(c);
		fibonacci(8);
		System.out.println(cd);

	}
	
	static int cd=0,a=-1,b=1;
	static void fibonacci(int n) {
		if(n==0)
			return;
		cd=a+b;
		a=b;
		b=cd;
		fibonacci(n-1);
	}

}
