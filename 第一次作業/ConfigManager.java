package com.senao.homework1;

import java.io.FileReader;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigManager {

	// 設定檔內資訊
	public static Config configs;

	// 設定檔筆數
	public static int count;

	public static void main(String[] args) {
		ConfigManager configManger = new ConfigManager();
		configManger.ProcessJsonConfig();
	}

	public void ProcessJsonConfig() {

		ObjectMapper mapper = new ObjectMapper();

		try {
			// 讀檔
			configs = mapper.readValue(new FileReader("setting\\config.json"), Config.class);

			// 筆數
			count = configs.getConfigs().size();

			for (int i = 0; i < count; i++) {

				System.out.println("設定檔" + (i + 1) + ":" + configs.getConfigs().get(i).getDir());

			}

			System.out.println("Config 筆數共:" + count);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
