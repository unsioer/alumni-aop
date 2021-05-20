package cn.edu.xmu.alumni.mapper;

import cn.edu.xmu.alumni.entity.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserLogRepository
        extends JpaRepository<UserLog, Integer>,
        JpaSpecificationExecutor<UserLog> {


}
