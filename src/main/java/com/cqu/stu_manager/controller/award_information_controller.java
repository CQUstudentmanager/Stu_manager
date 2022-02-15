package com.cqu.stu_manager.controller;
import com.cqu.stu_manager.mapper.ContestMapper;
import com.cqu.stu_manager.mapper.PaperMapper;
import com.cqu.stu_manager.mapper.PatentMapper;
import com.cqu.stu_manager.mapper.ProjectMapper;
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
    @PostMapping("/Tea/find_all_contest_info")
    public List<Contest> find_all_contest_info()
    {
      return (contestMapper.findAllContest());
    }
    @PostMapping("/Stu/find_my_contest_info")
    public List<Contest> find_my_contest_info(@RequestBody Student student)
    {

        return (contestMapper.findContestByStuno(student));
    }


    //专利相关接口
    @Autowired
    PatentMapper patentMapper;
    @PostMapping("/Tea/find_all_patent_info")
    public List<Patent> find_all_patent_info(){
        return patentMapper.findAllPatent();
    }
    @PostMapping("/Stu/find_my_patent_info")
    public List<Patent> find_my_patent_info(@RequestBody Student student){
        return patentMapper.findPatentByStuno(student);
    }


    //项目相关接口
    @Autowired
    ProjectMapper projectMapper;
    @PostMapping("/Tea/find_all_project_info")
    public List<Project> find_all_project_info(){
        return projectMapper.findAllProject();

    }
    @PostMapping("Stu/find_my_project_info")
    public List<Project> find_my_project_info(@RequestBody Student student){
        return projectMapper.findProjectByStuno(student);
    }

    //论文相关接口
    @Autowired
    PaperMapper paperMapper;
    @PostMapping("Tea/find_all_paper_info")
    public List<Paper> find_all_paper_info(){
        return paperMapper.findAllStuPaper();
    }
    @PostMapping("Tea/find_my_paper_info")
    public List<Paper> find_my_paper_info(@RequestBody Student student){
        return paperMapper.findPaperByStuno(student);
    }

}
