package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dto.BoardVO;
import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl implements BoardService {
    public static final int SIZE = 5;

    @Override
    public List<BoardVO> getBoards(int page) {
        BoardDao boardDao = new BoardDaoImpl();
        int start = page * SIZE -SIZE;
        int limit = SIZE;

        List<BoardVO> boards = new ArrayList<>();
        try(Connection conn = DBUtil.getInstance().getConnection();) {
            ConnectionContextHolder.setConnection(conn);
            boards = boardDao.getBoards(start, limit);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return boards;
    }

    @Override
    public BoardVO getBoard(Long id) {
        BoardVO board = null;
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try{
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            board = boardDao.getBoard(id);
            boardDao.updateReadCount(id);
            conn.commit();//트랜잭션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }
        return board;
    }

    @Override
    public void deleteBoard(Long id) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try{
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.deleteBoard(id);
            conn.commit();
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }
    }


    @Override
    public void addBoard(BoardVO board) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try{
             conn = DBUtil.getInstance().getConnection();
             ConnectionContextHolder.setConnection(conn);
             boardDao.addBoard(board);
            Long lastInsertId = boardDao.getLastInsertId();
            boardDao.updateLastInsertId(lastInsertId);
             conn.commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }

    @Override
    public void updateBoard(BoardVO board) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try{
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            boardDao.updateBoard(board);
            conn.commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }
    }

    @Override
    public void addReBoard(BoardVO board) {
        Connection conn = null;
        BoardDao boardDao = new BoardDaoImpl();
        try {
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);

            BoardVO oBoard = boardDao.getBoard(board.getId());
            board.setGrpord(oBoard.getGrpord());
            board.setGroupno(oBoard.getGroupno());
            board.setDepth(oBoard.getDepth());
            boardDao.updateGroupSeqGt(oBoard.getGroupno(), oBoard.getGrpord());
            boardDao.addReBoard(board);

            conn.commit(); // 트랜젝션 commit
        }catch(Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
    }
}
