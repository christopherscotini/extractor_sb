package com.gamaset.extractor.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GenFile {
	
	public void generateTXT(List<String> datas, String filename){
//		String path = "C://Desenvolvimento//git//Pessoal//sonicbot_data//inserts//";
		String path = "C://Users//t.christopher.rosari//OneDrive//Favoritos//BETLIFE//Stats//sonicbot_data//inserts//";
		String extension = ".sql";
		
		Path out = Paths.get(path.concat(filename).concat(extension));
		try {
			Files.write(out,datas,Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
