package user.dao;

import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;
import user.bean.UserDTO;

import java.util.List;


@Transactional
public class UserDAOMybatis implements UserDAO{

    @Setter
    private SqlSession sqlSession;


    @Override
    public void write(UserDTO userDTO) {
        sqlSession.insert("userSQL.write",userDTO);
    } // write

    @Override
    public List<UserDTO> getUserList() {
        return sqlSession.selectList("userSQL.getUserList");
    } // getUserList

    @Override
    public void updateUser(UserDTO userDTO) {

        sqlSession.update("userSQL.updateUser", userDTO);

    } // updateUser

    @Override
    public void deleteUser(UserDTO userDTO) {
        sqlSession.delete("userSQL.deleteUser", userDTO);
    } // deleteUser

} // end class
