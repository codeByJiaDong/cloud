package com.zjd.cloud.entity;

import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2020-03-24 09:22:15
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 424725708761924153L;
    
    private Integer id;
    
    private String name;
    
    private String author;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}