package com.tonbby.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tonbby.domain.Category;
import com.tonbby.service.CategoryService;
import com.tonbby.service.impl.CategoryServiceImpl;
import com.tonbby.utils.JsonUtil;

import net.sf.json.JSONArray;

public class CategoryServlet extends BaseServlet {

	public String FindAll(HttpServletRequest request,HttpServletResponse response) throws Exception{
		CategoryService cs = new CategoryServiceImpl();
		List<Category> clist = cs.FindAll();
	
		String json = JSONArray.fromObject(clist).toString();

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(json);
		return null;
		
	}
	
}
