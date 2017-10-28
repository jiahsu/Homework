package com.senao.homework1;

import java.io.FileReader;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ScheduleManager {

	// 排程檔內資訊
	public static Schedule schedules;

	// 排程檔筆數
	public static int count;

	public static void main(String[] args) {
		ScheduleManager scheduleManager = new ScheduleManager();
		scheduleManager.ProcessJsonConfig();
	}

	public void ProcessJsonConfig() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			// 讀檔
			schedules = mapper.readValue(new FileReader("setting\\schedule.json"), Schedule.class);

			// 筆數
			count = schedules.getSchedules().size();

			for (int i = 0; i < count; i++) {

				System.out.println("設定檔" + (i + 1) + ":" + schedules.getSchedules().get(i).getInterval());

			}

			System.out.println("Schedule 筆數共:" + count);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
