package com.accp.action.file;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.accp.util.file.Upload;

@Controller
@RequestMapping("/c")
public class UploadController {
	@PostMapping("upload")
	public String upload(@RequestParam("file") MultipartFile file, Model model) {
		if (!file.isEmpty()) {
			try {
				String url = Upload.saveFile(file);
				model.addAttribute("message", "上传成功，访问路径：" + url);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				model.addAttribute("message", "上传失败");
			}
		} else {
			model.addAttribute("message", "文件为空");
		}
		return "upload";
	}
}