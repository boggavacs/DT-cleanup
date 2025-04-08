package tech.cleanupdesktop;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		DesktopCleanUp cleanUp = new DesktopCleanUp();
		cleanUp.setOsName(System.getProperty("os.name"));
		cleanUp.setOsVersion(System.getProperty("os.version"));
		System.out.printf("OS: %s\n", cleanUp.getOsName());
		System.out.printf("Version: %s\n", cleanUp.getOsVersion());
		
		try {
			OsName logicalDrives = (os) -> {
				var currentOs = "";
				if(os.contains("MAC")) {
					currentOs = listLogicalDrives("Mac").toString();
				}else if (cleanUp.getOsName().contains("Win")) {
					currentOs = listLogicalDrives("Win").toString();
				}else {
					currentOs = listLogicalDrives("Linux").toString();
				}
				return currentOs;
			};
			
			System.out.println("root: " + logicalDrives.getOsName(cleanUp.getOsName()));
			System.out.printf("Please enter folder path to organize: \n");
			String path = cleanUp.setPath(scan.next());
			System.out.printf("%s", path);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			scan.close();
		}
		
		
	}
	
	public static List<String> listLogicalDrives(String os) {
		File[] rootPath = File.listRoots();
		List<String> currentPath = new ArrayList<>();
		for(File f1: rootPath) {
			currentPath.add(f1.getPath().toLowerCase());
		}
		return currentPath;
	}

}
