package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    private static UserDao instance = new UserDaoImpl();
    private UserDaoImpl(){}
    public static UserDao getInstance(){
        return instance;
    }
    @Override
    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = ConnectionContextHolder.getConnection();

            ps = conn.prepareStatement(UserDaoSQL.INSERT);
            ps.setString(1, user.getName());
            ps.setString(2, user.getNickname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPasswd());
            ps.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public User getUser(String email) {
        User user = null;
        Connection conn = null;
        try{
            conn = ConnectionContextHolder.getConnection();
            try( PreparedStatement ps = conn.prepareStatement(UserDaoSQL.SELECT_BY_EMAIL)) {
                ps.setString(1, email);
                try (ResultSet rs = ps.executeQuery();){
                    if (rs.next()) {
                        Long id = rs.getLong(1);
                        String name = rs.getString(2);
                        String nickname = rs.getString(3);
                        String email1 = rs.getString(4);
                        String passwd = rs.getString(5);
                        Date regdate = rs.getDate(6);

                        user = new User(id, name, nickname, email1, passwd, regdate);
                    }
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return user;
    }
 }

