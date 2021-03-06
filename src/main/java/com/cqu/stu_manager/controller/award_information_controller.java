package com.cqu.stu_manager.controller;
import com.cqu.stu_manager.mapper.*;
import com.cqu.stu_manager.pojo.*;
import com.cqu.stu_manager.utils.Result;
import org.apache.poi.ss.formula.functions.T;
import org.hamcrest.core.Is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
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

import static java.lang.Integer.parseInt;

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
    public List<Contest> find_all_contest_info_new(@RequestBody Teacher teacher) {
        List<Contest> contestList = new ArrayList<>();
        List<Contest> new_contestlist = new ArrayList<>();
        contestList = contestMapper.findAllContest();
        for (int i = 0; i < contestList.size(); i++) {
            Contest contest = new Contest();
            if (contestList.get(i).getContest_status().equals("0") && contestList.get(i) != null) {
                Student student = new Student();
                contest = contestList.get(i);
                student = studentMapper.findOneStudent(parseInt(contest.getContest_stuno()));
                if (student != null)
                    if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString())) {
                        new_contestlist.add(contest);
                    }


            }
        }
        return new_contestlist;
    }

    //2.找到所有的已经审核的比赛信息
    @PostMapping("/find_all_contest_info_old")
    public List<Contest> find_all_contest_info_old(@RequestBody Teacher teacher) {
        List<Contest> contestList = new ArrayList<>();
        List<Contest> new_contestlist = new ArrayList<>();
        contestList = contestMapper.findAllContest();
        for (int i = 0; i < contestList.size(); i++) {
            Contest contest = new Contest();
            if (!contestList.get(i).getContest_status().equals("0") && contestList.get(i) != null) {
                Student student = new Student();
                contest = contestList.get(i);
                student = studentMapper.findOneStudent(parseInt(contest.getContest_stuno()));
                if (student != null)
                    if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString())) {
                        new_contestlist.add(contest);
                    }


            }
        }
        System.out.println(contestList);
        return new_contestlist;
    }

    //3.找到对应学生的比赛信息
    @PostMapping("/find_my_contest_info")
    public List<Contest> find_my_contest_info(@RequestBody Student student) {
        return contestMapper.findContestByStuno(student);
    }

    //4.上传比赛信息
    @PostMapping("upload_contest_info")
    @ResponseBody
    @CrossOrigin
    public Result uploadContest(@RequestBody Contest contest) {
        Result result = new Result();
        List<Contest> contestList = contestMapper.findAllContest();
//这里是防止重复上传
        for (int i = 0; i < contestList.size(); i++) {
            if (contestList.get(i).getContest_stuno().equals(contest.getContest_stuno()) && contestList.get(i).getContest_name().equals(contest.getContest_name()) && contest.getContest_no().length() == 0) {
                result.setMsg("信息已经上传，请勿重复上传");
                return result;
            }
        }
        //这里是设置contestID
        if (contest.getContest_no().length() == 0) {
            String str = contest.getContest_stuno();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            contest.setContest_no(str + format);
            //插入
            result.setMsg(contestMapper.insertContestByStudent(contest) + "条消息已经上传");
            return result;
        } else {
            //更新
            result.setMsg(contestMapper.updateContestByContestNo(contest) + "条消息已经修改");
            return result;
        }

    }

    //5.上传获奖证明材料
    @PostMapping("upload_contest_info2")
    @ResponseBody
    @CrossOrigin
    public Result uploadContest2(MultipartFile file, HttpServletRequest request) {
        Result result = new Result();
        String newName = UUID.randomUUID().toString();
        //获取上传的文件名字，看是否为jpg文件或者pdf，不是的话直接返回错误信息
        if (file == null) {
            result.setMsg("未收到文件");
            return result;
        } else {
            String s = file.getOriginalFilename();
            assert s != null;
            String originName = s.toUpperCase();
            if (!(originName.endsWith("JPG") || originName.endsWith("PDF"))) {
                result.setMsg("文件类型错误");
                return result;
            }
            if (originName.endsWith("JPG")) {
                newName += ".jpg";
            } else if (originName.endsWith("PDF")) {
                newName += ".pdf";
            }
        }

        FilePath2 f = new FilePath2();
        String realPath = f.getPath() + "\\Contests\\" ;//存储在本机上的路径
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder, newName));
            result.setMsg("文件上传成功");
            result.setData(newName);
        } catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }

    //6.判断是否有正在审核的信息
    @PostMapping("/contest_isexamineing")
    public Integer contest_isexamineing(@RequestBody Student student) {
        List<Contest> contestList = new ArrayList<>();
        Integer count = 0;
        contestList = contestMapper.findContestByStuno(student);
        for (int i = 0; i < contestList.size(); i++) {
            if ("0".equals(contestList.get(i).getContest_status())) {
                count = 1;
            } else System.out.println("你也写错了");
        }
        return count;
    }

    //7.删除信息
    @PostMapping("/delete_contest")
    public Result delete_contest(@RequestBody Contest contest) {
        Result result = new Result();
        result.setMsg(contestMapper.deleteContestByStu(contest.getContest_no()) + "条删除");
        return result;
    }

    //8.审核通过
    @PostMapping("/pass_contest")
    public Result pass_contest(@RequestBody Contest contest) {
        contestMapper.pass_contest(contest.getContest_no());
        Result result = new Result();
        result.setMsg("通过成功");
        return result;
    }

    //9.审核未通过
    @PostMapping("/refuse_contest")
    public Result refuse_contest(@RequestBody Contest contest) {
        contestMapper.refuse_contest(contest.getContest_no());
        Result result = new Result();
        result.setMsg("驳回成功");
        return result;
    }


    //获取专利相关的信息
    @Autowired
    PatentMapper patentMapper;

    //1.找到所有的未审核的专利信息
    @PostMapping("/find_all_patent_info_new")
    public List<Patent> find_all_patent_info_new(@RequestBody Teacher teacher) {
        List<Patent> patentList = new ArrayList<>();
        List<Patent> patentList_new = new ArrayList<>();
        patentList = patentMapper.findAllPatent();
        for (int i = 0; i < patentList.size(); i++) {
            if (patentList.get(i).getPatent_status().equals("0") && patentList.get(i) != null) {
                Patent patent = patentList.get(i);
                Student student = studentMapper.findOneStudent(parseInt(patent.getPatent_stu_no()));
                if (student != null)
                    if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString())) {
                        patentList_new.add(patent);
                    }

            }
        }
        return patentList_new;

    }

    //2.找到所有的已经审核的专利信息
    @PostMapping("/find_all_patent_info_old")
    public List<Patent> find_all_patent_info_old(@RequestBody Teacher teacher) {
        List<Patent> patentList = new ArrayList<>();
        List<Patent> patentList_old = new ArrayList<>();
        patentList = patentMapper.findAllPatent();
        for (int i = 0; i < patentList.size(); i++) {
            if (!patentList.get(i).getPatent_status().equals("0") && patentList.get(i) != null) {
                Student student = new Student();
                Patent patent = new Patent();
                patent = patentList.get(i);
                student = studentMapper.findOneStudent(parseInt(patent.getPatent_stu_no()));
                if (student != null)
                    if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString())) {
                        patentList_old.add(patent);
                    }
            }
        }
        return patentList_old;
    }

    //3。找到对应学生的专利信息
    @PostMapping("find_my_patent_info")
    public List<Patent> find_my_patent_info(@RequestBody Student student) {
        return patentMapper.findPatentByStuno(student);
    }

    //4.上传专利信息
    @PostMapping("upload_patent_info")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPatent(@RequestBody Patent patent) {
        Result result = new Result();
        List<Patent> patentList = new ArrayList<>();
        patentList = patentMapper.findAllPatent();
        for (int i = 0; i < patentList.size(); i++) {

            //contestList.get(i).getPaper_stuno().equals(paper.getPaper_stuno())&&contestList.get(i).getPaper_name().equals(paper.getPaper_name())&&paper.getPaper_no().length()==0
            if (patentList.get(i).getPatent_stu_no().equals(patent.getPatent_stu_no()) && patentList.get(i).getPatent_name().equals(patent.getPatent_name()) && patent.getPatent_no().length() == 0) {

                result.setMsg("请勿重复上传");
                return result;
            }
        }
        if (patent.getPatent_no().length() == 0) {
            String str = patent.getPatent_stu_no();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            patent.setPatent_no(str + format);
            //插入
            result.setMsg(patentMapper.insertPatentByStudent(patent) + "条消息已经上传");
            return result;
        } else {
            //更新
            result.setMsg(patentMapper.updatePatenByStudent(patent) + "条消息已经修改");
            return result;
        }
    }

    //5.上传专利证明材料
    @PostMapping("upload_patent_info2")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPicture_patent(MultipartFile file, HttpServletRequest request) {
        Result result = new Result();
        String newName = UUID.randomUUID().toString();
        //获取上传的文件名字，看是否为jpg文件或者pdf，不是的话直接返回错误信息
        if (file == null) {
            result.setMsg("未收到文件");
            return result;
        } else {
            String s = file.getOriginalFilename();
            assert s != null;
            String originName = s.toUpperCase();
            if (!(originName.endsWith("JPG") || originName.endsWith("PDF"))) {
                result.setMsg("文件类型错误");
                return result;
            }
            if (originName.endsWith("JPG")) {
                newName += ".jpg";
            } else if (originName.endsWith("PDF")) {
                newName += ".pdf";
            }
        }

        FilePath2 f = new FilePath2();
        String realPath = f.getPath() + "\\Patents\\";//存储在本机上的路径
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder, newName));
            result.setMsg("文件上传成功");
            result.setData(newName);
        } catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }

    //6.查看是否有正在审核的信息
    @PostMapping("/patent_isexamineing")
    public Integer patent_isexamineing(@RequestBody Student student) {
        List<Patent> patentList = new ArrayList<>();
        patentList = patentMapper.findPatentByStuno(student);
        Integer count = 0;
        for (int i = 0; i < patentList.size(); i++) {
            if (patentList.get(i).getPatent_status().equals("0")) {
                count++;
            }
        }
        return count;
    }

    //7.删除专利信息
    @PostMapping("/delete_patent")
    public Result delete_patent(@RequestBody Patent patent) {
        Result result = new Result();
        result.setMsg(patentMapper.deletePatentByStu(patent.getPatent_no()) + "条删除");
        return result;
    }

    //8.专利信息审核通过
    @PostMapping("/pass_patent")
    public Result pass_patent(@RequestBody Patent patent) {
        patentMapper.pass_patent(patent.getPatent_no());
        Result result = new Result();
        result.setMsg("通过成功");
        return result;
    }

    //9.专利信息审核不通过
    @PostMapping("/refuse_patent")
    public Result refuse_patent(@RequestBody Patent patent) {
        patentMapper.refuse_patent(patent.getPatent_no());
        Result result = new Result();
        result.setMsg("驳回成功");
        return result;
    }


    //项目
    @Autowired
    ProjectMapper projectMapper;

    //1.找到所有的未审核的项目信息
    @PostMapping("/find_all_project_info_new")
    public List<Project> find_all_project_info_new(@RequestBody Teacher teacher) {
        List<Project> projects = new ArrayList<>();
        List<Project> new_projectlist = new ArrayList<>();
        projects = projectMapper.findAllProject();
        for (int i = 0; i < projects.size(); i++) {
            Project project = new Project();
            if (projects.get(i).getProject_audit_status().equals("0") && projects.get(i) != null) {
                project = projects.get(i);
                Student student = new Student();
                student = studentMapper.findOneStudent(parseInt(project.getProject_student_no()));
                if (student != null)
                    if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString())) {
                        new_projectlist.add(project);
                    }

            }

        }
        return new_projectlist;
    }

    //2.找到所有的已经审核的项目信息
    @PostMapping("/find_all_project_info_old")
    public List<Project> find_all_project_info_old(@RequestBody Teacher teacher) {
        List<Project> projectList = new ArrayList<>();
        List<Project> new_projectlist = new ArrayList<>();
        projectList = projectMapper.findAllProject();
        for (int i = 0; i < projectList.size(); i++) {

            if (!projectList.get(i).getProject_audit_status().equals("0") && projectList.get(i) != null) {
                Project project = new Project();
                project = projectList.get(i);
                Student student = new Student();
                student = studentMapper.findOneStudent(parseInt(project.getProject_student_no()));
                if (student != null)
                    if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString())) {
                        new_projectlist.add(project);
                    }
            }

        }
        return new_projectlist;
    }

    //3.找到对应学生的项目信息
    @PostMapping("/find_my_project_info")
    public List<Project> find_my_project_info(@RequestBody Student student) {
        return projectMapper.findProjectByStuno(student);
    }

    //4.上传项目信息
    @PostMapping("upload_project_info")
    @ResponseBody
    @CrossOrigin
    public Result upLoadproject(@RequestBody Project project) {
        Result result = new Result();
        List<Project> projects = projectMapper.findAllProject();
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getProject_student_no().equals(project.getProject_student_no()) && projects.get(i).getProject_name().equals(project.getProject_name()) && project.getProject_no().length() == 0) {
                result.setMsg("信息已经上传，请勿重复上传");
                return result;
            }
        }
        //这里是设置paperID
        if (project.getProject_no().length() == 0) {
            String str = project.getProject_student_no();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            project.setProject_no(str + format);
            //插入
            result.setMsg(projectMapper.insertProjectByStudent(project) + "条消息已经上传");
            return result;
        } else {
            //更新
            result.setMsg(projectMapper.updateProjectByProjectNo(project) + "条消息已经修改");
            return result;
        }

    }

    //5.上传项目证明材料
    @PostMapping("upload_project_info2")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPicture_project(MultipartFile file, HttpServletRequest request) {
        Result result = new Result();
        String newName = UUID.randomUUID().toString();
        //获取上传的文件名字，看是否为jpg文件或者pdf，不是的话直接返回错误信息
        if (file == null) {
            result.setMsg("未收到文件");
            return result;
        } else {
            String s = file.getOriginalFilename();
            assert s != null;
            String originName = s.toUpperCase();
            if (!(originName.endsWith("JPG") || originName.endsWith("PDF"))) {
                result.setMsg("文件类型错误");
                return result;
            }
            if (originName.endsWith("JPG")) {
                newName += ".jpg";
            } else if (originName.endsWith("PDF")) {
                newName += ".pdf";
            }
        }
        FilePath2 f = new FilePath2();
        String realPath = f.getPath() + "\\Projects\\" ;//存储在本机上的路径
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder, newName));
            result.setMsg("文件上传成功");
            result.setData(newName);
//            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + format + newName;
//            result.setData(url);
        } catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }


    //6.判断是否有正在审核的信息
    @PostMapping("/project_isexamineing")
    public Integer project_isexamineing(@RequestBody Student student) {
        List<Project> projectList = new ArrayList<>();
        projectList = projectMapper.findProjectByStuno(student);
        Integer count = 0;
        System.out.println(projectList);
        for (int i = 0; i < projectList.size(); i++) {
            if (projectList.get(i).getProject_audit_status().equals("0")) {
                count++;
            }
        }
        return count;
    }

    //7.删除项目信息
    @PostMapping("/delete_project")
    public Result delete_project(@RequestBody Project project) {
        Result result = new Result();
        result.setMsg(projectMapper.deleteProjectByStu(project.getProject_no()) + "条删除");


        return result;
    }

    //8.项目审核通过
    @PostMapping("/pass_project")
    public Result pass_project(@RequestBody Project project) {
        projectMapper.pass_project(project.getProject_no());
        Result result = new Result();
        result.setMsg("通过成功");
        return result;
    }

    //9.项目审核不通过
    @PostMapping("/refuse_project")
    public Result refuse_project(@RequestBody Project project) {
        projectMapper.refuse_project(project.getProject_no());
        Result result = new Result();
        result.setMsg("驳回成功");
        return result;
    }


    //论文相关接口
    @Autowired
    PaperMapper paperMapper;

    //1.找到所有的未审核的论文信息
    @PostMapping("/find_all_paper_info_new")
    public List<Paper> find_all_paper_info(@RequestBody Teacher teacher) {
        List<Paper> paperList = new ArrayList<>();
        List<Paper> new_paperlist = new ArrayList<>();
        paperList = paperMapper.findAllStuPaper();
        for (int i = 0; i < paperList.size(); i++) {
            Paper paper = new Paper();
            if (paperList.get(i).getPaper_status().equals("0") && paperList.get(i) != null) {
                paper = paperList.get(i);
                Student student = new Student();
                student = studentMapper.findOneStudent(parseInt(paper.getPaper_stuno()));
                if (student != null)
                    if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString())) {
                        new_paperlist.add(paper);
                    }
            }
        }
        return new_paperlist;
    }

    //2.找到所有的已经审核的论文信息
    @PostMapping("/find_all_paper_info_old")
    public List<Paper> find_all_paper_info_old(@RequestBody Teacher teacher) {
        List<Paper> paperList = new ArrayList<>();
        List<Paper> new_paperlist = new ArrayList<>();
        paperList = paperMapper.findAllStuPaper();
        for (int i = 0; i < paperList.size(); i++) {
            Paper paper = new Paper();
            if (!paperList.get(i).getPaper_status().equals("0") && paperList.get(i) != null) {
                paper = paperList.get(i);
                Student student = new Student();
                student = studentMapper.findOneStudent(parseInt(paper.getPaper_stuno()));
                if (student != null)
                    if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString())) {
                        new_paperlist.add(paper);
                    }

            }

        }
        return new_paperlist;
    }

    //3.找到对应学生的论文信息
    @PostMapping("/find_my_paper_info")
    public List<Paper> find_my_paper_info(@RequestBody Student student) {
        return paperMapper.findPaperByStuno(student);
    }

    //4.上传论文信息
    @PostMapping("upload_paper_info")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPaper(@RequestBody Paper paper) {
        Result result = new Result();
        List<Paper> contestList = paperMapper.findAllStuPaper();
        for (int i = 0; i < contestList.size(); i++) {
            if (contestList.get(i).getPaper_stuno().equals(paper.getPaper_stuno()) && contestList.get(i).getPaper_name().equals(paper.getPaper_name()) && paper.getPaper_no().length() == 0) {
                result.setMsg("信息已经上传，请勿重复上传");
                return result;
            }
        }
        //这里是设置paperID
        if (paper.getPaper_no().length() == 0) {
            String str = paper.getPaper_stuno();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            paper.setPaper_no(str + format);
            //插入
            result.setMsg(paperMapper.insertPaperByStudent(paper) + "条消息已经上传");
            return result;
        } else {
            //更新
            result.setMsg(paperMapper.updatePaperByPaperNo(paper) + "条消息已经修改");
            return result;
        }

    }

    //5.上传论文证明材料
    @PostMapping("upload_paper_info2")
    @ResponseBody
    @CrossOrigin
    public Result upLoadPicture(MultipartFile file, HttpServletRequest request) {
        Result result = new Result();
        String newName = UUID.randomUUID().toString();
        //获取上传的文件名字，看是否为jpg文件或者pdf，不是的话直接返回错误信息
        if (file == null) {
            result.setMsg("未收到文件");
            return result;
        } else {
            String s = file.getOriginalFilename();
            assert s != null;
            String originName = s.toUpperCase();
            if (!(originName.endsWith("JPG") || originName.endsWith("PDF"))) {
                result.setMsg("文件类型错误");
                return result;
            }
            if (originName.endsWith("JPG")) {
                newName += ".jpg";
            } else if (originName.endsWith("PDF")) {
                newName += ".pdf";
            }
        }

        FilePath2 f = new FilePath2();
        String realPath = f.getPath() + "\\Papers\\";//存储在本机上的路径
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder, newName));
            result.setMsg("文件上传成功");
            result.setData(newName);
        } catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }

    //6.判断是否有正在审核的信息
    @PostMapping("/paper_isexamineing")
    public Integer paper_isexamineing(@RequestBody Student student) {
        List<Paper> paperList = new ArrayList<>();
        paperList = paperMapper.findPaperByStuno(student);
        Integer count = 0;
        System.out.println(paperList);
        for (int i = 0; i < paperList.size(); i++) {
            if (paperList.get(i).getPaper_status().equals("0")) {
                count++;
            }
        }
        return count;
    }

    //7.删除论文信息
    @PostMapping("/delete_paper")
    public Result delete_paper(@RequestBody Paper paper) {
        Result result = new Result();
        result.setMsg(paperMapper.deletePaperByStu(paper.getPaper_no()) + "条删除");
        return result;
    }

    //8.论文信息审核通过
    @PostMapping("/pass_paper")
    public Result pass_paper(@RequestBody Paper paper) {
        paperMapper.pass_paper(paper.getPaper_no());
        Result result = new Result();
        result.setMsg("通过成功");
        return result;
    }

    //9.论文呢信息审核未通过
    @PostMapping("/refuse_paper")
    public Result refuse_paper(@RequestBody Paper paper) {
        paperMapper.refuse_paper(paper.getPaper_no());
        Result result = new Result();
        result.setMsg("驳回成功");
        return result;
    }


    //志愿服务相关
    @Autowired
    Voluntary_activitiesMapper voluntary_activitiesMapper;

    //1.找到所有的未审核的志愿服务信息
    @PostMapping("find_all_activity_new")
    @ResponseBody
    public List<Voluntary_activities> findAllActivityNew(@RequestBody Teacher teacher) {
        List<Voluntary_activities> activitiesList = voluntary_activitiesMapper.findAllVoluntary_activities();
        List<Voluntary_activities> result = new ArrayList<>();
        for (Voluntary_activities v : activitiesList) {
            //找到志愿活动对应的学生
            Student student = studentMapper.findOneStudent(parseInt(v.getVoluntary_activities_stu_no()));
            if(student == null){
                continue;
            }
            //看年纪是否相同，且志愿活动的状态为0
            if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString()) && v.getVoluntary_activities_status().equals("0")) {
                result.add(v);
            }
        }
        return result;
    }

    //2.找到所有的已经审核的志愿服务信息
    @PostMapping("find_all_activity_old")
    @ResponseBody
    public List<Voluntary_activities> findAllActivityOld(@RequestBody Teacher teacher) {
        List<Voluntary_activities> activitiesList = voluntary_activitiesMapper.findAllVoluntary_activities();
        List<Voluntary_activities> result = new ArrayList<>();
        for (Voluntary_activities v : activitiesList) {
            //找到志愿活动对应的学生
            Student student = studentMapper.findOneStudent(parseInt(v.getVoluntary_activities_stu_no()));
            if(student == null){
                continue;
            }
            //看年纪是否相同，且志愿活动的状态为0
            if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString()) && !v.getVoluntary_activities_status().equals("0")) {
                result.add(v);
            }
        }
        return result;
    }

    //3.找到对应学生的志愿服务信息
    @PostMapping("/find_my_activity_info")
    public List<Voluntary_activities> find_my_activity_info(@RequestBody Student student) {
        return voluntary_activitiesMapper.findVoluntary_activitiesByStuno(student);
    }

    //4.上传志愿活动信息
    @PostMapping("upload_activity_info")
    @ResponseBody
    @CrossOrigin
    public Result uploadActivity(@RequestBody Voluntary_activities activity) {
        Result result = new Result();
        List<Voluntary_activities> activityList = voluntary_activitiesMapper.findAllVoluntary_activities();
        for (int i = 0; i < activityList.size(); i++) {
            if (activity.getVoluntary_activities_no().length()==0&&activityList.get(i).getVoluntary_activities_stu_no().equals(activity.getVoluntary_activities_stu_no()) && activityList.get(i).getVoluntary_activities_content().equals(activity.getVoluntary_activities_content())) {
                result.setMsg("信息已经上传，请勿重复上传");
                return result;
            }
        }
        if (activity.getVoluntary_activities_no() == null || activity.getVoluntary_activities_no().length() == 0) {
            String str = activity.getVoluntary_activities_stu_no();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            activity.setVoluntary_activities_no(str + format);
            //插入
            result.setMsg(voluntary_activitiesMapper.insertVoluntary_activitiesByStudent(activity) + "条消息已经上传");
            return result;
        } else {
            //更新
            result.setMsg(voluntary_activitiesMapper.updateVoluntary_activitiesByStudent(activity) + "条消息已经修改");
            return result;
        }
    }

    //5.上传志愿服务证明材料
    @PostMapping("upload_activity_info2")
    @ResponseBody
    @CrossOrigin
    public Result uploadActivity2(MultipartFile file, HttpServletRequest request) {
        Result result = new Result();
        String newName = UUID.randomUUID().toString();
        //获取上传的文件名字，看是否为jpg文件或者pdf，不是的话直接返回错误信息
        if (file == null) {
            result.setMsg("未收到文件");
            return result;
        } else {
            String s = file.getOriginalFilename();
            assert s != null;
            String originName = s.toUpperCase();
            if (!(originName.endsWith("JPG") || originName.endsWith("PDF"))) {
                result.setMsg("文件类型错误");
                return result;
            }
            if (originName.endsWith("JPG")) {
                newName += ".jpg";
            } else if (originName.endsWith("PDF")) {
                newName += ".pdf";
            }
        }

        FilePath2 f = new FilePath2();
        String realPath = f.getPath() + "\\Activities\\";//存储在本机上的路径
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder, newName));
            result.setMsg("文件上传成功");
            result.setData(newName);
        } catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }

    //7.审核通过
    @PostMapping("/pass_activity")
    public Result pass_activity(@RequestBody Voluntary_activities activity) {
        voluntary_activitiesMapper.pass_activity(activity);
        Result result = new Result();
        result.setMsg("通过成功");
        return result;
    }

    //8.信息审核未通过
    @PostMapping("/refuse_activity")
    public Result refuse_activity(@RequestBody Voluntary_activities activity) {
        voluntary_activitiesMapper.refuse_activity(activity);
        Result result = new Result();
        result.setMsg("驳回成功");
        return result;
    }




    //外派相关
    @Autowired
    DispatchMapper dispatchMapper;

    //1.找到所有的未审核的外派信息
    @PostMapping("find_all_dispatch_new")
    @ResponseBody
    public List<Dispatch> findAllDispatchNew(@RequestBody Teacher teacher) {
        List<Dispatch> dispatchList = dispatchMapper.findAllDispatch();
        List<Dispatch> result = new ArrayList<>();
        for (Dispatch d : dispatchList) {
            //找到外派对应的学生
            Student student = studentMapper.findOneStudent(parseInt(d.getDispatch_stu_no()));
            if(student == null){
                continue;
            }
            //看年纪是否相同，且外派的状态为0
            if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString()) && d.getDispatch_status().equals("0")) {
                result.add(d);
            }
        }
        return result;
    }

    //2.找到所有的已经审核的外派信息
    @PostMapping("find_all_dispatch_old")
    @ResponseBody
    public List<Dispatch> findAllDispatchOld(@RequestBody Teacher teacher) {
        List<Dispatch> dispatchList = dispatchMapper.findAllDispatch();
        List<Dispatch> result = new ArrayList<>();
        for (Dispatch d : dispatchList) {
            //找到外派对应的学生
            Student student = studentMapper.findOneStudent(parseInt(d.getDispatch_stu_no()));
            if(student == null){
                continue;
            }
            //看年纪是否相同，且外派的状态不为0
            if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString()) && !d.getDispatch_status().equals("0")) {
                result.add(d);
            }
        }
        return result;
    }

    //3.找到对应学生的志外派信息
    @PostMapping("/find_my_dispatch_info")
    public List<Dispatch> find_my_dispatch_info(@RequestBody Student student) {
        return dispatchMapper.findDispatchByStuno(student);
    }

    //4.上传外派信息
    @PostMapping("upload_dispatch_info")
    @ResponseBody
    @CrossOrigin
    public Result uploadDispatch(@RequestBody Dispatch dispatch) {
        Result result = new Result();
        List<Dispatch> dispatchList = dispatchMapper.findAllDispatch();
        for (int i = 0; i < dispatchList.size(); i++) {
            if (dispatch.getDispatch_no().length()==0&&dispatchList.get(i).getDispatch_stu_no().equals(dispatch.getDispatch_stu_no()) && dispatchList.get(i).getDispatch_name().equals(dispatch.getDispatch_name())) {
                result.setMsg("信息已经上传，请勿重复上传");
                return result;
            }
        }
        if (dispatch.getDispatch_no() == null || dispatch.getDispatch_no().length() == 0) {
            String str = dispatch.getDispatch_stu_no();
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            String format = sdf.format(new Date());
            dispatch.setDispatch_no(str + format);
            //插入
            result.setMsg(dispatchMapper.insertDispatchByStudent(dispatch) + "条消息已经上传");
            return result;
        } else {
            //更新
            result.setMsg(dispatchMapper.updateDispatchByStudent(dispatch) + "条消息已经修改");
            return result;
        }
    }

    //5.上传外派证明材料
    @PostMapping("upload_dispatch_info2")
    @ResponseBody
    @CrossOrigin
    public Result uploadDispatch2(MultipartFile file, HttpServletRequest request) {
        Result result = new Result();
        String newName = UUID.randomUUID().toString();
        //获取上传的文件名字，看是否为jpg文件或者pdf，不是的话直接返回错误信息
        if (file == null) {
            result.setMsg("未收到文件");
            return result;
        } else {
            String s = file.getOriginalFilename();
            assert s != null;
            String originName = s.toUpperCase();
            if (!(originName.endsWith("JPG") || originName.endsWith("PDF"))) {
                result.setMsg("文件类型错误");
                return result;
            }
            if (originName.endsWith("JPG")) {
                newName += ".jpg";
            } else if (originName.endsWith("PDF")) {
                newName += ".pdf";
            }
        }
        FilePath2 f = new FilePath2();
        String realPath = f.getPath() + "\\Dispatches\\";//存储在本机上的路径
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder, newName));
            result.setMsg("文件上传成功");
            result.setData(newName);
        } catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }

    //6.删除外派信息
    @PostMapping("/delete_dispatch")
    public Result delete_dispatch(@RequestBody Dispatch dispatch) {
        Result result = new Result();
        result.setMsg(dispatchMapper.deleteDispatch(dispatch) + "条删除");
        return result;
    }

    //7.信息审核通过
    @PostMapping("/pass_dispatch")
    public Result pass_dispatch(@RequestBody Dispatch dispatch) {
        dispatchMapper.passDispatch(dispatch);
        Result result = new Result();
        result.setMsg("通过成功");
        return result;
    }

    //8.信息审核未通过
    @PostMapping("/refuse_dispatch")
    public Result refuse_dispatch(@RequestBody Dispatch dispatch) {
        dispatchMapper.refuseDispatch(dispatch);
        Result result = new Result();
        result.setMsg("驳回成功");
        return result;
    }

    //9.判断是否有正在审核的信息
    @PostMapping("/dispatch_isexamineing")
    public Integer dispatch_isexamineing(@RequestBody Student student) {
        List<Dispatch> dispatchList = new ArrayList<>();
        dispatchList = dispatchMapper.findDispatchByStuno(student);
        Integer count = 0;
        for (int i = 0; i < dispatchList.size(); i++) {
            if (dispatchList.get(i).getDispatch_status().equals("0")) {
                count++;
            }
        }
        return count;
    }

    //社会工作
    @Autowired
    Social_activityMapper social_activityMapper;

    //1.找到所有的社会工作信息
    @PostMapping("find_all_social_activity")
    @ResponseBody
    public List<Social_activity> findAllSocialActivity(@RequestBody Teacher teacher) {
        List<Social_activity> social_activityList = social_activityMapper.findAllSocialActivity();
        List<Social_activity> result = new ArrayList<>();
        for (Social_activity s: social_activityList) {
            //找到社会工作对应的学生
            Student student = studentMapper.findOneStudent(parseInt(s.getSocial_activity_stu_no()));
            if(student == null){
                continue;
            }
            //看年纪是否相同
            if (student.getStu_class().substring(0, 2).equals(teacher.getT_identity().toString())) {
                result.add(s);
            }
        }
        return result;
    }

    //2.找到对应学生的社会工作信息
    @PostMapping("find_my_social_activity_info")
    public List<Social_activity> find_my_social_activity_info(@RequestBody Student student) {
        return social_activityMapper.findSocialActivityByStu(student);
    }

    //3.上传社会服务信息
    @PostMapping("uploadSocialActivity")
    public Result uploadSocialActivity(@RequestBody Social_activity social_activity){
        Result result = new Result<>();
        Student student = new Student();
        student.setStu_no(Integer.parseInt(social_activity.getSocial_activity_stu_no()));
        //找到该学生的所有已上传的社会服务信息
        List<Social_activity> social_activityList = social_activityMapper.findSocialActivityByStu(student);
        //如果信息重复
        for(Social_activity s:social_activityList){
            if(s.getSocial_activity_name().equals(social_activity.getSocial_activity_name())){
                result.setMsg("当前社会服务信息已上传，请勿重复上传");
                return result;
            }
        }
        //如果信息没有重复
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String format = sdf.format(new Date());
        //social_no设置成学号加上时间
        social_activity.setSocial_activity_no(social_activity.getSocial_activity_stu_no() + format );
        social_activityMapper.insertSocialActivityByStudent(social_activity);
        result.setMsg("成功上传当前社会服务信息");
        return result;
    }

    //4.删除社会服务信息
    @PostMapping("/deleteSocialActivity")
    public Result deleteSocialActivity(@RequestBody Social_activity social_activity){
        Result result = new Result<>();
        result.setMsg(social_activityMapper.deleteSocialActivityByStudent(social_activity) + "条删除");
        return result;
    }

    //正在进行的计划

    @Autowired
    Is_doingMapper is_doingMapper;

    //1.找到对应学生的信息
    @PostMapping("find_my_is_doing")
    public Result find_my_is_doing(@RequestBody Student student){
        Result result = new Result<>();
        Is_doing is_doing = is_doingMapper.find_my_is_doing(student);
        if(is_doing == null){
            result.setMsg("当前学生没有正在进行的计划");
        }
        else {
            result.setMsg("当前学生正在进行的计划如下");
            List<Member> memberList = is_doingMapper.find_my_member(is_doing.getIs_doing_name());
            List<String> nameList = new ArrayList<>();
            for(Member m:memberList){
                nameList.add(m.getIs_doing_member_name());
            }
            is_doing.setIs_doing_member(nameList);
            result.setData(is_doing);
        }
        return result;
    }

    //2.学生上传信息
    @PostMapping("upload_is_doing")
    public Result upload_is_doing(@RequestBody Is_doing is_doing){
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String format = sdf.format(new Date());
        is_doing.setIs_doing_no(format+is_doing.getIs_doing_stu_no());
        Result result = new Result<>();
        //找到该学生是否已经上传一个正在进行的计划
        Student student = new Student();
        student.setStu_no(Integer.parseInt(is_doing.getIs_doing_stu_no()));
        Is_doing is_doing_old = is_doingMapper.find_my_is_doing(student);
        if(is_doing_old == null){
            result.setMsg("上传成功");
        }
        else {
            //先删除原来的信息
            is_doingMapper.delete_is_doing(is_doing_old);
            is_doingMapper.delete_is_doing_member(is_doing_old.getIs_doing_name());
            result.setMsg("已覆盖原有正在进行中的计划");
        }
        //插入is_doing表
        is_doingMapper.insert_is_doing(is_doing);
        //插入is_doing_member表
        Member m = new Member();
        m.setIs_doing_name(is_doing.getIs_doing_name());
        for(String s:is_doing.getIs_doing_member()){
            m.setIs_doing_member_name(s);
            is_doingMapper.insert_is_doing_member(m);
        }
        return result;
    }

    //3.删除相关
    @PostMapping("delete_is_doing")
    public Result delete_is_doing(@RequestBody Is_doing is_doing){
        Result result = new Result<>();
        Student student = new Student();
        student.setStu_no(Integer.parseInt(is_doing.getIs_doing_stu_no()));
        Is_doing is_doing_old = is_doingMapper.find_my_is_doing(student);
        if(is_doing_old == null || is_doing_old.getIs_doing_name()!= is_doing.getIs_doing_name()){
            result.setMsg("错误！");
            return result;
        }
        is_doingMapper.delete_is_doing(is_doing);
        is_doingMapper.delete_is_doing_member(is_doing.getIs_doing_name());
        result.setMsg("删除成功");
        return  result;
    }

    //计划开展
    @Autowired
    PlanMapper planMapper;

    //1.找到学生的计划
    @PostMapping("find_my_plan")
    public Result find_my_plan(@RequestBody Student student){
        Result result = new Result<>();
        Plan plan = planMapper.findMyPlan(student);
        if(plan == null){
            result.setMsg("当前学生无计划");
        }else {
            result.setMsg("当前学生的计划如下");
            result.setData(plan);
        }
        return result;
    }

    //2.上传计划
    @PostMapping("upload_plan")
    public Result upload_plan(@RequestBody Plan plan){
        Result result = new Result<>();
        //设置no
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String format = sdf.format(new Date());
        plan.setPlan_no(format+plan.getPlan_stu_no());
        //删除原有的计划
        Student student =new Student();
        student.setStu_no(Integer.parseInt(plan.getPlan_stu_no()));
        Plan plan_old = planMapper.findMyPlan(student);
        if(plan_old == null){
            result.setMsg("上传成功");
        }else {
            planMapper.deletePlan(plan_old);
            result.setMsg("已覆盖原有计划");
        }
        planMapper.insertPlan(plan);
        return result;
    }

    //3.删除计划
    @PostMapping("delete_plan")
    public Result delete_plan(@RequestBody Plan plan){
        Result result = new Result<>();
        planMapper.deletePlan(plan);
        return result;
    }
}
