package org.lanqiao.taru.library.model;

import java.util.List;

public class Category {
    private String categoryId;
    private String categoryName;
    private String categoryFatherId;
    private String categoryStatus;
    private List<Category> categories;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryFatherId() {
        return categoryFatherId;
    }

    public void setCategoryFatherId(String categoryFatherId) {
        this.categoryFatherId = categoryFatherId;
    }

    public String getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(String categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
