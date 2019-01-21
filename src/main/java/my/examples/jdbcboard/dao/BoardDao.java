package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.BoardVO;

import java.util.List;

public interface BoardDao {
    public BoardVO getBoard(Long id);
    public List<BoardVO> getBoards(int start, int limit);
    public void addBoard(BoardVO board);

    void deleteBoard(Long id);

    void updateReadCount(Long id);

    void updateBoard(BoardVO board);

    Long getLastInsertId();
    void updateLastInsertId(Long id);
    void updateGroupSeqGt(int groupNo, int groupSeq);
    void addReBoard(BoardVO board);
}
