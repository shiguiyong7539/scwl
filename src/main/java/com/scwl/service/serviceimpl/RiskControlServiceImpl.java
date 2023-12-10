package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.RectifyMatterMapper;
import com.scwl.mapper.RectifyProjectMapper;
import com.scwl.mapper.RiskControlMapper;
import com.scwl.mapper.SupervisionRectifyMapper;
import com.scwl.pojo.*;
import com.scwl.service.LogService;
import com.scwl.service.RiskControlService;
import com.scwl.vo.RectifyProjectVo;
import com.scwl.vo.SupervisionRectifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RiskControlServiceImpl implements RiskControlService {

    @Autowired
    private RiskControlMapper riskControlMapper;

    @Autowired
    private SupervisionRectifyMapper supervisionRectifyMapper;

    @Autowired
    private RectifyProjectMapper rectifyProjectMapper;

    @Autowired
    private RectifyMatterMapper rectifyMatterMapper;

    @Autowired
    private LogService logService;
    @Override
    public ResBean getAllRisk(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        RiskControlExample example = new RiskControlExample();
        example.setOrderByClause("add_time desc");
        List<RiskControl> contracts = riskControlMapper.selectByExample(example);
        PageInfo<RiskControl> pageInfo = new PageInfo<>(contracts);
        return ResBean.success("success",pageInfo);
    }

    @Override
    public ResBean addRisk(RiskControl riskControl) {
        try{
            riskControlMapper.insert(riskControl);
            logService.addLog("INSERT","risk_control",riskControl.getId(),"新增id为"+riskControl.getId()+"的涉诉信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }

    @Override
    public ResBean getAllRectify(int pageNum, int pageSize, SupervisionRectify supervisionRectify) {
        PageHelper.startPage(pageNum,pageSize);
        SupervisionRectifyExample example = new SupervisionRectifyExample();
     //   example.setOrderByClause("add_time desc");
        SupervisionRectifyExample.Criteria criteria = example.createCriteria();
        if(""!=supervisionRectify.getHeadLine()&&null!=supervisionRectify.getHeadLine()){
            criteria.andHeadLineLike("%"+supervisionRectify.getHeadLine()+"%");
        }
        if(""!=supervisionRectify.getRectifyPerson()&&null!=supervisionRectify.getRectifyPerson()){
            criteria.andRectifyPersonLike("%"+supervisionRectify.getRectifyPerson()+"%");
        }
        if(""!=supervisionRectify.getStatus()&&null!=supervisionRectify.getStatus()){
            criteria.andStatusEqualTo(supervisionRectify.getStatus());
        }
        if(""!=supervisionRectify.getDepartment()&&null!=supervisionRectify.getDepartment()){
            criteria.andDepartmentEqualTo(supervisionRectify.getDepartment());
        }
        List<SupervisionRectify> supervisionRectifies = supervisionRectifyMapper.selectByExample(example);
        PageInfo<SupervisionRectify> pageInfo = new PageInfo<>(supervisionRectifies);
        return ResBean.success("success",pageInfo);
    }

    @Override
    public ResBean addRectify(SupervisionRectify supervisionRectify) {
        try{
            supervisionRectify.setAddTime(new Date());
            supervisionRectifyMapper.insert(supervisionRectify);
            logService.addLog("INSERT","supervision_rectify",supervisionRectify.getId(),"新增id为"+supervisionRectify.getId()+"的监督整改信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }

    @Override
    public ResBean updateRectify(SupervisionRectify supervisionRectify) {
        try{
            SupervisionRectify rectify = supervisionRectifyMapper.selectByPrimaryKey(supervisionRectify.getId());
            if(supervisionRectify.getSupervisionWay().equals("1")){
                rectify.setExistingProblem(supervisionRectify.getExistingProblem());
            }else if(supervisionRectify.getSupervisionWay().equals("2")){
                rectify.setBusinessTips(supervisionRectify.getBusinessTips());
            }else if(supervisionRectify.getSupervisionWay().equals("3")){
                rectify.setRectifyReply(supervisionRectify.getRectifyReply());
            }else if(supervisionRectify.getSupervisionWay().equals("4")){
                rectify.setRemark(supervisionRectify.getRemark());
            }else {
                rectify.setStatus(supervisionRectify.getStatus());
            }
            supervisionRectifyMapper.updateByPrimaryKey(rectify);
            logService.addLog("UPDATE","supervision_rectify",supervisionRectify.getId(),"更新id为"+supervisionRectify.getId()+"的监督整改信息");
            return  ResBean.success("更新成功");
        }catch (Exception e){
            return  ResBean.error("更新失败");
        }
    }

    @Override
    public ResBean getRectifyDetail(String id) {
        SupervisionRectify supervisionRectify = supervisionRectifyMapper.selectByPrimaryKey(Integer.parseInt(id));
        SupervisionRectifyVo supervisionRectifyVo = getSuperVo(supervisionRectify);
        String titleId = supervisionRectifyVo.getTitleIds();
        String[] titleIds = titleId.split(",");
        String[] matterids = supervisionRectifyVo.getMatterIds().split(",");
        int[] ids = Arrays.stream(matterids).mapToInt(Integer::parseInt).toArray();
        List<RectifyMatter> matters = rectifyMatterMapper.getByIds(ids);
        List<RectifyProjectVo> projects = new ArrayList<>();
        for (String tid : titleIds) {
            RectifyProjectVo projectVo = getRectifyVo(tid, matters);
            projects.add(projectVo);
        }
        supervisionRectifyVo.setRectifyProjectVos(projects);
        return ResBean.success("查询成功",supervisionRectifyVo);
    }

    @Override
    public ResBean getProjectList() {
        List<RectifyProject> rectifyProjects = rectifyProjectMapper.selectByExample(new RectifyProjectExample());
        return ResBean.success("ok",rectifyProjects);
    }

    @Override
    public ResBean getProjectListAndMatters() {
        ArrayList<RectifyProjectVo> list = new ArrayList<>();
        List<RectifyProject> rectifyProjects = rectifyProjectMapper.selectByExample(new RectifyProjectExample());
        for (RectifyProject rectifyProject : rectifyProjects) {
            RectifyProjectVo projectVo = new RectifyProjectVo();
            List<RectifyMatter> matters = rectifyMatterMapper.getByTitleId(rectifyProject.getId());
            projectVo.setId(rectifyProject.getId());
            projectVo.setTitle(rectifyProject.getTitle());
            projectVo.setMatters(matters);
            list.add(projectVo);
        }
        return ResBean.success("ok",list);
    }

    @Override
    public ResBean getMatterList(String id) {
        RectifyMatterExample example = new RectifyMatterExample();
        RectifyMatterExample.Criteria criteria = example.createCriteria();
        criteria.andTitleIdEqualTo(Integer.parseInt(id));
        example.setOrderByClause("order_num ASC");
        List<RectifyMatter> matters = rectifyMatterMapper.selectByExample(example);
        return ResBean.success("ok",matters);
    }

    @Override
    public ResBean addProject(RectifyProject project) {
        try{
            rectifyProjectMapper.insert(project);
            logService.addLog("INSERT","rectify_project",project.getId(),"新增id为"+project.getId()+"的监督项目信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }

    @Override
    public ResBean addMatter(RectifyMatter matter) {
        try{
            RectifyMatterExample example = new RectifyMatterExample();
            example.createCriteria().andTitleIdEqualTo(matter.getTitleId());
            example.setOrderByClause("order_num ASC");
            List<RectifyMatter> matters = rectifyMatterMapper.selectByExample(example);
            if(matters.size()>0){
                Integer orderNum = matters.get(matters.size() - 1).getOrderNum();
                matter.setOrderNum(orderNum+1);
            }else {
                matter.setOrderNum(1);
            }
            rectifyMatterMapper.insert(matter);
            logService.addLog("INSERT","rectify_matter",matter.getId(),"新增id为"+matter.getId()+"的监督项目信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }


    @Override
    public ResBean getRiskByCenter() {
        ArrayList<Map> maps = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        map.put("name","涉诉情况");
        map2.put("name","内部监督情况");
        //涉诉总件数
        RiskControl riskControl = riskControlMapper.getTotal();
        map.put("num",riskControl.getNum());
        //当年度涉诉总数
        int totalYear = riskControlMapper.getTotalYear();
        riskControl.setYearNum(totalYear);
        map.put("yearNum",totalYear);
        //监督整改总件数
        int total = supervisionRectifyMapper.getTotal();
        map2.put("num",total);
        //当年度监督整改总件数
        int totalYear1 = supervisionRectifyMapper.getTotalYear();
        map2.put("yearNum",totalYear1);
        maps.add(map);
        maps.add(map2);
        return  ResBean.success("success",maps);
    }


    public SupervisionRectifyVo getSuperVo(SupervisionRectify rectify){
        SupervisionRectifyVo superVo = new SupervisionRectifyVo();
        superVo.setId(rectify.getId());
        superVo.setHeadLine(rectify.getHeadLine());
        superVo.setRectifyPerson(rectify.getRectifyPerson());
        superVo.setDepartment(rectify.getDepartment());
        superVo.setTitleIds(rectify.getTitleIds());
        superVo.setStatus(rectify.getStatus());
        superVo.setSupervisionScope(rectify.getSupervisionScope());
        superVo.setSupervisionWay(rectify.getSupervisionWay());
        superVo.setExistingProblem(rectify.getExistingProblem());
        superVo.setBusinessTips(rectify.getBusinessTips());
        superVo.setRectifyReply(rectify.getRectifyReply());
        superVo.setStartTime(rectify.getStartTime());
        superVo.setDeadline(rectify.getDeadline());
        superVo.setRemark(rectify.getRemark());
        superVo.setMatterIds(rectify.getMatterIds());
        superVo.setAddTime(rectify.getAddTime());
        return superVo;
    }



    public RectifyProjectVo getRectifyVo(String tid,List<RectifyMatter> list){
        int id = Integer.parseInt(tid);
        RectifyProject project = rectifyProjectMapper.selectByPrimaryKey(id);
        RectifyProjectVo projectVo = new RectifyProjectVo();
        ArrayList<RectifyMatter> matters = new ArrayList<>();
        for (RectifyMatter matter : list) {
            if(id==matter.getTitleId()){
                matters.add(matter);
            }
        }
        projectVo.setId(id);
        projectVo.setTitle(project.getTitle());
        projectVo.setMatters(matters);
        return projectVo;
    }

}
