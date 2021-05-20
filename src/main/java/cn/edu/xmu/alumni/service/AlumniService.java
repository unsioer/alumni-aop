package cn.edu.xmu.alumni.service;

import cn.edu.xmu.alumni.entity.Alumni;
import cn.edu.xmu.alumni.mapper.AlumniRepository;
import cn.edu.xmu.alumni.vo.AlumniRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumniService {
    @Autowired
    private AlumniRepository alumniRepository;

    public Alumni findById(Long id){
        return alumniRepository.findById(id);
    }

    public Alumni findByNo(String no){
        return alumniRepository.findByNo(no);
    }

    public Alumni add(AlumniRequest request){
        Alumni alumni=findByNo(request.getNo());
        if(alumni!=null) {return null;}
        alumni=new Alumni(request);
        alumni=alumniRepository.saveAndFlush(alumni);
        return alumni;
    }

    public Alumni edit(AlumniRequest request){
        Alumni alumni=findByNo(request.getNo());
        if(alumni==null) {return null;}
        alumni=new Alumni(alumni.getId(),request);
        System.out.println(alumni);
        alumniRepository.myUpdate(alumni);
        return alumni;
    }

    public Alumni delete(){
        return null;
    }
}
