package com.study.dao.impl;

import com.study.dao.IBookDao;
import org.springframework.stereotype.Repository;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/19 16:39
 */
@Repository("bookDao")
public class BookDaoImpl implements IBookDao {

    @Override
    public void insert() {
        System.out.println("add book");
    }
}
