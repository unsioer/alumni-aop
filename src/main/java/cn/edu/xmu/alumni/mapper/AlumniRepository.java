package cn.edu.xmu.alumni.mapper;

import cn.edu.xmu.alumni.entity.Alumni;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

public interface AlumniRepository
        extends JpaRepository<Alumni, Integer>,
        JpaSpecificationExecutor<Alumni> {

    Alumni findById(Long id);

    Alumni findByNo(String no);

    @Modifying
    @Transactional
    @Query("UPDATE Alumni a SET " +
            "a.department = CASE WHEN :#{#alumni.department} IS NULL " +
            "THEN a.department ELSE :#{#alumni.department} END, " +
            "a.gender = CASE WHEN :#{#alumni.gender} IS NULL " +
            "THEN a.gender ELSE :#{#alumni.gender} END, " +
            "a.grade = CASE WHEN :#{#alumni.grade} IS NULL " +
            "THEN a.grade ELSE :#{#alumni.grade} END, " +
            "a.major = CASE WHEN :#{#alumni.major} IS NULL " +
            "THEN a.major ELSE :#{#alumni.major} END, " +
            "a.name = CASE WHEN :#{#alumni.name} IS NULL " +
            "THEN a.name ELSE :#{#alumni.name} END, " +
            "a.no = CASE WHEN :#{#alumni.no} IS NULL " +
            "THEN a.no ELSE :#{#alumni.no} END " +
            "WHERE a.id = :#{#alumni.id}")
    void myUpdate(Alumni alumni);
}
