package com.senao.homework2;

import java.io.FileReader;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public abstract class JsonManager {

	/**
	 * 讀檔
	 * */
	protected JSONObject GetJsonObject(String path) throws Exception {

		JSONParser parser = new JSONParser();

		JSONObject obj = new JSONObject(parser.parse(new FileReader(path)).toString());

		return obj;
	}

	public abstract void ProcessJsonConfig();

}
