package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.User;

public interface UserDao {
    public void addUser(User userVO);
    User getUser(String email);
}
