package cn.edu.xmu.alumni.mapper;

import cn.edu.xmu.alumni.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
