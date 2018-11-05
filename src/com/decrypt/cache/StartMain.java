package com.decrypt.cache; 
import java.util.List; 

public class StartMain {
	//缓存目录
	public static final String cache_path = "E:\\CloudMusic\\Cache";
	//输出目录
	public static final String out_path = "E:\\Music\\mm\\";
	//获取歌曲信息接口
	public static final String song_info_url = "https://api.imjad.cn/cloudmusic";
	

	public static void main(String[] args) {
		List<String> nameList = ReadFile.readFile(cache_path); 
		System.out.println("待完成转换数量:" + nameList.size());
		int num = 0;
		for(String name:nameList) {
			DecryptCache.decrypt(name,out_path);
			num += 1; 
		}
		System.out.println("完成转换数量:" + num);
	}

	


}
