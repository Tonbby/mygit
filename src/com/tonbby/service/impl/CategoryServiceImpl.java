package com.tonbby.service.impl;

import java.util.List;



import com.tonbby.dao.CategoryDao;
import com.tonbby.dao.impl.CategoryDaoImpl;
import com.tonbby.domain.Category;
import com.tonbby.service.CategoryService;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.management.Cache;

public class CategoryServiceImpl implements CategoryService {

	/**
	 * 在这里处理缓存
	 * */
	public List<Category> FindAll() throws Exception {
		CacheManager cm = CacheManager.
				create(CategoryServiceImpl.class.getClassLoader()
						.getResourceAsStream("ehcache.xml"));
		
		//获取指定的缓存
		net.sf.ehcache.Cache cache = cm.getCache("categoryCache");
		//通过缓存获取数据，将cache看成map集合
		Element element = cache.get("clist");
		
		List<Category> list = null;
		
		if(element == null){
			//如果缓存中没有数据，就从数据库中获取，并将List放入缓存
			CategoryDao dao = new CategoryDaoImpl();
			list = dao.FindAll();
			cache.put(new Element("clist",list));
			System.out.println("从数据库中获取了");
		}else{
			list = (List<Category>) element.getObjectValue();
			System.out.println("缓存中获取");
		}
		return list;
	}

}
