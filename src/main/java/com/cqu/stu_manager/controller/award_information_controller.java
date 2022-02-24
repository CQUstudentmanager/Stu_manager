package com.cqu.stu_manager.controller;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.*;
import com.cqu.stu_manager.utils.Result;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class award_information_controller {
   //竞赛相关接口
    @Autowired
    ContestMapper contestMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;

    //1.找到所有的获奖信息
    @PostMapping("/find_all_contest_info_new")
    public List<Contest> find_all_contest_info_new(@RequestBody Teacher teacher){
        List<Contest> contestList=new ArrayList<>();
        List<Contest> new_contestlist=new ArrayList<>();
        contestList=contestMapper.findAllContest();
        for(int i=0;i<contestList.size();i++){
            Contest contest=new Contest();
            if(contestList.get( i).getContest_status().equals("0")&&contestList.get(i)!=null){
               Student student=new Student();
                contest=contestList.get(i);
                student=studentMapper.findOneStudent(Integer.parseInt(contest.getContest_stuno()));
                if(student!=null)
                if(student.getStu_class().substring(0,2).equals(teacher.getT_identity().toString())){
                    new_contestlist.add(contest);
                }


            }
        }
        return new_contestlist;
    }

    //2.找到所有的已经审核的比赛信息
    @PostMapping("/find_all_contest_info_old")
    public List<Contest> find_all_contest_info_old(@RequestBody Teacher teacher){
        List<Contest> contestList=new ArrayList<>();
        List<Contest> new_contestlist=new ArrayList<>();
        contestList=contestMapper.findAllContest();
        for(int i=0;i<contestList.size();i++){
            Contest contest=new Contest();
            if(!contestList.get(i).getContest_status().equals("0")&&contestList.get(i)!=null){
                Student student=new Student();
                contest=contestList.get(i);
                student=studentMapper.findOneStudent(Integer.parseInt(contest.getContest_stuno()));
                if(student!=null)
                if(student.getStu_class().substring(0,2).equals(teacher.getT_identity().toString())){
                    new_contestlist.add(contest);
                }


            }
        }
        System.out.println(contestList);
        return new_contestlist;
    }

    //3.找到对应学生的比赛信息
    @PostMapping("/find_my_contest_info")
    public List<Contest> find_my_contest_info(@RequestBody Student student){
        return contestMapper.findContestByStuno(student);
    }

    //4.上传比赛信息
    @PostMapping("upload_contest_info")
    @ResponseBody
    @CrossOrigin
    public Result uploadContest(@RequestBody Contest contest){
        Result result=new Result();
        List<Contest> contestList=contestMapper.findAllContest();
//这里是防止重复上传
        for (int i=0;i<contestList.size();i++){
            if(contestList.get(i).getContest_stuno().equals(contest.getContest_stuno())&&contestList.get(i).getContest_name().equals(contest.getContest_name())&&contest.getContest_no().length()==0){
                result.setMsg("信息已经上传，请勿重复上传");
                return result;
            }
        }
        //这里是设置contestID
        if(contest.getContest_no().length()==0){
            String str=contest.getContest_stuno();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            contest.setContest_no(str+format);
            //插入
            result.setMsg(contestMapper.insertContestByStudent(contest)+"条消息已经上传");
            return result;
        }else {
            //更新
            result.setMsg(contestMapper.updateContestByContestNo(contest)+"条消息已经修改");
            return result;
        }

    }

    //5.上传获奖证明材料
    @PostMapping("upload_contest_info2")
    @ResponseBody
    @CrossOrigin
    public Result uploadContest2(MultipartFile file, HttpServletRequest request){
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
        String realPath = "C:\\Users\\drifter\\Desktop\\Contests" + format;//存储在本机上的路径
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder,newName));
            result.setMsg("文件上传成功");
            result.setData("C:\\Users\\drifter\\Desktop\\Contests" + format+newName);
        }catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }

    //6.判断是否有正在审核的信息
    @PostMapping("/contest_isexamineing")
    public Integer contest_isexamineing(@RequestBody Student student){
        List<Contest> contestList=new ArrayList<>();
        Integer count=0;
        contestList=contestMapper.findContestByStuno(student);
        for(int i=0;i<contestList.size();i++){
            if("0".equals(contestList.get(i).getContest_status())){
                count=1;
            }else System.out.println("你也写错了");
        }
        return count;
    }

    //7.删除信息
    @PostMapping("/delete_contest")
    public Result delete_contest(@RequestBody Contest contest){
        Result result=new Result();
        result.setMsg(contestMapper.deleteContestByStu(contest.getContest_no())+"条删除");
        return result;
    }

    //8.审核通过
    @PostMapping("/pass_contest")
    public Result pass_contest(@RequestBody Contest contest){
        contestMapper.pass_contest(contest.getContest_no());
        Result result=new Result();
        result.setMsg("通过成功");
        return result;
    }

    //9.审核未通过
    @PostMapping("/refuse_contest")
    public Result refuse_contest(@RequestBody Contest contest){
        contestMapper.refuse_contest(contest.getContest_no());
        Result result=new Result();
        result.setMsg("驳回成功");
        return result;
    }







    //获取专利相关的信息
    @Autowired
    PatentMapper patentMapper;

    //1.找到所有的未审核的专利信息
    @PostMapping("/find_all_patent_info_new")
    public List<Patent> find_all_patent_info_new(@RequestBody Teacher teacher){
        List<Patent> patentList=new ArrayList<>();
        List<Patent> patentList_new=new ArrayList<>();
        patentList=patentMapper.findAllPatent();
        for(int i=0;i<patentList.size();i++){
            if(patentList.get(i).getPatent_status().equals("0")&&patentList.get(i)!=null){
                Patent patent=patentList.get(i);
                 Student student=studentMapper.findOneStudent(Integer.parseInt(patent.getPatent_stu_no()));
                if(student!=null)
                    if(student.getStu_class().substring(0,2).equals(teacher.getT_identity().toString())){
                        patentList_new.add(patent);
                    }

            }
        }
        return patentList_new;

    }

    //2.找到所有的已经审核的专利信息
    @PostMapping("/find_all_patent_info_old")
    public List<Patent> find_all_patent_info_old(@RequestBody Teacher teacher){
        List<Patent> patentList=new ArrayList<>();
        List<Patent> patentList_old=new ArrayList<>();
        patentList=patentMapper.findAllPatent();
        for(int i=0;i<patentList.size();i++){
            if(!patentList.get(i).getPatent_status().equals("0")&&patentList.get(i)!=null){
                Student student=new Student();
                Patent patent=new Patent();
                patent=patentList.get(i);
                student=studentMapper.findOneStudent(Integer.parseInt(patent.getPatent_stu_no()));
                if(student!=null)
                    if(student.getStu_class().substring(0,2).equals(teacher.getT_identity().toString())){
                        patentList_old.add(patent);
                    }
            }
        }
        return patentList_old;
    }

    //3。找到对应学生的专利信息
    @PostMapping("find_my_patent_info")
    public List<Patent> find_my_patent_info(@RequestBody Student student){
       return patentMapper.findPatentByStuno(student);
    }

    //4.上传专利信息
    @PostMapping("upload_patent_info")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPatent(@RequestBody Patent patent){
        Result result=new Result();
        List<Patent> patentList=new ArrayList<>();
        patentList=patentMapper.findAllPatent();
        for(int i=0;i<patentList.size();i++){

            //contestList.get(i).getPaper_stuno().equals(paper.getPaper_stuno())&&contestList.get(i).getPaper_name().equals(paper.getPaper_name())&&paper.getPaper_no().length()==0
            if(patentList.get(i).getPatent_stu_no().equals(patent.getPatent_stu_no())&&patentList.get(i).getPatent_name().equals(patent.getPatent_name())&&patent.getPatent_no().length()==0){

                result.setMsg("请勿重复上传");
                return result;
            }
        }
        if(patent.getPatent_no().length()==0){
            String str=patent.getPatent_stu_no();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            patent.setPatent_no(str+format);
            //插入
            result.setMsg(patentMapper.insertPatentByStudent(patent)+"条消息已经上传");
            return result;
        }else {
            //更新
            result.setMsg(patentMapper.updatePatenByStudent(patent)+"条消息已经修改");
            return result;
        }
    }

    //5.上传专利证明材料
    @PostMapping("upload_patent_info2")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPicture_patent(MultipartFile file, HttpServletRequest request){
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
        String realPath = "C:\\Users\\drifter\\Desktop\\Patents" + format;//存储在本机上的路径
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder,newName));
            result.setMsg("文件上传成功");
            result.setData(realPath+newName);
        }catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }

    //6.查看是否有正在审核的信息
    @PostMapping("/patent_isexamineing")
    public Integer patent_isexamineing(@RequestBody Student student){
        List<Patent> patentList=new ArrayList<>();
        patentList=patentMapper.findPatentByStuno(student);
        Integer count = 0;
        for(int i=0;i<patentList.size();i++){
            if(patentList.get(i).getPatent_status().equals("0")){
                count++;
            }
        }
        return count;
    }

    //7.删除专利信息
    @PostMapping("/delete_patent")
    public Result delete_patent(@RequestBody Patent patent){
        Result result=new Result();
        result.setMsg(patentMapper.deletePatentByStu(patent.getPatent_no())+"条删除");
        return result;
    }

    //8.专利信息审核通过
    @PostMapping("/pass_patent")
    public Result pass_patent(@RequestBody Patent patent){
        patentMapper.pass_patent(patent.getPatent_no());
        Result result=new Result();
        result.setMsg("通过成功");
        return result;
    }

    //9.专利信息审核不通过
    @PostMapping("/refuse_patent")
    public Result refuse_patent(@RequestBody Patent patent){
        patentMapper.refuse_patent(patent.getPatent_no());
        Result result=new Result();
        result.setMsg("驳回成功");
        return result;
    }







    //项目
    @Autowired
    ProjectMapper projectMapper;

    //1.找到所有的未审核的项目信息
    @PostMapping("/find_all_project_info_new")
    public List<Project> find_all_project_info_new(@RequestBody Teacher teacher){
        List<Project> projects=new ArrayList<>();
        List<Project> new_projectlist=new ArrayList<>();
        projects=projectMapper.findAllProject();
        for(int i=0;i<projects.size();i++){
            Project project=new Project();
            if(projects.get(i).getProject_audit_status().equals("0")&&projects.get(i)!=null){
                project=projects.get(i);
                Student student=new Student();
                student=studentMapper.findOneStudent(Integer.parseInt(project.getProject_student_no()));
                if(student!=null)
                    if(student.getStu_class().substring(0,2).equals(teacher.getT_identity().toString())){
                        new_projectlist.add(project);
                    }

            }

        }
        return new_projectlist;
    }

    //2.找到所有的已经审核的项目信息
    @PostMapping("/find_all_project_info_old")
    public List<Project> find_all_project_info_old(@RequestBody Teacher teacher){
        List<Project> projectList=new ArrayList<>();
        List<Project> new_projectlist=new ArrayList<>();
        projectList=projectMapper.findAllProject();
        for(int i=0;i<projectList.size();i++){

            if(!projectList.get(i).getProject_audit_status().equals("0")&&projectList.get(i)!=null){
                Project project=new Project();
                project=projectList.get(i);
                Student student=new Student();
                student=studentMapper.findOneStudent(Integer.parseInt(project.getProject_student_no()));
                if(student!=null)
                    if(student.getStu_class().substring(0,2).equals(teacher.getT_identity().toString())){
                        new_projectlist.add(project);
                    }
            }

        }
        return new_projectlist;
    }

    //3.找到对应学生的项目信息
    @PostMapping("/find_my_project_info")
    public List<Project> find_my_project_info(@RequestBody Student student){
        return projectMapper.findProjectByStuno(student);
    }

    //4.上传项目信息
    @PostMapping("upload_project_info")
    @ResponseBody
    @CrossOrigin
    public Result upLoadproject(@RequestBody Project project){
        Result result=new Result();
        List<Project> projects=projectMapper.findAllProject();
        for (int i=0;i<projects.size();i++){
            if(projects.get(i).getProject_student_no().equals(project.getProject_student_no())&&projects.get(i).getProject_name().equals(project.getProject_name())&&project.getProject_no().length()==0){
                result.setMsg("信息已经上传，请勿重复上传");
                return result;
            }
        }
        //这里是设置paperID
        if(project.getProject_no().length()==0){
            String str=project.getProject_student_no();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            project.setProject_no(str+format);
            //插入
            result.setMsg(projectMapper.insertProjectByStudent(project)+"条消息已经上传");
            return result;
        }else {
            //更新
            result.setMsg(projectMapper.updateProjectByProjectNo(project)+"条消息已经修改");
        return result;
        }

    }

    //5.上传项目证明材料
    @PostMapping("upload_project_info2")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPicture_project(MultipartFile file, HttpServletRequest request){
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
        String realPath = "C:\\Users\\drifter\\Desktop\\Projects" + format;//存储在本机上的路径
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder,newName));
            result.setMsg("文件上传成功");
            result.setData(realPath+newName);
//            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + format + newName;
//            result.setData(url);
        }catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }


    //6.判断是否有正在审核的信息
    @PostMapping("/project_isexamineing")
    public Integer project_isexamineing(@RequestBody Student student){
        List<Project> projectList=new ArrayList<>();
        projectList=projectMapper.findProjectByStuno(student);
        Integer count = 0;
        System.out.println(projectList);
        for(int i=0;i<projectList.size();i++){
            if(projectList.get(i).getProject_audit_status().equals("0")){
                count++;
            }
        }
        return count;
    }

    //7.删除项目信息
    @PostMapping("/delete_project")
    public Result delete_project(@RequestBody Project project){
        Result result=new Result();
        result.setMsg(projectMapper.deleteProjectByStu(project.getProject_no())+"条删除");


        return result;
    }

    //8.项目审核通过
    @PostMapping("/pass_project")
    public Result pass_project(@RequestBody Project project){
        projectMapper.pass_project(project.getProject_no());
        Result result=new Result();
        result.setMsg("通过成功");
        return result;
    }

    //9.项目审核不通过
    @PostMapping("/refuse_project")
    public Result refuse_project(@RequestBody Project project){
        projectMapper.refuse_project(project.getProject_no());
        Result result=new Result();
        result.setMsg("驳回成功");
        return result;
    }









    //论文相关接口
    @Autowired
    PaperMapper paperMapper;

    //1.找到所有的未审核的论文信息
    @PostMapping("/find_all_paper_info_new")
    public List<Paper> find_all_paper_info(@RequestBody Teacher teacher){
        List<Paper> paperList=new ArrayList<>();
        List<Paper> new_paperlist=new ArrayList<>();
        paperList=paperMapper.findAllStuPaper();
        for(int i=0;i<paperList.size();i++){
            Paper paper=new Paper();
            if(paperList.get(i).getPaper_status().equals("0")&&paperList.get(i)!=null){
                paper=paperList.get(i);
                Student student=new Student();
                student=studentMapper.findOneStudent(Integer.parseInt(paper.getPaper_stuno()));
                if(student!=null)
                    if(student.getStu_class().substring(0,2).equals(teacher.getT_identity().toString())){
                        new_paperlist.add(paper);
                    }

            }

        }
        return new_paperlist;
    }

    //2.找到所有的已经审核的论文信息
    @PostMapping("/find_all_paper_info_old")
    public List<Paper> find_all_paper_info_old(@RequestBody Teacher teacher){
        List<Paper> paperList=new ArrayList<>();
        List<Paper> new_paperlist=new ArrayList<>();
        paperList=paperMapper.findAllStuPaper();
        for(int i=0;i<paperList.size();i++){
            Paper paper=new Paper();
            if(!paperList.get(i).getPaper_status().equals("0")&&paperList.get(i)!=null){
                paper=paperList.get(i);
                Student student=new Student();
                student=studentMapper.findOneStudent(Integer.parseInt(paper.getPaper_stuno()));
                if(student!=null)
                    if(student.getStu_class().substring(0,2).equals(teacher.getT_identity().toString())){
                        new_paperlist.add(paper);
                    }

            }

        }
        return new_paperlist;
    }

    //3.找到对应学生的论文信息
    @PostMapping("/find_my_paper_info")
    public List<Paper> find_my_paper_info(@RequestBody Student student){
        return paperMapper.findPaperByStuno(student);
    }

    //4.上传论文信息
    @PostMapping("upload_paper_info")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPaper(@RequestBody Paper paper){
        Result result=new Result();
        List<Paper> contestList=paperMapper.findAllStuPaper();
        for (int i=0;i<contestList.size();i++){
            if(contestList.get(i).getPaper_stuno().equals(paper.getPaper_stuno())&&contestList.get(i).getPaper_name().equals(paper.getPaper_name())&&paper.getPaper_no().length()==0){
                result.setMsg("信息已经上传，请勿重复上传");
                return result;
            }
        }
        //这里是设置paperID
        if(paper.getPaper_no().length()==0){
            String str=paper.getPaper_stuno();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            paper.setPaper_no(str+format);
            //插入
            result.setMsg(paperMapper.insertPaperByStudent(paper)+"条消息已经上传");
            return result;
        }else {
            //更新
            result.setMsg(paperMapper.updatePaperByPaperNo(paper)+"条消息已经修改");
            return result;
        }

    }

    //5.上传论文证明材料
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
            result.setMsg("文件上传成功");
            result.setData(realPath+newName);
        }catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }

    //6.判断是否有正在审核的信息
    @PostMapping("/paper_isexamineing")
    public Integer paper_isexamineing(@RequestBody Student student){
        List<Paper> paperList=new ArrayList<>();
        paperList=paperMapper.findPaperByStuno(student);
        Integer count = 0;
        System.out.println(paperList);
        for(int i=0;i<paperList.size();i++){
            if(paperList.get(i).getPaper_status().equals("0")){
                count++;
            }
        }
        return count;
    }

    //7.删除论文信息
    @PostMapping("/delete_paper")
    public Result delete_paper(@RequestBody Paper paper){
        Result result=new Result();
        result.setMsg(paperMapper.deletePaperByStu(paper.getPaper_no())+"条删除");


        return result;
    }

    //8.论文信息审核通过
    @PostMapping("/pass_paper")
    public Result pass_paper(@RequestBody Paper paper){
        paperMapper.pass_paper(paper.getPaper_no());
        Result result=new Result();
        result.setMsg("通过成功");
        return result;
    }

    //9.论文呢信息审核未通过
    @PostMapping("/refuse_paper")
    public Result refuse_paper(@RequestBody Paper paper){
        paperMapper.refuse_paper(paper.getPaper_no());
        Result result=new Result();
        result.setMsg("驳回成功");
        return result;
    }



}
