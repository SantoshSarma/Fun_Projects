//$Id$
package com.datastructures;

public class StringReverse {

	static StringBuffer name=new StringBuffer("India is my country");
	public static void main(String[] args) {
		
		int start=0,end=0;
		for(int i=0;i<name.length();i++) {
			if(i==0) {
				start=0;
			} 
			if(name.charAt(i)==' '||i==name.length()-1) {
				end=i;
				if(i==name.length()-1)
					end=i;
				else
					end--;
				swap(start,end);
				start=i+1;
			}
		}
		System.out.println(name.toString());
		swap(0,name.length()-1);
		System.out.println(name);
	}
	
	static void swap(int start,int end) {
		while(start<end) {
			char temp=name.charAt(start);
			name.setCharAt(start, name.charAt(end));
			name.setCharAt(end, temp);
			start++;
			end--;
		}
	}

}
