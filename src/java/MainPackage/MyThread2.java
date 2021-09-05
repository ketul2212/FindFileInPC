/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ketul
 */
public class MyThread2 extends Thread{
    public String found;
	public int count;

	public MyThread2(String found) {
		this.found = found + "+";
	}

	public void run() {
		File f = new File("D:\\");
		foundInsideDirectory(f);
		System.out.println("Your Provide files are in D Drive is " + count + ".");
		f = null;
	}


	public void foundInsideDirectory(File f) {
		String[] s = f.list();
		if(s != null){
			for (String s1 : s) {
				File f1 = new File(f, s1);

				if(f1.isFile()) {
					Pattern p2 = Pattern.compile(found, Pattern.CASE_INSENSITIVE);
					Matcher m2 = p2.matcher(s1);
				
					while(m2.find()){
						System.out.println(f1);
						count++;
					}

				}
				else if(f1.isDirectory())
					foundInsideDirectory(f1);
			}
		}
		// else
		// 	System.out.println("Array null-------------------" + f);
	}
}
