package com.senao;

import java.io.FileReader;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class ScheduleManager {

	public static Object obj;

	public static int count;

	public static void main(String[] args) {
		ScheduleManager schedules = new ScheduleManager();
		schedules.processSchedule();
		System.out.println("Schedule rows=" + count);
	}

	private void processSchedule() {
		JSONParser parser = new JSONParser();

		try {
			// 取Config
			obj = parser.parse(new FileReader("setting\\schedule.json"));

			// 轉換成JSON
			JSONObject json = new JSONObject(obj.toString());

			// 取得設定檔筆數
			count = json.getJSONArray("schedules").length();

			// 取得所有資料
			for (int i = 0; i < count; i++) {
				JSONObject jsonDetails = new JSONObject(json.getJSONArray("schedules").getJSONObject(i).toString());

				Schedule schedules = new Schedule();
				schedules.setExt(jsonDetails.get("ext").toString());
				schedules.setTime(jsonDetails.get("time").toString());
				schedules.setInterval(jsonDetails.get("interval").toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
