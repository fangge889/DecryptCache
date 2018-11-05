package com.decrypt.cache;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

public class DecryptCache {

	public static void decrypt(String fileName,String outFilePath) {
		File inFile = new File(fileName);
		String musicId = inFile.getName().split("-")[0];
		String songName = GetSongInfo.getInfoFromWeb(musicId);
		if(StringUtils.isNotBlank(songName)) {
			File outFile = new File(outFilePath + songName + ".mp3");
			try {
				DataInputStream dis = new DataInputStream(new FileInputStream(inFile));
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
				byte[] by = new byte[1000];
				int len;
				while ((len = dis.read(by)) != -1) {
					for (int i = 0; i < len; i++) {
						by[i] ^= 0xa3;
					}
					dos.write(by, 0, len);
				}
				dis.close();
				dos.close();
				System.out.println("完成转换:" + songName + ".mp3");
			} catch (IOException ioe) {
				System.err.println(ioe);
			}
		}
	}

	
}
