package my.examples.jdbcboard.service;

import my.examples.jdbcboard.dao.UserDao;
import my.examples.jdbcboard.dao.UserDaoImpl;
import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.util.ConnectionContextHolder;
import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserServiceImpl implements UserService {
    private static UserService instance = new UserServiceImpl();
    private UserServiceImpl(){}
    public static UserService getInstance(){
        return instance;
    }
    @Override
    public void addUser(User user) {
        Connection conn = null;
        UserDao userDao = UserDaoImpl.getInstance();
        try{
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            userDao.addUser(user);
            conn.commit();
        }catch (Exception ex){
            DBUtil.rollback(conn);
            ex.printStackTrace();
        }finally{
            DBUtil.close(conn);
        }
    }

    @Override
    public User getUser(String email) {
        Connection conn = null;
        UserDao userDao = UserDaoImpl.getInstance();
        User user = null;
        try{
            conn = DBUtil.getInstance().getConnection();
            ConnectionContextHolder.setConnection(conn);
            user = userDao.getUser(email);
            conn.commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            DBUtil.close(conn);
        }
        return user;
    }
}
