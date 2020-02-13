package spring.intro.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import spring.intro.model.User;

@Repository
public class UserDaoExceptionImpl implements UserDao {

    @Override
    public void add(User user) {
        throw new RuntimeException("I am new implementation");
    }

    @Override
    public List<User> listUsers() {
        throw new RuntimeException("I am new implementation");
    }
}
