package utils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindCertainExtension {

	private static final String FILE_DIR = "D:\\vm\\data";
	private static final String FILE_TEXT_EXT = ".jpg";

	public static void main(String args[]) throws IOException {
		new FindCertainExtension().listFile(FILE_DIR, FILE_TEXT_EXT);

	}

	public void listFile(String folder, String ext) throws IOException {
		long init = System.currentTimeMillis();
		List<Path> collect = null;
		try {
			File f = new File(FILE_DIR);
			URI path = f.toURI();
			collect = Files.walk(Paths.get(path))
					.filter(Files::isDirectory)
					// .filter(Files::isRegularFile)
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		collect.stream()
				.forEach(elm -> System.out.println(elm));
		File realfile = new File("D:\\vm\\data\\data.txt");
		if (realfile.createNewFile()) {
			System.out.println("File created: ");
		}

		FileWriter writer = new FileWriter(realfile);
		collect.stream()
				.forEach(elm ->
					{
						try {
							String data = null;
							String[] split = elm.toString()
									.split("\\\\");
							if (split != null) {
								data = split[split.length - 1];
								System.out.println("::::::::::::" + data);
							}
							if (null != data) {
								writeUsingFiles(data);
								writer.write(data);
								writer.write("\r\n");
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					});

		System.out.println(collect.parallelStream()
				.map(path -> path.getFileName()
						.toString())
				.filter(file -> file.endsWith(".jpg") || file.endsWith(".jpeg") || file.endsWith(".jfif"))
				.count());
		long done = System.currentTimeMillis();
		System.out.println(done - init);
		// .forEach(elm -> System.out.println(elm));
	}
	
	 private static void writeUsingFiles(String data) {
	        try {
	            Files.write(Paths.get("‪D:\\vm\\data\\ndata.txt"), data.getBytes());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}