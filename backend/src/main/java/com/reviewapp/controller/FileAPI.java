package com.reviewapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
/***
 * All the file uploading and handling APIs
 * @author mindfire
 *
 */
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*")
public class FileAPI {
	
	@PostMapping(value="/upload",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String upload(@RequestParam("file") MultipartFile[] file) throws IOException {
		
		for( int i=0;i<file.length;i++) {
			
			File f=new File("E:/uploads/"+new java.util.Date().getTime()+".png");
			f.createNewFile();
			FileOutputStream fout=new FileOutputStream(f);
			fout.write(file[i].getBytes());
			fout.close();
			System.out.println( file[i].getOriginalFilename() );
		}
		return "working";
	}
	
}
