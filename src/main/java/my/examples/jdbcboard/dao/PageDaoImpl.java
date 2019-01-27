package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.BoardVO;
import my.examples.jdbcboard.util.ConnectionContextHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class PageDaoImpl implements PageDao {

    @Override
    public int getCount() {
        int result = 0;

        Connection conn = ConnectionContextHolder.getConnection();
        try{
            try(PreparedStatement ps = conn.prepareStatement(PageDaoSQL.ALLCOUNT);) {
                try(ResultSet rs = ps.executeQuery();){
                    if (rs.next()) {
                        result = rs.getInt(1);
                    }
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return result;
    }



    @Override
    public List<BoardVO> search(String sort, String value) {
        return null;
    }
}
