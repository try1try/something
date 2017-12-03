package bms.service;

import java.sql.SQLException;
import java.util.List;

import bms.dao.*;
import bms.entity.*;

public class BookServiceImpl implements BookService{

    private BookDao bookDao = new BookDao();

    @Override
    public Pager findPage(int page, int count) throws Exception {
        if(bookDao==null){
        	bookDao = new BookDao();
        }
        try {
            List<Book> books = bookDao.findBooks(page, count);
            //System.out.println(books);
            int totle = bookDao.count();
            System.out.println(totle);
            Pager p = new Pager();
            p.setBooks(books);
            p.setCurrentPage(page);
            p.setCount(count);
            p.setTotalCount(totle);
            int totlePage = totle%count==0?totle/count:(totle/count)+1;
            p.setTotalPage(totlePage);
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
