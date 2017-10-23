package com.senao;

import java.io.FileReader;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class ConfigManager {

	public static Object obj;

	public static int count;

	public static void main(String[] args) {
		ConfigManager configs = new ConfigManager();
		configs.processConfigs();
		System.out.println("Config rows=" + count);
	}

	/**
	 * 將 config.json 轉成 List<Config>
	 */
	public void processConfigs() {

		JSONParser parser = new JSONParser();

		try {
			// 取Config
			obj = parser.parse(new FileReader("setting\\config.json"));

			// 轉換成JSON
			JSONObject json = new JSONObject(obj.toString());

			// 取得設定檔筆數
			count = json.getJSONArray("configs").length();

			// 取得所有資料
			for (int i = 0; i < count; i++) {
				JSONObject jsonDetails = new JSONObject(json.getJSONArray("configs").getJSONObject(i).toString());

				Config configs = new Config();
				configs.setExt(jsonDetails.get("ext").toString());
				configs.setSubDirectory((boolean) jsonDetails.get("subDirectory"));
				configs.setLocation(jsonDetails.get("location").toString());
				configs.setUnit(jsonDetails.get("unit").toString());
				configs.setRemove((boolean) jsonDetails.get("remove"));
				configs.setHandler(jsonDetails.get("handler").toString());
				configs.setDestination(jsonDetails.get("destination").toString());
				configs.setDir(jsonDetails.get("dir").toString());
				configs.setConnectionString(jsonDetails.get("connectionString").toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
