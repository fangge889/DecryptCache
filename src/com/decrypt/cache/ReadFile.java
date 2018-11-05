package com.decrypt.cache;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	public static List<String> readFile(String path){  
		List<String> nameList = new ArrayList<>();
		File file=new File(path);
		File[] tempList = file.listFiles(); 
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isFile()) { 
				String name = tempList[i].toString();
				String suffix = name.substring(name.lastIndexOf("."));
				if(".uc".equals(suffix)) {
					nameList.add(name);
				}
			}
		}
		return nameList;
	}
}
