package com.tonbby.service;

import java.util.List;

import com.tonbby.domain.Category;

public interface CategoryService {

	public List<Category> FindAll() throws Exception;
}
