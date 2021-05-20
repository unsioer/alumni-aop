package cn.edu.xmu.alumni.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotEmpty
    String userName;

    @NotEmpty
    String password;

}
