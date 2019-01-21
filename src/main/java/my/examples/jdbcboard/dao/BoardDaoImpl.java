package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.BoardVO;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {
    @Override
    public BoardVO getBoard(Long idParam) {
        BoardVO board = null;

        Connection conn = ConnectionContextHolder.getConnection();
        try {
            conn = ConnectionContextHolder.getConnection();

            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_BY_ID);) {
                ps.setLong(1, idParam); // 첫번째 물음표에 5를 바인딩한다.

                try (ResultSet rs = ps.executeQuery();) { // SELECT 문장을 실행, executeUpdate() - insert, update, delete
                    if (rs.next()) {
                        long id = rs.getLong(1);
                        String title = rs.getString(2);
                        String nickname = rs.getString(3);
                        String content = rs.getString(4);
                        Date regdate = rs.getDate(5);
                        int readCount = rs.getInt(6);
                        int groupno = rs.getInt(7);
                        int grpord = rs.getInt(8);
                        int depth = rs.getInt(9);

                        board = new BoardVO(id, title, nickname, content, regdate, readCount, groupno, grpord, depth);
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return board;
    }

    @Override
    public List<BoardVO> getBoards(int start, int limit) {
        List<BoardVO> list = new ArrayList<>();
        Connection conn = ConnectionContextHolder.getConnection();
        try {
            // a. DB 연결 - Connection
            //    DB연결을 하려면 필요한 정보가 있다. Driver classname, DB URL, DB UserId , DB User Password

            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_BY_PAGING);) {
                // c. 바인딩 - PreparedStatement
                ps.setInt(1, start);
                ps.setInt(2, limit);

                // d. SQL 실행 - PreparedStatement
                try (ResultSet rs = ps.executeQuery();) { // SELECT 문장을 실행, executeUpdate() - insert, update, delete

                    // e. 1건의 row를 읽어온다. row는 여러개의 컬럼으로 구성되어 있다. - ResultSet
                    // f. e에서 읽어오지 못하는 경우도 있다.
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        String title = rs.getString(2);
                        String nickname = rs.getString(3);
                        Date regdate = rs.getDate(4);
                        int readCount = rs.getInt(5);
                        int groupno = rs.getInt(6);
                        int grpord = rs.getInt(7);
                        int depth = rs.getInt(8);

                        BoardVO board = new BoardVO(id, title, nickname, regdate, readCount, groupno, grpord, depth);
                        list.add(board);
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return list;
    }

    @Override
    public void addBoard(BoardVO board) {
        Connection conn = ConnectionContextHolder.getConnection();
        try{

           try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.INSERT);) {
               ps.setString(1, board.getTitle());
               ps.setLong(2, board.getUserId());
               ps.setString(3, board.getNickname());
               ps.setString(4, board.getContent());
               ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
           }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public Long getLastInsertId() {
        Long lastId = 0L;

        Connection conn = ConnectionContextHolder.getConnection();
        try{
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.SELECT_LAST_INSERT_ID);) {
                try(ResultSet rs = ps.executeQuery();){
                    if (rs.next()) {
                        lastId = rs.getLong(1);
                    }
                }
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return lastId;
    }

    @Override
    public void updateLastInsertId(Long id) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_LAST_INSERT_ID);) {
                ps.setLong(1, id);
                ps.setLong(2, id);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBoard(Long id) {
        Connection conn = ConnectionContextHolder.getConnection();
        try{

            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.DELETE);) {
                ps.setLong(1, id);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateReadCount(Long id) {
        Connection conn = ConnectionContextHolder.getConnection();

        try{
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_READCOUNT);) {
                ps.setLong(1, id);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateBoard(BoardVO board) {
        Connection conn = ConnectionContextHolder.getConnection();
        try{
           try(PreparedStatement ps= conn.prepareStatement(BoardDaoSQL.UPDATE);) {
               ps.setString(1, board.getTitle());
               ps.setString(2, board.getContent());
               ps.setString(3, board.getNickname());
               ps.setLong(4, board.getId());
               ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
           }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateGroupSeqGt(int groupNo, int groupSeq) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.UPDATE_GROUP_SEQ_GT);) {
                ps.setInt(1, groupNo);
                ps.setInt(2, groupSeq);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void addReBoard(BoardVO board) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            try(PreparedStatement ps = conn.prepareStatement(BoardDaoSQL.INSERT_RE);) {

                //title, user_id, nickname, content
                ps.setString(1, board.getTitle());
                ps.setLong(2, board.getUserId());
                ps.setString(3, board.getNickname());
                ps.setString(4, board.getContent());
                ps.setInt(5, board.getGroupno());
                ps.setInt(6, board.getGrpord() + 1);
                ps.setInt(7, board.getDepth() + 1);
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    }

