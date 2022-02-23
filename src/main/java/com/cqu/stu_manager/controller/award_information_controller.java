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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class award_information_controller {
   //竞赛相关接口
    @Autowired
    ContestMapper contestMapper;

    //1.找到所有的获奖信息
    @PostMapping("/find_all_contest_info_new")
    public List<Contest> find_all_contest_info_new(){
        List<Contest> contestList=new ArrayList<>();
        List<Contest> new_contestlist=new ArrayList<>();
        contestList=contestMapper.findAllContest();
        for(int i=0;i<contestList.size();i++){
            Contest contest=new Contest();
            if(contestList.get( i).getContest_status().equals("0")&&contestList.get(i)!=null){
                contest=contestList.get(i);
                new_contestlist.add(contest);
            }
        }
        return new_contestlist;
    }

    //2.找到所有的已经审核的比赛信息
    @PostMapping("/find_all_contest_info_old")
    public List<Contest> find_all_contest_info_old(){
        List<Contest> contestList=new ArrayList<>();
        List<Contest> new_contestlist=new ArrayList<>();
        contestList=contestMapper.findAllContest();
        for(int i=0;i<contestList.size();i++){
            Contest contest=new Contest();
            if(!contestList.get(i).getContest_status().equals("0")&&contestList.get(i)!=null){
                contest=contestList.get(i);
                new_contestlist.add(contest);
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



























//    //获取竞赛相关的信息
@Autowired
PatentMapper patentMapper;


    @PostMapping("/find_all_patent_info_new")
    public List<Patent> find_all_patent_info_new(){
        List<Patent> patentList=new ArrayList<>();
        List<Patent> patentList_new=new ArrayList<>();
        patentList=patentMapper.findAllPatent();
        for(int i=0;i<patentList.size();i++){
            if(patentList.get(i).getPatent_status().equals("0")&&patentList.get(i)!=null){
                patentList_new.add(patentList.get(i));
            }
        }
        return patentList_new;

    }
    @PostMapping("/find_all_patent_info_old")
    public List<Patent> find_all_patent_info_old(){
        List<Patent> patentList=new ArrayList<>();
        List<Patent> patentList_old=new ArrayList<>();
        patentList=patentMapper.findAllPatent();
        for(int i=0;i<patentList.size();i++){
            if(!patentList.get(i).getPatent_status().equals("0")&&patentList.get(i)!=null){
                patentList_old.add(patentList.get(i));
            }
        }
        return patentList_old;
    }
    @PostMapping("find_my_patent_info")
    public List<Patent> find_my_patent_info(@RequestBody Student student){
       return patentMapper.findPatentByStuno(student);
    }
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
        String realPath = "C:\\Users\\drifter\\Desktop\\Patent" + format;//存储在本机上的路径
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder,newName));
            result.setMsg("文件上传成功");
            result.setData(newName);
//            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + format + newName;
//            result.setData(url);
        }catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }
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
    @PostMapping("/delete_patent")
    public Result delete_patent(@RequestBody Patent patent){
        Result result=new Result();
        result.setMsg(patentMapper.deletePatentByStu(patent.getPatent_no())+"条删除");
        return result;
    }
    @PostMapping("/pass_patent")
    public Result pass_patent(@RequestBody Patent patent){
        patentMapper.pass_patent(patent.getPatent_no());
        Result result=new Result();
        result.setMsg("通过成功");
        return result;
    }
    @PostMapping("/refuse_patent")
    public Result refuse_patent(@RequestBody Patent patent){
        patentMapper.refuse_patent(patent.getPatent_no());
        Result result=new Result();
        result.setMsg("驳回成功");
        return result;
    }

    //论文相关接口
    @Autowired
    PaperMapper paperMapper;

    //找到所有的获奖信息
    @PostMapping("/find_all_paper_info_new")
    public List<Paper> find_all_paper_info(){
        List<Paper> paperList=new ArrayList<>();
        List<Paper> new_paperlist=new ArrayList<>();
        paperList=paperMapper.findAllStuPaper();
        for(int i=0;i<paperList.size();i++){
            Paper paper=new Paper();
            if(paperList.get(i).getPaper_status().equals("0")&&paperList.get(i)!=null){
                paper=paperList.get(i);
                new_paperlist.add(paper);
            }

        }
        return new_paperlist;
    }
    @PostMapping("/find_all_paper_info_old")
    public List<Paper> find_all_paper_info_old(){
        List<Paper> paperList=new ArrayList<>();
        List<Paper> new_paperlist=new ArrayList<>();
        paperList=paperMapper.findAllStuPaper();
        for(int i=0;i<paperList.size();i++){
            Paper paper=new Paper();
            if(!paperList.get(i).getPaper_status().equals("0")&&paperList.get(i)!=null){
                paper=paperList.get(i);
                new_paperlist.add(paper);
            }

        }
        return new_paperlist;
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
//这里是防止重复上传
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
            result.setMsg("文件上传成功");
            result.setData(newName);
//            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + format + newName;
//            result.setData(url);
        }catch (IOException e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }
    //老师审核材料通过
    @PostMapping("paper_verification")
    @ResponseBody
    public Result paperVerification(@RequestBody Paper paper){
        Result result = new Result();
        List<Paper> paperList = paperMapper.findAllStuPaper();
        for(Paper p:paperList){

        }
        return result;
    }

    //判断是否有正在审核的信息
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

    @PostMapping("/delete_paper")
    public Result delete_paper(@RequestBody Paper paper){
        Result result=new Result();
        result.setMsg(paperMapper.deletePaperByStu(paper.getPaper_no())+"条删除");


        return result;
    }
    @PostMapping("/pass_paper")
    public Result pass_paper(@RequestBody Paper paper){
        paperMapper.pass_paper(paper.getPaper_no());
        Result result=new Result();
        result.setMsg("通过成功");
        return result;
    }
    @PostMapping("/refuse_paper")
    public Result refuse_paper(@RequestBody Paper paper){
        paperMapper.refuse_paper(paper.getPaper_no());
        Result result=new Result();
        result.setMsg("驳回成功");
        return result;
    }



}
