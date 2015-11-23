package ch13.ex13_04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjectCreator {
	
	private final File file;
	private final List<Object> list = new ArrayList<>();
	
	public ObjectCreator(String filePath) {
		this(new File(filePath));
	}
	
	public ObjectCreator(File file) {
		this.file = file;
	}
	
	public void create() {
		try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
			String line;
			while((line = reader.readLine()) != null) {
				String[] strs = line.split("\\s");
				if (strs.length != 2) {
					System.err.println("Invalid line:" + line);
					continue;
				}
				switch(strs[0]) {
				case "Boolean":
					list.add(Boolean.valueOf(strs[1]));
					break;
				case "Charactor":
					list.add(Character.valueOf(strs[1].charAt(0)));
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			
		}
	}

}
