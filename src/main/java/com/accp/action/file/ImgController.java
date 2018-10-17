package com.accp.action.file;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.util.file.Upload;

@RestController
@RequestMapping("/api")
public class ImgController {
	private final ResourceLoader resourceLoader;

	@Autowired
	public ImgController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	@GetMapping("img/**")
	public ResponseEntity<Resource> show(HttpServletRequest request) {
		String img = request.getRequestURL().toString().split("/api/img/")[1];
		try {
			return ResponseEntity.ok(resourceLoader.getResource("file:" + Upload.UPLOADED_FOLDER + img));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}