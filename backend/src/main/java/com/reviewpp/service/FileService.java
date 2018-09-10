package com.reviewpp.service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import org.springframework.web.multipart.MultipartFile;


public class FileService {
	
	final static String BASE_LOCATION="E:/uploads/";
	public static String getExtension(MultipartFile file) {
		// splitting file name using "." delimit
		String[] tokens = file.getOriginalFilename().split(".");
		// returning file extension...
		return "."+tokens[tokens.length-1];
	}
	public static List<String> uploadFiles(MultipartFile[] files ) throws IOException {
		// creating empty array list file names....
		List<String> fileNames = new ArrayList<>();
		for( int i=0;i<files.length;i++) {

			// generating unique file name based on time stamp....
			String generatedFileName = new java.util.Date().getTime()+getExtension(files[i]);
			
			// Give the complete path where files needs to be uploaded.....
			File f=new File(BASE_LOCATION+generatedFileName);
			f.createNewFile();
			FileOutputStream fout=new FileOutputStream(f);
			fout.write(files[i].getBytes());
			fout.close();
			
			fileNames.add(generatedFileName);
			
		}
		return fileNames;
	}
	
	public static String uploadFile(MultipartFile file) throws IOException {
		String fileName=new java.util.Date().getTime()+getExtension(file);
		
		File f=new File( BASE_LOCATION + fileName );
		f.createNewFile();
		FileOutputStream fout=new FileOutputStream(f);
		fout.write(file.getBytes());
		fout.close();
		
		return fileName;
	}
	public boolean deleteFile(String fileName) {
		fileName = BASE_LOCATION + fileName;
		return true;
	}
}
