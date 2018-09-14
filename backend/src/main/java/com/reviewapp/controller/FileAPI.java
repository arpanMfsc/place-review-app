/***
 * All the file uploading and handling APIs
 * @author arpanpathak
 *
 */

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
import com.reviewapp.service.*;

@RestController
@RequestMapping("/file")
@CrossOrigin(origins = "*")
public class FileAPI {

	@Autowired
	private UserRepository users;

	@Autowired
	private PlaceRepository places;

	@Autowired
	private FileService fileService;

	/**
	 * This API route will create new place and handle file uploads
	 * 
	 * @param file
	 * @param addedBy
	 * @param name
	 * @param description
	 * @param address
	 * @return instance of Place if successfully added otherwise null
	 * @throws IOException
	 */
	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Place upload(@RequestParam(value = "file", required = false) MultipartFile[] file,
			@RequestParam("addedBy") Long addedBy, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("address") String address)
			throws IOException {

		Place place = new Place();

		place.setName(name);
		place.setDescription(description);
		place.setAddress(address);

		// this code is vulnerable to attacks, it will be fixed after adding spring
		// security.....
		place.setAddedBy(addedBy);

		for (String fileName : fileService.uploadFiles(file)) {

			Picture p = new Picture(fileName, "this is a simple caption");
			place.getPictures().add(p);
			System.out.println(fileName);
		}
		places.save(place);
		return place;
	}

}
