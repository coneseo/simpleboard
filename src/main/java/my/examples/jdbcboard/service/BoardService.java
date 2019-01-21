package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dto.BoardVO;

import java.util.List;

public interface BoardService {
    //page에 해당하는 목록을 읽어온다.
    //전체 건수를 읽어온다.
    //글을 읽어온다.(글읽기 + 조회수 증가)
    //글을 삭제한다.

    public List<BoardVO> getBoards(int page);
    public BoardVO getBoard(Long id);
    public void deleteBoard(Long id);
    void addBoard(BoardVO board);
    void updateBoard(BoardVO board);
    void addReBoard(BoardVO board);
}
