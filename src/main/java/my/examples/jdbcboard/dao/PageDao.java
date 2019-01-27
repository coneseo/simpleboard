package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.BoardVO;

import java.util.List;

public interface PageDao {
    public int getCount();
    public List<BoardVO> search(String sort, String value);
}
