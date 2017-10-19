package com.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Article implements Serializable {

    @Id
    @GeneratedValue
    @Field(name="_id")
    private String id;
    
    @ElementCollection
    private List<Categories> categoryLists = new ArrayList<Categories>();
    
    @Basic
    private String title;
    
    @Basic
    private String content;
    
    @Basic
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    @Basic
    private String author;
    
    @ElementCollection
    private List<Tags> tagLists = new ArrayList<Tags>();

	public Article() {
		
    }

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the categoryLists
	 */
	public List<Categories> getCategoryLists() {
		return categoryLists;
	}

	/**
	 * @param categoryLists the categoryLists to set
	 */
	public void setCategoryLists(List<Categories> categoryLists) {
		this.categoryLists = categoryLists;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the tagLists
	 */
	public List<Tags> getTagLists() {
		return tagLists;
	}

	/**
	 * @param tagLists the tagLists to set
	 */
	public void setTagLists(List<Tags> tagLists) {
		this.tagLists = tagLists;
	}
		
}
