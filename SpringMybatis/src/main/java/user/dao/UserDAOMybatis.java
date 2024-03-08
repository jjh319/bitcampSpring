package user.dao;

import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import user.bean.UserDTO;

import java.util.List;


@Transactional
@Repository
public class UserDAOMybatis implements UserDAO{

    @Autowired
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
