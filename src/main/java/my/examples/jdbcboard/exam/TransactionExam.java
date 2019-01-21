package my.examples.jdbcboard.exam;

import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionExam {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DBUtil.getInstance().getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into board(title,content,writer) values('kkk','lll','lll')";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.clearParameters();

            conn.commit();
        }catch (Exception ex){
            try{conn.rollback();}catch(Exception ignore){}
            ex.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }

    }
}
