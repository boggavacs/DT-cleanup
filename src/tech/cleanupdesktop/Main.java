package tech.cleanupdesktop;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
				
		Scanner scan = new Scanner(System.in);
		DesktopCleanUpUtil cleanUp = new DesktopCleanUpUtil();
		cleanUp.setOsName(System.getProperty("os.name"));
		cleanUp.setOsVersion(System.getProperty("os.version"));
		System.out.printf("OS: %s\n", cleanUp.getOsName());
		System.out.printf("Version: %s\n", cleanUp.getOsVersion());
		
		try {
			
			LogicDrives logicDrives = (os) -> {
				var currentOs = "";
				if(os.contains("MAC")) {
					currentOs = cleanUp.listLogicalDrives("Mac").toString();;
				}else if (cleanUp.getOsName().contains("Win")) {
					currentOs = cleanUp.listLogicalDrives("Win").toString();
				}else {
					currentOs = cleanUp.listLogicalDrives("Linux").toString();
				}
				return currentOs;
			}; 
			
			OsName osName = (name)-> name.contains("Mac") ? "Mac" : name.contains("Win") ? "Win" : "Linux" ;
			
//			System.out.println("root: " + logicDrives.getOsName(cleanUp.getOsName()));
//			System.out.println("root: " + osName);
			System.out.println("root: " + osName.osName(System.getProperty("os.name")));
			System.out.printf("Please enter folder path to organize: ");
			String path = cleanUp.setPath(scan.next());
//			System.out.printf("%s", path);
			
			switch (osName.osName(System.getProperty("os.name"))) {
			case "Mac":{
				break;
			}
			case "Linux": {
				String driveList = logicDrives.listDrives(cleanUp.getOsName());
				cleanUp.listFiles(driveList.substring(1, driveList.length()-1) + path);
				break;
			}
			case "Win": {
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			scan.close();
		}
	}
}
