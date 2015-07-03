//$Id$
package com.datastructures;

public class FindUniqueCharacters {

	static String s="abcdeabcdeabcdeabcdeabcde",s1="";
	public static void main(String[] args) {
		int i=0,j=0;
		while(i<s.length()) {
			char ch=s.charAt(i);
			boolean b=isExist(ch);
			if(!b) {
				j++;
			} 
			if(j==4) {
				System.out.println("4th repeated character "+ch+" @ index "+i);
				break;
			}
			i++;
		}
		System.out.println(s1);
	}
	
	static boolean isExist(char c) {
		int i=0;
		boolean b=false;
		while(i<s1.length()) {
			char ch1=s1.charAt(i);
			if(c==ch1) {
				b=true;
				break;
			}//if(c==ch1)
			i++;
		}
		
		if(!b) {
			String s3=new String(new char[]{c});
			s1+=s3;
			return true;
		} else {
			return false;
		}
	}

}
