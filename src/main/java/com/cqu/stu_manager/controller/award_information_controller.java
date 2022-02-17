package com.cqu.stu_manager.controller;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.*;
import com.cqu.stu_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class award_information_controller {
   //竞赛相关接口
    @Autowired
    ContestMapper contestMapper;
    //获取竞赛相关的信息
    //1.获取表单信息
    @PostMapping("/upload_contest_info")
    public Result upload_contest_info(@RequestBody Contest contest){
        Result result=new Result();
        List<Contest> contestList=contestMapper.findAllContest();
        //这里是为了防止同一条数据反复上传
        for (int i=0;i<contestList.size();i++){
         //判断数据库里面有没有paper名字和待上传的paper名字以及数据库中对应学生学号和待上传学号相同的
            if(contestList.get(i).getContest_name().equals(contest.getContest_name())&&contestList.get(i).getContest_stuno().equals(contest.getContest_stuno())){
                result.setMsg("信息已经上传，请勿重复上传");
                return result;
            }
        }
        result.setMsg(contestMapper.insertContestByStudent(contest)+"条消息已经上传");
        return result;
    }
    //获取竞赛信息的证明材料











    @PostMapping("/find_all_contest_info")
    public List<Contest> find_all_contest_info()
    {
      return (contestMapper.findAllContest());
    }
    @PostMapping("/find_my_contest_info")
    public List<Contest> find_my_contest_info(@RequestBody Student student)
    {

        return (contestMapper.findContestByStuno(student));
    }


    //专利相关接口
    @Autowired
    PatentMapper patentMapper;
    @PostMapping("/find_all_patent_info")
    public List<Patent> find_all_patent_info(){
        return patentMapper.findAllPatent();
    }
    @PostMapping("/find_my_patent_info")
    public List<Patent> find_my_patent_info(@RequestBody Student student){
        return patentMapper.findPatentByStuno(student);
    }
    @PostMapping("/upload_patent_info")
    public Result up_load_patent_info(@RequestBody Patent patent){
        Result result=new Result();
        result.setMsg(patentMapper.insertPatentByStudent(patent)+"条信息上传成功");
        return result;
    }


    //项目相关接口
    @Autowired
    ProjectMapper projectMapper;
    @PostMapping("/find_all_project_info")
    public List<Project> find_all_project_info(){
        return projectMapper.findAllProject();
    }
    @PostMapping("/find_my_project_info")
    public List<Project> find_my_project_info(@RequestBody Student student){
        return projectMapper.findProjectByStuno(student);
    }
    @PostMapping("/upload_project_info")
    public Result upload_project_info(@RequestBody Project project){
        Result result=new Result();
        result.setMsg(projectMapper.insertProjectByStudent(project)+"条消息上传成功");
        return result;
    }










    //论文相关接口
    @Autowired
    PaperMapper paperMapper;

    //找到所有的获奖信息
    @PostMapping("/find_all_paper_info")
    public List<Paper> find_all_paper_info(){
        return paperMapper.findAllStuPaper();
    }

    //找到对应学生的获奖信息
    @PostMapping("/find_my_paper_info")
    public List<Paper> find_my_paper_info(@RequestBody Student student){
        return paperMapper.findPaperByStuno(student);
    }

    //上传获奖信息
    @PostMapping("upload_paper_info")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPaper(@RequestBody Paper paper){
        Result result=new Result();
        List<Paper> contestList=paperMapper.findAllStuPaper();
        for (int i=0;i<contestList.size();i++){
            if(contestList.get(i).getPaper_stuno().equals(paper.getPaper_stuno())&&contestList.get(i).getPaper_name().equals(paper.getPaper_name())){
                result.setMsg("信息已经上传，请勿重复上传");
                return result;
            }
        }
        result.setMsg(paperMapper.insertPaperByStudent(paper)+"条消息已经上传");
        return result;
    }

    //上传获奖证明材料
    @PostMapping("upload_paper_info2")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPicture(MultipartFile file, HttpServletRequest request){
        Result result = new Result();
        String newName = UUID.randomUUID().toString();
    //获取上传的文件名字，看是否为jpg文件或者pdf，不是的话直接返回错误信息
        if(file == null){
            result.setMsg("未收到文件");
            return result;
        }
        else {
            String s = file.getOriginalFilename();
            assert s != null;
            String originName = s.toUpperCase();
            if(!(originName.endsWith("JPG") || originName.endsWith("PDF") )){
                result.setMsg("文件类型错误");
                return result;
            }
            if(originName.endsWith("JPG")){
                newName += ".jpg";
            }
            else if(originName.endsWith("PDF")){
                newName += ".pdf";
            }
        }
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = sdf.format(new Date());
        String realPath = "C:\\Users\\drifter\\Desktop\\Papers" + format;//存储在本机上的路径
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder,newName));
            result.setMsg("上传成功");
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + format + newName;
            result.setData(url);
        }catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }










//志愿服务信息
    @Autowired
    Voluntary_activitiesMapper voluntary_activitiesMapper;
    @PostMapping("find_all_voluntary_activities_info")
    public List<Voluntary_activities> find_all_voluntary_activities_info(){
     return voluntary_activitiesMapper.findAllVoluntary_activities();
    }
    @PostMapping("/find_my_voluntary_activities_info")
    public List<Voluntary_activities> find_my_voluntary_activities_info(@RequestBody Student student){
     return voluntary_activitiesMapper.findVoluntary_activitiesByStuno(student);

    }
    @PostMapping("/upload_voluntary_activities_info")
    public Result upload_voluntary_activities_info(@RequestBody Voluntary_activities voluntary_activities){
        Result result=new Result();
        result.setMsg(voluntary_activitiesMapper.insertVoluntary_activitiesByStudent(voluntary_activities)+"条消息上传成功");
        return result;
    }

    //外派信息
 @Autowired
 DispatchMapper dispatchMapper;
    @PostMapping("/find_all_dispatch_info")
    public List<Dispatch> find_all_dispatch_info(){
     return dispatchMapper.findAllDispatch();
    }
    @PostMapping("find_my_dispatch_info")
    public List<Dispatch> find_my_dispatch_info(@RequestBody Student student){
     return dispatchMapper.findDispatchByStuno(student);
    }
    @PostMapping("/upload_dispatch_info")
    public Result upload_dispatch_info(@RequestBody Dispatch dispatch){
        Result result=new Result();
        result.setMsg(dispatchMapper.insertDispatchByStudent(dispatch)+"条消息上传成功");
        return result;
    }


}
