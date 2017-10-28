package com.senao.homework2;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ScheduleManager extends JsonManager {

	// 檔案路徑
	public static final String PATH = "setting\\schedule.json";

	// 設定檔內資訊
	List<Schedule> schedules = new ArrayList<Schedule>();

	// 排程檔筆數
	public static int count;

	//for test
	public static void main(String[] args) {
		ScheduleManager scheduleManager = new ScheduleManager();
		scheduleManager.ProcessJsonConfig();
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
			count = obj.getJSONArray("schedules").length();

			JSONArray array = obj.getJSONArray("schedules");

			for (int i = 0; i < count; i++) {
				schedules.add(new Schedule(array.getJSONObject(i).getString("ext"),
						array.getJSONObject(i).getString("time"), array.getJSONObject(i).getString("interval")));
			}

			System.out.println("Schedule 筆數共:" + count);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
