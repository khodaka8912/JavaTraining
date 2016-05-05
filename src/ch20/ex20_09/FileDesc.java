package ch20.ex20_09;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class FileDesc {

	/**
	 * 指定された複数のファイルパスの情報を表示する
	 * @param filePaths
	 */
	public static void showFileDescriptions(String... filePaths) {
		Objects.requireNonNull(filePaths, "filePaths must not be null.");
		Arrays.stream(filePaths).map(s -> Optional.ofNullable(s).map(o -> new File(o)))
				.forEach(o -> o.ifPresent(FileDesc::showFileDescription));
	}

	/**
	 * 指定されたファイルの情報を表示する
	 * @param file
	 */
	public static void showFileDescription(File file) {
		Objects.requireNonNull(file, "file must not be null.");
		System.out.println("----------\n" + file.toString());
		System.out.println("exists : " + file.exists());
		if (!file.exists()) {
			return;
		}
		System.out.println("Name : " + file.getName());
		System.out.println("Path : " + file.getPath());
		System.out.println("Abs Path : " + file.getAbsolutePath());
		System.out.println("Parent : " + file.getParent());
		System.out.println("isDirectory : " + file.isDirectory());
		if (file.isDirectory()) {
			System.out.println("Children : " + Arrays.toString(file.list()));
		}
		System.out.println("isFile : " + file.isFile());
		if (file.isFile()) {
			System.out.println("Length : " + file.length());
			System.out.println("canRead : " + file.canRead());
			System.out.println("canWrite : " + file.canWrite());
			System.out.println("canExecute : " + file.canExecute());
			
		}
	}
	
	public static void main(String[] args) {
		showFileDescriptions("src\\ch20\\ex20_08\\test.txt", "src\\ch20\\ex20_09\\FileDesc.java", "src\\ch20");
	}

}
