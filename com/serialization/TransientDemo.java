//$Id$
package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TransientDemo {
	public static void main(String[] args) {
		Emp s1=new Emp();
		
		try {
			FileOutputStream fos=new FileOutputStream("abc2.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Emp s2=null;
		FileInputStream fis;
		try {
			fis = new FileInputStream("abc2.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			s2 = (Emp) ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(s2.email+" ... "+s2.pasword+" ... "+s2.age+" ... "+s2.mobile);
	}
}

class Emp implements Serializable{
	String email="email";
	transient String pasword="password";
	
	transient static int age=25;  //with transient also no effect as it is no way related to object
	
	transient final int mobile=2123125; //with transient also no effect
}
