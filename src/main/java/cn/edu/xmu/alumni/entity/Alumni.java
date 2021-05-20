package cn.edu.xmu.alumni.entity;

import cn.edu.xmu.alumni.vo.AlumniRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alumni")
public class Alumni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Alumni(Long id) { this.id = id; }

    public Alumni(AlumniRequest alumni){
        this.name=alumni.getName();
        this.no=alumni.getNo();
        this.gender=alumni.getGender();
        this.department=alumni.getDepartment();
        this.major=alumni.getMajor();
        this.grade=alumni.getGrade();
    }
    
    public Alumni(Long id, AlumniRequest alumni){
        this.id = id;
        this.name=alumni.getName();
        this.no=alumni.getNo();
        this.gender=alumni.getGender();
        this.department=alumni.getDepartment();
        this.major=alumni.getMajor();
        this.grade=alumni.getGrade();
    }
}
