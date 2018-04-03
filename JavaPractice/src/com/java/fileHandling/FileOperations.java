package com.java.fileHandling;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileOperations implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// FileReadWrite();
		ObjectReadWrite();

	}

	private static void ObjectReadWrite() throws IOException, ClassNotFoundException {
		FileOperations fop = new FileOperations();
		FileOutputStream fos = new FileOutputStream(new File("C:\\MyData\\Umesh\\File_for_tests\\fileForObj.txt"));

		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(fop);
		System.out.println("Object written");
		fos.close();
		oos.close();

		FileInputStream fis = new FileInputStream(new File("C:\\MyData\\Umesh\\File_for_tests\\fileForObj.txt"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		FileOperations newFop = (FileOperations) ois.readObject();
		fis.close();
		ois.close();
		newFop.FileReadWrite();

	}

	private static void FileReadWrite() throws FileNotFoundException, IOException {
		File file = new File("C:\\MyData\\Umesh\\File_for_tests\\file1.txt");
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		dos.writeInt(555);
		System.out.println("Written 555");
		int read = dis.readInt();
		System.out.println("Output for data saved : " + read);
		dos.close();
	}
}
