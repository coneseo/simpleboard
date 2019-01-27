package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dao.PageDao;
import my.examples.jdbcboard.dao.PageDaoImpl;
import my.examples.jdbcboard.dto.BoardVO;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.util.List;

public class PageServiceImpl implements PageService {
    private final int SIZE = 5;
    @Override
    public int getCount() {
        int result = 0;
        Connection conn = null;
        PageDao pageDao = new PageDaoImpl();
        try{
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            result = pageDao.getCount();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<BoardVO> search(String sort, String value) {
        return null;
    }

    public int getlastNum(int count){
        int lastNum = 0;
        if(count%SIZE > 0){
            lastNum = (count/SIZE) + 1;
        }else{
            lastNum = count/SIZE;
        }
        return lastNum;
    }
}
