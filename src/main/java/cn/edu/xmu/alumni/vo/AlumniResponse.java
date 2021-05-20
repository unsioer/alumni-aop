package cn.edu.xmu.alumni.vo;

import cn.edu.xmu.alumni.entity.Alumni;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumniResponse {
    Integer state;
    Alumni alumni;
}
