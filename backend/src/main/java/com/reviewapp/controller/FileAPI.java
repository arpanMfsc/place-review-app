package com.reviewapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import com.reviewapp.model.*;
import com.reviewapp.repositories.PlaceRepository;
import com.reviewapp.repositories.UserRepository;
/***
 * All the file uploading and handling APIs
 * @author mindfire
 *
 */
@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*")
public class FileAPI {

	@Autowired
	private UserRepository users;
	
	@Autowired
	private PlaceRepository places;
	
	@PostMapping(value="/upload",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String upload(@RequestParam(value="file",required=false) MultipartFile[] 	file,
						@RequestParam("name")  String 				name,
						@RequestParam("description") String 		description,
						@RequestParam("address") String 			address) throws IOException {
		
		
		Place place=new Place();
		place.setName(name);
		place.setDescription(description);
		place.setAddress(address);
		place.setAddedBy(users.findByEmail("arpan.pathak47@gmail.com"));
		for( int i=0;i<file.length;i++) {

			// generating unique file name based on time stamp....
			String generatedFileName = new java.util.Date().getTime()+".png";
			
			// Give the complete path where files needs to be uploaded.....
			File f=new File("E:/uploads/"+generatedFileName);
			f.createNewFile();
			FileOutputStream fout=new FileOutputStream(f);
			fout.write(file[i].getBytes());
			fout.close();
			Picture p=new Picture(generatedFileName,"this is a simple caption");
			place.getPictures().add(p);
			System.out.println( file[i].getOriginalFilename() );
		}
		places.save(place);
		return "working";
	}
	
}
