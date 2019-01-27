package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dto.BoardVO;

import java.util.List;

public interface PageService {
    public int getCount();
    public List<BoardVO> search(String sort, String value);
}
