package cn.edu.xmu.alumni.ascept;

import cn.edu.xmu.alumni.entity.User;
import cn.edu.xmu.alumni.entity.UserLog;
import cn.edu.xmu.alumni.mapper.UserLogRepository;
import cn.edu.xmu.alumni.mapper.UserRepository;
import cn.edu.xmu.alumni.vo.UserRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;


@Aspect
@Component
public class UserLogAscept {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserLogRepository userLogRepository;

    @Around("execution(* cn.edu.xmu.alumni.controller.UserController.login(..))")
    public Object loginAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        UserRequest request=(UserRequest)joinPoint.getArgs()[0];
        User user = userRepository.findByUserName(request.getUserName());
        if(user!=null)
        {
            UserLog log=new UserLog(user.getId(), "login");
            userLogRepository.saveAndFlush(log);
        }
        return joinPoint.proceed();
    }

    @Around("execution(* cn.edu.xmu.alumni.controller.UserController.logout(..))")
    public Object logoutAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpSession session =(HttpSession) joinPoint.getArgs()[0];
        String userName=(String)session.getAttribute("userName");
        if (userName!=null){
            User user = userRepository.findByUserName(userName);
            if(user!=null)
            {
                UserLog log=new UserLog(user.getId(), "logout");
                userLogRepository.saveAndFlush(log);
            }
        }
        return joinPoint.proceed();
    }
}
