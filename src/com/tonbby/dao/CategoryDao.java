package com.tonbby.dao;

import java.util.List;

import com.tonbby.domain.Category;

public interface CategoryDao {

	public List<Category> FindAll() throws Exception;
}

