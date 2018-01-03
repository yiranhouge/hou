package com.hou.cms.controller;

import com.hou.cms.model.User;
import com.hou.cms.model.UserExample;
import com.hou.cms.service.UserService;
import com.hou.cms.util.Paginator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : houlk
 * @description : 用户控制器
 * @date : 2017/12/19
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@ExceptionHandler(Exception.class)
	public void exceptionHandler(Exception e) {
		e.printStackTrace();
	}
	
	/**
	 * 首页
	 *
	 * @return
	 */
	@RequestMapping(value = {"", "index"})
	public String index() {
		return "redirect:/user/list";
	}
	
	/**
	 * 列表
	 *
	 * @param page    页数
	 * @param rows    每页大小
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(required = false, defaultValue = "1") int page,
	                   @RequestParam(required = false, defaultValue = "20") int rows,
	                   HttpServletRequest request) {
		//查询参数
		String clumns = "*";
		String condition = "id>0";
		String order = "id asc";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("clumns", clumns);
		parameters.put("condition", condition);
		parameters.put("order", order);
		//创建分页对象
		UserExample userExample = new UserExample();
		userExample.createCriteria().andIdGreaterThan(0);
		int total = userService.getMapper().countByExample(userExample);
		Paginator paginator = new Paginator();
		paginator.setTotal(total);
		paginator.setPage(page);
		paginator.setRows(rows);
		paginator.setParam("page");
		paginator.setUrl(request.getRequestURI());
		paginator.setQuery(request.getQueryString());
		//调用有分页功能的方法
		parameters.put("paginator", paginator);
		List<User> users = userService.selectAll(parameters);
		//返回数据
		request.setAttribute("users", users);
		request.setAttribute("paginator", paginator);
		return "/user/list";
	}
	
	/**
	 * 新增get
	 *
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "/user/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Validated User user, BindingResult binding) {
		if (binding.hasErrors()) {
			binding.getAllErrors().forEach(error -> logger.error(error.getDefaultMessage()));
			return "/user/add";
		}
		user.setCtime(System.currentTimeMillis());
		userService.getMapper().insertSelective(user);
		return "redirect:/user/list";
	}
	
	/**
	 * 新增post2,返回自增主键值
	 *
	 * @param user
	 * @param binding
	 * @return
	 */
	@RequestMapping(value = "/add2", method = RequestMethod.POST)
	public String add2(@Validated User user, BindingResult binding) {
		if (binding.hasErrors()) {
			return "user/add";
		}
		user.setCtime(System.currentTimeMillis());
		userService.insertAutoKey(user);
		System.out.println(user.getId());
		return "redirect:/user/list";
	}
	
	/**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.getMapper().deleteByPrimaryKey(id);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.getMapper().selectByPrimaryKey(id));
		return "/user/update";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable int id, @Validated User user, BindingResult binding, Model model) {
		if (binding.hasErrors()) {
			model.addAttribute("errors", binding.getAllErrors());
			return "user/update/" + id;
		}
		userService.getMapper().updateByPrimaryKeySelective(user);
		return "redirect:/user/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Object upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws IOException {
		// 返回结果
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断上传文件类型
		String contentType = file.getContentType().toLowerCase();
		if ((!contentType.equals("image/jpeg")) &&
				(!contentType.equals("image/pjpeg")) &&
				(!contentType.equals("image/png")) &&
				(!contentType.equals("image/x-png")) &&
				(!contentType.equals("image/bmp")) &&
				(!contentType.equals("image/gif"))) {
			map.put(RESULT, FAILED);
			map.put(DATA, "不支持该类型的文件！");
			return map;
		}
		// 创建图片目录
		String basePath = request.getSession().getServletContext().getRealPath("/attached");
		String fileName = file.getOriginalFilename();
		String savePath = basePath + "/images/";
		File targetFile = new File(savePath, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存图片
		file.transferTo(targetFile);
		map.put(RESULT, SUCCESS);
		map.put(DATA, targetFile.getAbsoluteFile());
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajax/{id}", method = RequestMethod.GET)
	public Object ajax(@PathVariable int id) {
		return userService.getMapper().selectByPrimaryKey(id);
	}
	
}
