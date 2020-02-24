package com.venink.slec.controller;

import com.venink.slec.base.utils.ReturnUtils;
import com.venink.slec.base.utils.page.PageUtil;
import com.venink.slec.entity.Group;
import com.venink.slec.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping("/groupManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String newsManage(Group group, @PathVariable Integer pageCurrent, @PathVariable Integer pageSize, @PathVariable Integer pageCount, Model model){

        //查询数据的总记录数：不分页
        int rows = groupService.count(group);
        //处理分页逻辑
        group.pageHandle(pageCurrent,pageSize,pageCount,rows);
        //设置完limit开s始值和结束值的订单对象调用分页查询
        List<Group> groups = groupService.findByCondition(group);

        //封装数据
        model.addAttribute("groups", groups);
        //将分页数据拼接成页面需要的数据格式
        String pageHTML = PageUtil.getPageContent("groupManage_{pageCurrent}_{pageSize}_{pageCount}", group.getPageCurrent(), group.getPageSize(), group.getPageCount());
        //封装分页索引
        model.addAttribute("pageHTML", pageHTML);
        return "group/groupManage";
    }

    //跳转添加权限组页面
    @RequestMapping(value = "/addGroupHandle")
    private String addGroupHandle() {
        return "group/addGroupHandle";
    }

    //添加权限组
    @ResponseBody
    @RequestMapping(value = "/addGroup",method = RequestMethod.POST)
    private ReturnUtils addGroup(Group group) {
        String groupName = group.getGroupName();
        if(groupName == null||"".equals(groupName)){
            return new ReturnUtils(1001,"权限组名称不能为空!");
        }
        if(groupService.selectUnique(groupName) != null){
            return new ReturnUtils(1001,"该权限组已存在!");
        }
        group.setCreateTime(new Date(System.currentTimeMillis()));
        int i = groupService.insertSelective(group);
        if(i == 0){
            return new ReturnUtils(1001,"添加权限组失败!");
        }
        return new ReturnUtils(1000,"添加权限成功!");
    }

    //跳转更新权限组页面
    @RequestMapping(value = "/updateGroupHandle")
    private String updateGroupHandle(@RequestParam("groupId")Integer groupId, Model model) {
        Group group = groupService.selectByPrimaryKey(groupId);
        model.addAttribute("group",group);
        return "group/updateGroupHandle";
    }

    //更新权限组
    @ResponseBody
    @RequestMapping(value = "/updateGroup",method = RequestMethod.POST)
    private ReturnUtils updateGroup(Group group) {
        String groupName = group.getGroupName();
        if(groupName == null||"".equals(groupName)){
            return new ReturnUtils(1001,"权限组名称不能为空!");
        }
        if(groupService.selectUnique(groupName) != null){
            return new ReturnUtils(1001,"该权限组已存在!");
        }
        group.setUpdateTime(new Date(System.currentTimeMillis()));
        int i = groupService.updateByPrimaryKeySelective(group);
        if(i == 0){
            return new ReturnUtils(1001,"更新权限组失败!");
        }
        return new ReturnUtils(1000,"更新权限成功!");
    }

    @ResponseBody
    @RequestMapping(value = "/updateGroup",method = RequestMethod.GET)
    private ReturnUtils updateGroup() {
        List<Group> groups = groupService.queryAllData();
        return new ReturnUtils(1000,"",groups);
    }
}
