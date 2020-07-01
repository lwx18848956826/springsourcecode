package com.study.service.impl;

import com.study.dao.IBookDao;
import com.study.service.IBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 16:39
 */
@Service("bookService")
public class BookServiceImpl implements IBookService {

    @Resource
    private IBookDao bookDao;

    public BookServiceImpl(IBookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setBookDao(IBookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void addBook() {
        this.bookDao.insert();
    }

}
