package com.reviewapp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	// BASE_LOCATION of of the file uploading directory
	final String BASE_LOCATION = "E:/uploads/";

	/**
	 * This method will return the file extension
	 * @param MultipartFile file
	 * @return String which is extension of the file
	 */
	public String getExtension(MultipartFile file) {
		
		// splitting file name using "." delimit
		String[] tokens = file.getOriginalFilename().split("\\.");
		
		// returning file extension...
		return "." + tokens[tokens.length - 1];
	}

	/**
	 * This method will upload an array of file
	 * @param MultipartFiles[] files
	 * @return list of name of generated files after uploading
	 * @throws IOException
	 */
	public List<String> uploadFiles(MultipartFile[] files) throws IOException {
		// creating empty array list file names....
		List<String> fileNames = new ArrayList<>();
		
		for (int i = 0; i < files.length; i++) {

			// generating unique file name based on time stamp....
			String generatedFileName = new java.util.Date().getTime() + getExtension(files[i]);

			// Give the complete path where files needs to be uploaded.....
			File f = new File(BASE_LOCATION + generatedFileName);
			f.createNewFile(); // create the file
			
			// get a output stream for the created file
			FileOutputStream fout = new FileOutputStream(f);
			// copy the raw data into the created file
			fout.write(files[i].getBytes());
			fout.close();

			fileNames.add(generatedFileName);

		}
		return fileNames;
	}

	/**
	 * This method is used for uploading single file
	 * @param file
	 * @return a String which is name of the uploaded file in server 
	 * @throws IOException
	 */
	public String uploadFile(MultipartFile file) throws IOException {
		String fileName = new java.util.Date().getTime() + getExtension(file);

		File f = new File(BASE_LOCATION + fileName);
		f.createNewFile();
		FileOutputStream fout = new FileOutputStream(f);
		fout.write(file.getBytes());
		fout.close();

		return fileName;
	}
	
	/**
	 * This method is used for deleting a single file 
	 * @param fileName
	 * @return true if file is found and successfully deleted otherwise false
	 */
	public boolean deleteFile(String fileName) {
		fileName = BASE_LOCATION + fileName;
		File f=new File(fileName);
		f.delete();
		return !f.exists();
	}
}
