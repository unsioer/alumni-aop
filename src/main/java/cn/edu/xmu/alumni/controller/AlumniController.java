package cn.edu.xmu.alumni.controller;

import cn.edu.xmu.alumni.entity.Alumni;
import cn.edu.xmu.alumni.service.AlumniService;
import cn.edu.xmu.alumni.vo.AlumniResponse;
import cn.edu.xmu.alumni.vo.AlumniRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Validated
@RestController
@RequestMapping("/alumni")
public class AlumniController {

    @Autowired
    AlumniService alumniService;

    @ResponseBody
    @GetMapping("")
    public AlumniResponse getAlumni(
            @RequestParam(value = "no", defaultValue = "123") String no) {
        Alumni alumni = alumniService.findByNo(no);
        return new AlumniResponse(200, alumni);
    }

    @ResponseBody
    @PostMapping("")
    public AlumniResponse addAlumni(
            @RequestBody AlumniRequest request, HttpSession session) {
        Alumni alumni = alumniService.add(request);
        if (alumni == null) {
            return new AlumniResponse(403, null);
        }
        return new AlumniResponse(200, alumni);
    }

    @ResponseBody
    @PutMapping("")
    public AlumniResponse editAlumni(
            @RequestParam(value = "id", defaultValue = "1") Long id,
            @RequestBody AlumniRequest request, HttpSession session) {
        Alumni alumni = alumniService.findById(id);
        if (alumni == null) {
            return new AlumniResponse(404, null);
        }
        alumni = alumniService.edit(request);

        return new AlumniResponse(200, alumni);
    }

}
