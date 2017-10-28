package com.senao.homework2;

public class Config {

	public String ext;
	public boolean subDirectory;
	public String location;
	public String unit;
	public boolean remove;
	public String handler;
	public String destination;
	public String dir;
	public String connectionString;

	public Config(String ext, String location, boolean subDirectory, String unit, boolean remove, String handler,
			String destination, String dir, String connectionString) {
		this.ext = ext;
		this.subDirectory = subDirectory;
		this.location = location;
		this.unit = unit;
		this.remove = remove;
		this.handler = handler;
		this.destination = destination;
		this.dir = dir;
		this.connectionString = connectionString;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public boolean isSubDirectory() {
		return subDirectory;
	}

	public void setSubDirectory(boolean subDirectory) {
		this.subDirectory = subDirectory;
	}

	public boolean isRemove() {
		return remove;
	}

	public void setRemove(boolean remove) {
		this.remove = remove;
	}
}
