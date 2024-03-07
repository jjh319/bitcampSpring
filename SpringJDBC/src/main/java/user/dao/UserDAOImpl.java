package user.dao;

import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import user.bean.UserDTO;

public class UserDAOImpl implements UserDAO{

    @Setter
    private JdbcTemplate jdbcTemplate;


    @Override
    public void write(UserDTO userDTO) {
        String sql = "insert into usertable value(?,?,?)";
        jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());

    } // write

} // end class
