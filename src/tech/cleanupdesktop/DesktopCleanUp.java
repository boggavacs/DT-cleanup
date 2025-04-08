package tech.cleanupdesktop;

import java.io.File;

public class DesktopCleanUp {
	private String osName;
	private String osVersion;
	private String path;
	private File[] rootPath;
	
	/**
	 * @return the osName
	 */
	public String getOsName() {
		return osName;
	}
	/**
	 * @param osName the osName to set
	 */
	public void setOsName(String osName) {
		this.osName = osName;
	}
	/**
	 * @return the osVersion
	 */
	public String getOsVersion() {
		return osVersion;
	}
	/**
	 * @param osVersion the osVersion to set
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public String setPath(String path) {
		return this.path = path;
	}
	/**
	 * @return the rootPath
	 */
	public File[] getRootPath() {
		return rootPath;
	}
	/**
	 * @param rootPath the rootPath to set
	 */
	public void setRootPath(File[] rootPath) {
		this.rootPath = rootPath;
	}
	
	
	
}
