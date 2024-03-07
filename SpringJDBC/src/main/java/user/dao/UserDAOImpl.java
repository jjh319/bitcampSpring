package user.dao;

import lombok.Setter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import user.bean.UserDTO;

import java.util.List;

//public class UserDAOImpl implements UserDAO{
//    @Setter
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public void write(UserDTO userDTO) {
//
//        String sql="insert into usertable values(?,?,?)";
//        jdbcTemplate.update(sql,userDTO.getName(),userDTO.getId(),userDTO.getPwd());
//
//    }
//
//    @Override
//    public List<UserDTO> getUserList() {
//
//        String sql="select * from usertable";
//        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
//
//    }
//
//}

public class UserDAOImpl extends JdbcDaoSupport implements UserDAO{

    @Override
    public void write(UserDTO userDTO) {

        String sql="insert into usertable values(?,?,?)";
        getJdbcTemplate().update(sql,userDTO.getName(),userDTO.getId(),userDTO.getPwd());

    } // write

    @Override
    public List<UserDTO> getUserList() {

        String sql="select * from usertable";
        return getJdbcTemplate().query(sql,new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
    } // getUserList

} // end class
