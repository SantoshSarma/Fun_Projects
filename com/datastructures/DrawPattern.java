//$Id$
package com.datastructures;

public class DrawPattern {
/*
 * Printing below pattern
					*				
			
				*	*	*			
			
			*	*	*	*	*
*/
	public static void main(String[] args) {
		int n=5;
		for(int i=n;i>=0;i--) {
			for(int j=0;j<n*2;j++) {
				if(j>=i && (i+j+1)<(n*2)) {
					System.out.print("*\t");
				}else{
					System.out.print("\t");
				}
			}
			System.out.println("\n");
		}

	}

}
