package com.amg.web.servicelmpl;

import java.util.List;

import com.amg.web.domain.CategoryDTO;
import com.amg.web.service.CategoryService;

import org.springframework.stereotype.Service;

/**
 * CategoryServiceImpl
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public void addCategory(CategoryDTO category) {

    }

    @Override
    public List<CategoryDTO> findCategories() {
        return null;
    }

    @Override
    public List<CategoryDTO> findCategoriesByOption(CategoryDTO option) {
        return null;
    }

    @Override
    public CategoryDTO findCategoryByCategoryId(String categoryId) {
        return null;
    }

    @Override
    public void updateCategory(CategoryDTO category) {

    }

    @Override
    public void deleteCategory(CategoryDTO category) {

    }

    
}