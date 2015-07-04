//$Id$
package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDemo {

	public static void main(String[] args) {
		Student s1=new Student();
		
		try {
			FileOutputStream fos=new FileOutputStream("abc.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Student s2=null;
		FileInputStream fis;
		try {
			fis = new FileInputStream("abc.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			s2 = (Student) ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(s2.name+" ... "+s2.age);
	}

}

class Student implements Serializable{
	String name="Sandy";
	int age=26;
}
