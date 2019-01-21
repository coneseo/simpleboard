package my.examples.jdbcboard.dao;

public class UserDaoSQL {
    public static final String INSERT = "INSERT INTO user (name, nickname, email, passwd) VALUES (?, ?, ?, ?)";
    public static final String SELECT_BY_EMAIL = "SELECT id, name, nickname, email, passwd, regdate FROM user WHERE email = ?";
}
