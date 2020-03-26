package com.zjd.cloud.controller;

import com.zjd.cloud.entity.Book;
import com.zjd.cloud.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Book)表控制层
 *
 * @author makejava
 * @since 2020-03-24 09:22:19
 */
@RestController
@RequestMapping("book")
public class BookController {
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Book selectOne(Integer id) {
        return this.bookService.queryById(id);
    }

}