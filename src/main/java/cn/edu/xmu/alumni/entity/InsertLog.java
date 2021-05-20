package cn.edu.xmu.alumni.entity;

import cn.edu.xmu.alumni.vo.AlumniRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "insert_log")
public class InsertLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long uid;

    private String operation;

    private Long aid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String no;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = true)
    private String department;

    @Column(nullable = true)
    private String major;

    @Column(nullable = true)
    private Integer grade;

    @CreationTimestamp
    private Date dateTime;

    public InsertLog(Long uid, String operation, Long aid, AlumniRequest alumni) {
        this.uid = uid;
        this.operation = operation;
        this.aid = aid;
        this.name = alumni.getName();
        this.no = alumni.getNo();
        this.gender = alumni.getGender();
        this.department = alumni.getDepartment();
        this.major = alumni.getMajor();
        this.grade = alumni.getGrade();
    }
}
