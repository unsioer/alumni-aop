package cn.edu.xmu.alumni.service;

import cn.edu.xmu.alumni.entity.User;
import cn.edu.xmu.alumni.mapper.UserRepository;
import cn.edu.xmu.alumni.vo.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public int login(UserRequest userRequest){
        String userName=userRequest.getUserName();
        String password=userRequest.getPassword();
        User user=userRepository.findByUserName(userName);
        if(user==null){return 404;}
        if(!password.equals(user.getPassword())) {return 403;}
        return 200;
    }
}
