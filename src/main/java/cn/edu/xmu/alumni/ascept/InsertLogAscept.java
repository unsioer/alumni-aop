package cn.edu.xmu.alumni.ascept;

import cn.edu.xmu.alumni.entity.InsertLog;
import cn.edu.xmu.alumni.entity.User;
import cn.edu.xmu.alumni.entity.UserLog;
import cn.edu.xmu.alumni.mapper.InsertLogRepository;
import cn.edu.xmu.alumni.mapper.UserRepository;
import cn.edu.xmu.alumni.vo.AlumniRequest;
import cn.edu.xmu.alumni.vo.UserRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class InsertLogAscept {
    @Autowired
    UserRepository userRepository;

    @Autowired
    InsertLogRepository insertLogRepository;

    @Around("execution(* cn.edu.xmu.alumni.controller.AlumniController.addAlumni(..))")
    public Object addAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("插入校友信息切面");
        HttpSession session = (HttpSession) joinPoint.getArgs()[1];
        String userName = (String) session.getAttribute("userName");
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            AlumniRequest request = (AlumniRequest) joinPoint.getArgs()[0];
            InsertLog log = new InsertLog(user.getId(), "add", null, request);
            insertLogRepository.saveAndFlush(log);
        }
        return joinPoint.proceed();
    }

    @Around("execution(* cn.edu.xmu.alumni.controller.AlumniController.editAlumni(..))")
    public Object editAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("修改校友信息切面");
        HttpSession session = (HttpSession) joinPoint.getArgs()[2];
        String userName = (String) session.getAttribute("userName");
        User user = userRepository.findByUserName(userName);
        if (user != null) {
            Long id = (Long) joinPoint.getArgs()[0];
            AlumniRequest request = (AlumniRequest) joinPoint.getArgs()[1];
            InsertLog log = new InsertLog(user.getId(), "edit", id, request);
            insertLogRepository.saveAndFlush(log);
        }

        return joinPoint.proceed();
    }
}
