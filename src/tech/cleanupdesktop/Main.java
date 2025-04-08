package tech.cleanupdesktop;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		DesktopCleanUp cleanUp = new DesktopCleanUp();
		cleanUp.setOsName(System.getProperty("os.name"));
		cleanUp.setOsVersion(System.getProperty("os.version"));
		System.out.printf("OS: %s\n", cleanUp.getOsName());
		System.out.printf("Version: %s\n", cleanUp.getOsVersion());
		System.out.print("Path : ");
		
		try {
			String path = cleanUp.setPath(scan.next());
			System.out.printf("Path: %s\n", path);
			File[] rootPath = File.listRoots();
			
			OsName os = (os) -> os.contains(cleanUp.getOsName());
			
			switch(cleanUp.getOsName()) {
			case "Mac":
				//
				break;
			case "Win":
				break;
			default:
				System.out.println("this is linux");
					
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			scan.close();
		}
		
		
	}

}
