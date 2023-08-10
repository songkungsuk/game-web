package com.game;

import java.io.File;

public class RenameTest {

	public static void main(String[] args) {
		String rootPath = "C:\\dev\\works\\html\\img";
		String targetPath = "C:\\dev\\works\\html\\img\\cards\\";
		File rootFile = new File(rootPath);
		File[] dirs = rootFile.listFiles();
		int i = 0;
		
		for(File dir : dirs) {
			System.out.print(dir.getName()+ ",");
			System.out.println(dir.isDirectory());
			if(dir.isDirectory()) {
				File[] files = dir.listFiles();
				for(File file : files) {
					File targetFile = new File(targetPath + (i++) + ".png");
					file.renameTo(targetFile);
				}
			}
		}
	}
}
