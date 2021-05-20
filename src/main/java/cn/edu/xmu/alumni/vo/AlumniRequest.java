package cn.edu.xmu.alumni.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumniRequest {
    @NotEmpty
    private String name;

    @NotEmpty
    private String no;

    @NotEmpty
    private String gender;

    private String department;

    private String major;

    private Integer grade;
}
