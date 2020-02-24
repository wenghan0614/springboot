package com.venink.slec.controller;


import com.venink.slec.entity.Admin;
import com.venink.slec.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    /*根路径重定向至登陆页面*/
    @GetMapping("/")
    public String login(){
        return "redirect:/admin/login";
    }


    /**
     * 登录跳转
     *
     * @param model
     * @return
     */
    @GetMapping("/admin/login")
    public String loginGet(Model model) {
        return "login";
    }

    /**
     * 登录
     */
    @PostMapping("/admin/login")
    public String loginPost(Admin admin, Model model, HttpSession httpSession) {
        Admin adminRes = adminService.findAdmin(admin);
        if (adminRes != null) {
            httpSession.setAttribute("admin", adminRes);
            return "redirect:/group/groupManage_0_0_0";
        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }
    }

    /**
     * 注册
     *
     * @param model
     * @return
     */
    @GetMapping("/admin/register")
    public String register(Model model) {
        System.out.println("get");
        return "register";
    }

    //提交注册表单
    @PostMapping("/admin/register")
    public String registers(Admin admin, Model model, HttpSession httpSession) {
        //判断后台是否已经有这个用户了
        Admin hasExisted = adminService.hasExisted(admin);
        if (hasExisted != null) {
            model.addAttribute("error", "用户名已存在！");
            return "register";
        }else{
            adminService.addAdmin(admin);
            model.addAttribute("success","注册成功");


            return "register";
        }
    }

    /**
     * 仪表板页面
     *
     * @param model
     * @return
     */
    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @GetMapping("/admin/editPassword")
    public String editPassword(Model model) {
        return "editPassword";
    }

    @PostMapping("/admin/editPassword")
    public String modifyPassword(Admin admin, Model model, HttpSession httpSession) {
        System.out.println(admin);
        Admin adminRes = adminService.findAdmin(admin);

        if (adminRes != null) {
            adminRes.setPassword(admin.getNewPassword());
            adminRes.setUpdateDate(new Date());
            adminService.modifyAdmin(adminRes);
            return "login";
        } else {
            model.addAttribute("error", "查无此账号！");
            return "editPassword";
        }
    }
}
