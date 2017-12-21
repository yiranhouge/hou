package com.hou.controller;

import com.hou.model.User;
import com.hou.service.impl.UserServiceImpl;


import javafx.geometry.Pos;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : houlk
 * @description : 示例controller
 * @date : 2017/12/19
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	private UserServiceImpl userService;
	
	public void setUserServiceImpl(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/index")
	public String index() {
		//渲染视图，/WEB-INF/jsp/hello/world.jsp
		return "/hello/world";
	}
	
	//方法级别的RequestMapping，限制并缩小了URL路径匹配，同类级别的标签协调工作，
	//最终确定拦截到的URL有那个方法处理
	@RequestMapping("/world")
	public String world() {
		return "/hello/world";
	}
	
	//本方法处理/hello/view?courseId=123形式的URL
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
		User user = userService.getMapper().selectByPrimaryKey(courseId);
		model.addAttribute(user);
		return "course_overview";
	}
	
	//本方法将处理/hello/view2/123 形式的URL
	@RequestMapping("/view/{courseId}")
	public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> map) {
		User user = userService.getMapper().selectByPrimaryKey(courseId);
		map.put("user", user);
		return "course_overview";
	}
	
	//本方法处理/hello/view3?courseId=123
	@RequestMapping("/view3")
	public String viewCourse3(HttpServletRequest request) {
		Integer courseId = Integer.valueOf(request.getParameter("courseId"));
		User user = userService.getMapper().selectByPrimaryKey(courseId);
		request.setAttribute("user", user);
		return "course_overview";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET, params = "add")
	public String createCourse() {
		return "course_admin/edit";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String doSave(@ModelAttribute User user) {
		logger.debug("Info of Course:");
		logger.debug(ReflectionToStringBuilder.toString(user));
		//在此进行业务操作，比如数据库的持久化
		user.setId(123);
		return "redirect:view2/" + user.getId();
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String showUploadPage(@RequestParam(value = "multi", required = false) Boolean multi) {
		if (multi != null && multi) {
			return "course_admin/multifile";
		}
		return "course_admin/file";
	}
	
	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("c:\\temp\\imooc\\", System.currentTimeMillis() + file.getOriginalFilename()));
		}
		return "success";
	}
	
	@RequestMapping(value = "/doUpload2", method = RequestMethod.POST)
	public String doUploadFile2(MultipartHttpServletRequest multiRequest) throws IOException {
		Iterator<String> fileNames = multiRequest.getFileNames();
		while (fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile file = multiRequest.getFile(fileName);
			if (!file.isEmpty()) {
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File("c:\\temp\\imooc\\", System.currentTimeMillis() + file.getOriginalFilename()));
			}
		}
		return "success";
	}
	
	@RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
	public @ResponseBody
	User getCourseInJson(@PathVariable Integer courseId) {
		return userService.getMapper().selectByPrimaryKey(courseId);
	}
	
	@RequestMapping(value = "/jsontype/{courseId}", method = RequestMethod.GET)
	public ResponseEntity<User> getCourseInJson2(@PathVariable Integer courseId) {
		User user = userService.getMapper().selectByPrimaryKey(courseId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
}
