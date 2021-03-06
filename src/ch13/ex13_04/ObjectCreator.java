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
					list.add(new Boolean(strs[1]));
					break;
				case "Character":
					list.add(new Character(strs[1].charAt(0)));
					break;
				case "Short":
					list.add(new Short(strs[1]));
					break;
				case "Byte":
					list.add(new Byte(strs[1]));
					break;
				case "Integer":
					list.add(new Integer(strs[1]));
					break;
				case "Long":
					list.add(new Long(strs[1]));
					break;
				case "Float":
					list.add(new Float(strs[1]));
					break;
				case "Double":
					list.add(new Double(strs[1]));
					break;
				default:
					System.err.println("Invalid line:" + line);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {

		}
	}

	public List<Object> getList() {
		return list;
	}

}
