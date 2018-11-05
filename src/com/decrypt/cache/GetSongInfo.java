package com.decrypt.cache;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;

public class GetSongInfo {
	public static String getInfoFromWeb(String musicId) {
		String song = HttpRequest.sendGet(StartMain.song_info_url, "type=detail&id=" + musicId);
		if(StringUtils.isNotBlank(song)) {
			Gson gson = new Gson();
			Map map = gson.fromJson(song, Map.class);
			List<Map> songMap = (List<Map>) map.get("songs"); 
			String songName = (String) songMap.get(0).get("name");
			return songName;
		}
		return "";
	}
}
