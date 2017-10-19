package com.demo.bean;

import java.util.Date;

import com.demo.dao.ArticleDAO;
import com.demo.dao.impl.ArticleDAOImpl;
import com.demo.model.Article;
import com.demo.model.Categories;
import com.demo.model.Tags;

public class TestBean {

	private ArticleDAO articleDAO;
	
	public TestBean() {
		if (articleDAO == null) {
			articleDAO = new ArticleDAOImpl();
		}		
	}

	public static void main(String[] args) {
		
		TestBean testBean = new TestBean();
		
		testBean.process();	
	}
	
	public void process() {
		
		Article article = getArticle();
		
		Article saved = (Article) this.merge(article);
		
		Article find = (Article) this.find(Article.class, saved.getId());
		
		//this.remove(find);
	
	}

	public void persist(Article article) {

		this.articleDAO.persist(article);
	}

	public Article merge(Article article) {
		
		return this.articleDAO.merge(article);
	}

	public Article find(Class clazz, String pk) {

		return this.articleDAO.getById(Article.class, pk);
	}

	public void remove(Article article) {

		this.articleDAO.remove(article);
	}

	private Article getArticle() {
		
		Article article = new Article();
		article.setAuthor("Autor");
		article.setContent("Content");
		article.setDate(new Date());
		article.setTitle("Title");

		article.getTagLists().add(new Tags("Tag 1"));
		article.getTagLists().add(new Tags("Tag 2"));
		article.getTagLists().add(new Tags("Tag 3"));

		article.getCategoryLists().add(new Categories("Category 1"));
		article.getCategoryLists().add(new Categories("Category 2"));
		article.getCategoryLists().add(new Categories("Category 3"));
		
		return article;
	}

}
