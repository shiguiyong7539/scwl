package com.scwl.controller;

import com.alibaba.fastjson.JSONPath;
import com.google.gson.Gson;
import com.scwl.pojo.ResBean;
import com.scwl.pojo.User;
import com.scwl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    UserService userService;

    /**
     * 登录
     * @return
     */
    @RequestMapping("/")
    public String loginHtml(){
        return "login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/loginAdmin")
    public String loginAdmin(){
      //  System.out.println(passwordEncoder.encode("123456"));
        return "login_admin";
    }
    /**
     * 角色
     * @return
     */
    @RequestMapping("/roleList")
    public String roleList(){
        //  System.out.println(passwordEncoder.encode("123456"));
        return "role";
    }

    /**
     * 权限
     * @return
     */
    @RequestMapping("/authority")
    public String authority(){
        //  System.out.println(passwordEncoder.encode("123456"));
        return "authority";
    }


    /**
     * 主页
     * @return
     */
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String indexHtml(){
        return "index";
    }

    /**
     * 个人信息页面
     * @return
     */
    @RequestMapping("/userInfo")
    public String userInfo(){
        return "userInfo";
    }


    /**
     * 人事信息页面
     * @return
     */
    @RequestMapping("/memberList")
    public String memberList(){
        return "memberList";
    }

    /**
     * 成本管理页面
     * @return
     */
    @RequestMapping("/costManage")
    public String costManage(){
        return "budget";
    }

    /**
     * 经营状况页面
     * @return
     */
    @RequestMapping("/mangeState")
    public String mangeState(){
        return "managestate";
    }

    /**
     * 资金状况页面
     * @return
     */
    @RequestMapping("/capitalList")
    public String capitalPosition(){
        return "capital";
    }

    /**
     * 任务管理页面
     * @return
     */
    @RequestMapping("/taskList")
    public String taskList(){
        return "tasklist";
    }


    /**
     * 合同管理页面
     * @return
     */
    @RequestMapping("/contract")
    public String contract(){
        return "contract";
    }


    /**
     * 涉诉管理页面
     * @return
     */
    @RequestMapping("/risk")
    public String risk(){
        return "risk";
    }

    /**
     * 监督整改管理页面
     * @return
     */
    @RequestMapping("/rectify")
    public String rectify(){
        return "rectify";
    }


    /**
     * 监督整改管理页面
     * @return
     */
    @RequestMapping("/rectifyShow")
    public String rectifyShow(){
        return "rectify_show";
    }


    /**
     * 平台展示页面
     * @return
     */
    @RequestMapping("/centerShow")
    public String centerShow(HttpServletRequest request){
//        String user_agent = request.getHeader("user_agent");
//        if(user_agent.indexOf("iphone")!=-1){
//
//        }
        return "center_show";
    }
    /**
     * 平台展示页面
     * @return
     */
    @RequestMapping("/centerShowPhone")
    public String centerShowPhone(HttpServletRequest request){
        return "center_show_sp";
    }

    /**
     * 用户一览
     * @return
     */
    @RequestMapping("/userList")
    public String userList(){
        return "userlist";
    }

    /**
     * 角色选择
     * @return
     */
    @RequestMapping("/roleChoose")
    public String roleChoose(){
        return "rolechoose";
    }

    /**
     * 角色选择
     * @return
     */
    @RequestMapping("/userRoleChoose")
    public String userRoleChoose(){
        return "userrolechoose";
    }

    //重定向
    @RequestMapping("/getShowData")
    public String getShowData(){
        return "urlredirect";
    }
    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(HttpServletRequest request,User user){
        return userService.login(user);
    }
    /**
     * 登录
     * @return
     */
    @RequestMapping("/oaLogin")
    public String oaLogin(HttpServletRequest request,String phone){
        ResBean resBean = userService.oaLogin(phone);
        HttpSession session = request.getSession();
        if(resBean.getCode()==200){
            Object obj = resBean.getObj();
            Gson gson = new Gson();
            String s = gson.toJson(obj);
            String token = JSONPath.read(s, "token").toString();
            session.setAttribute("code","200");
            session.setAttribute("token",token);
        }else {
            session.setAttribute("code","404");
            session.setAttribute("message",resBean.getMessage());
        }
        return "redirect:getShowData";
    }
    @RequestMapping("/getOaToken")
    @ResponseBody
    public ResBean getOaToken(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(null!=session.getAttribute("code")){
          String  code = request.getSession().getAttribute("code").toString();
            if(!code.isEmpty()&&code.equals("200")){
                return  ResBean.success(request.getSession().getAttribute("token").toString());
            }else {
                return  ResBean.error(request.getSession().getAttribute("message").toString());
            }
        }else {
            return  ResBean.error("您还未登录，暂时无法显示当前页面的敏感数据！");
        }



    }


    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(HttpServletRequest request){
        // 解析JWT令牌以获取声明
        return  ResBean.success("已退出");
    }

    /**
     * 验证是否登录
     * 没登录进行提示
     * @return
     */
    @RequestMapping("/isLogin")
    @ResponseBody
    public Object isLogin(HttpServletRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
           return  ResBean.success("已登录",(User) authentication.getPrincipal());
        }
        return ResBean.error("未登录");
    }



}