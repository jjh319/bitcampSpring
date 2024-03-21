package user.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import user.bean.UserDTO;

@Repository
@Transactional
public class UserDAOMybatis implements UserDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserDTO checkId(String id) {

        return sqlSession.selectOne("userSQL.checkId", id);
    } // checkId

}  // end class
