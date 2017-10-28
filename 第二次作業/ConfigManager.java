package com.senao.homework2;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigManager extends JsonManager {

	// 檔案路徑
	public static final String PATH = "setting\\config.json";

	// 設定檔內資訊
	List<Config> configs = new ArrayList<Config>();

	// 設定檔筆數
	public static int count;

	// for test
	public static void main(String[] args) {
		ConfigManager configManger = new ConfigManager();
		configManger.ProcessJsonConfig();
	}

	@Override
	public void ProcessJsonConfig() {

		// JSON format
		/*
		 * Before: JSONParser parser = new JSONParser();
		 */
		try {
			// 讀檔
			/*
			 * Before :JSONObject obj = new JSONObject(parser.parse(new
			 * FileReader(PATH)).toString());
			 */
			JSONObject obj = this.GetJsonObject(PATH);

			// 設定檔筆數
			count = obj.getJSONArray("configs").length();

			JSONArray array = obj.getJSONArray("configs");

			for (int i = 0; i < count; i++) {
				configs.add(new Config(array.getJSONObject(i).getString("ext"),
						array.getJSONObject(i).getString("location"), array.getJSONObject(i).getBoolean("subDirectory"),
						array.getJSONObject(i).getString("unit"), array.getJSONObject(i).getBoolean("remove"),
						array.getJSONObject(i).getString("handler"), array.getJSONObject(i).getString("destination"),
						array.getJSONObject(i).getString("dir"), array.getJSONObject(i).getString("connectionString")));
			}

			// System.out.println(configs);

			System.out.println("Config 筆數共:" + count);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
