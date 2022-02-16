package com.cqu.stu_manager.controller;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.*;
import com.cqu.stu_manager.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        result.setMsg(contestMapper.insertContestByStudent(contest)+"条上传信息成功");
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
    @PostMapping("/find_all_paper_info")
    public List<Paper> find_all_paper_info(){
        return paperMapper.findAllStuPaper();
    }
    @PostMapping("/find_my_paper_info")
    public List<Paper> find_my_paper_info(@RequestBody Student student){
        return paperMapper.findPaperByStuno(student);
    }
    @PostMapping("/upload_paper_info")
    public Result upload_paper_info(@RequestBody Paper paper){
        Result result=new Result();
        result.setMsg(paperMapper.insertPaperByStudent(paper)+"条消息上传成功");
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
