package cn.edu.xmu.alumni.mapper;

import cn.edu.xmu.alumni.entity.InsertLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InsertLogRepository
        extends JpaRepository<InsertLog, Integer>,
        JpaSpecificationExecutor<InsertLog> {

}
