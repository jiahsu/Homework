package com.senao.homework2;

import java.util.ArrayList;
import java.util.List;

public class MyBackupService {

	List<JsonManager> managers = new ArrayList<JsonManager>();

	public static void main(String[] args) {
		MyBackupService mybackup = new MyBackupService();
		mybackup.MyBackup();
		mybackup.ProcessJsonConfigs();
	}

	public void MyBackup() {
		this.managers.add(new ConfigManager());
		this.managers.add(new ScheduleManager());
	}

	public void ProcessJsonConfigs() {
		for (int i = 0; i < managers.size(); i++) {
			this.managers.get(i).ProcessJsonConfig();
		}

	}

}
