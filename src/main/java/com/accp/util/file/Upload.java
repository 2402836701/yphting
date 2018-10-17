package com.accp.util.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class Upload {
	// 文件上传文件夹
	public final static String UPLOADED_FOLDER = "C://Upload/";
	// 文件访问前缀
	public final static String VISIT_SUFFIX = "/api/img/";

	/**
	 * 保存文件
	 * 
	 * @param file
	 *            文件
	 * @return 文件访问路径
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String saveFile(MultipartFile file) throws IllegalStateException, IOException {
		String route = createFileRoute(file);
		String url = VISIT_SUFFIX + route;
		String path = UPLOADED_FOLDER + route;
		File dest = new File(path);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		file.transferTo(dest);
		return url;
	}

	/**
	 * 获取文件后缀名
	 * 
	 * @param file
	 *            文件
	 * @return 文件后缀名
	 */
	private static String getSuffix(MultipartFile file) {
		String name = file.getOriginalFilename();
		String suffix = name.substring(name.lastIndexOf("."));
		return suffix;
	}

	/**
	 * 生成日期文件夹名称
	 * 
	 * @return 日期文件夹名称
	 */
	private static String createTimeFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(new Date());
		return time;
	}

	/**
	 * 生成文件基本路径
	 * 
	 * @param file
	 *            文件
	 * @return 文件基本路径
	 */
	private static String createFileRoute(MultipartFile file) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String suffix = getSuffix(file);
		String time = createTimeFolder();
		String url = time + "/" + uuid + suffix;
		return url;
	}
}