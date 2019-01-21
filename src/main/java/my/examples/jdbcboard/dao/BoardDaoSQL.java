package my.examples.jdbcboard.dao;

public class BoardDaoSQL {
    public static final String SELECT_BY_ID =
            "SELECT id, title, nickname, content, regdate, read_count,\n" +
                    "group_no, group_seq, group_depth\n" +
                    "FROM board\n" + "where id = ?";
    public static final String SELECT_BY_PAGING =
            "SELECT id, title, nickname, regdate, read_count, \n" +
                    "group_no, group_seq, group_depth\n" +
                    "FROM board b\n" +
                    "ORDER BY group_no desc, group_seq limit ?, ?" ;
    public static final String INSERT =
            "INSERT INTO board(title,user_id,nickname,content, group_no, group_seq, group_depth) \n"+
            "VALUES(? ,?, ?, ?, 0, 0, 0) ";
    public static final String SELECT_LAST_INSERT_ID =
            "select LAST_INSERT_ID()";
    public static final String UPDATE_LAST_INSERT_ID =
            "update board set group_no = ? where id = ?";
    public static final String UPDATE_READCOUNT =
            "UPDATE board SET read_count = read_count + 1 WHERE id = ?";
    public static final String UPDATE =
            "UPDATE board SET title = ?, content = ?, nickname = ? where id=?";
    public static final String DELETE =
            "DELETE FROM BOARD WHERE id = ?";

    public static final String UPDATE_GROUP_SEQ_GT =
            "update board set group_seq = group_seq + 1 where group_no = ? and group_seq > ?";
    public static final String INSERT_RE =
            "insert into board (title, user_id, nickname, content, group_no, group_seq, group_depth) " +
                    "values( ?, ?, ?, ? ,  ? , ?, ? )";
}
