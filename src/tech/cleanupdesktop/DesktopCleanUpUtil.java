package tech.cleanupdesktop;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DesktopCleanUpUtil extends DesktopCleanUp {

	private List<String> myList = new ArrayList();
	DesktopCleanUpUtil DCUU = new DesktopCleanUpUtil();
	
	public List<String> listLogicalDrives(String os) {
		File[] rootPath = File.listRoots();
		List<String> currentPath = new ArrayList<>();
		for(File f1: rootPath) {
			currentPath.add(f1.getPath().toLowerCase());
		}
		return currentPath;
	}
	
	void listFiles(String drivePath) {
		try {
			Stream<Path> path = Files.walk(Paths.get(drivePath));
//			path.filter(null)
//			path.filter(Files::isRegularFile).forEach(System.out::println);
			path.filter(Files::isDirectory).forEach(DCUU::printUpperCase);
			path.close();
		}catch(Exception e) {
			System.out.println(e);
		} finally {
			
		}
	}
	
	private List<String> getFileList(String name) {
		myList.add(name);
		return myList;
	}
	
	public void printUpperCase(String str) {
	        System.out.println(str.toUpperCase());
	    }
}
