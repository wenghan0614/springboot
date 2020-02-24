package com.venink.slec.controller;

import com.venink.slec.base.utils.page.PageUtil;
import com.venink.slec.entity.Operate;
import com.venink.slec.service.OperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/operate")
public class OperateController {

    @Autowired
    private OperateService operateService;

    @RequestMapping("/operateManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String newsManage(Operate operate, @PathVariable Integer pageCurrent, @PathVariable Integer pageSize, @PathVariable Integer pageCount, Model model){

        //查询数据的总记录数：不分页
        int rows = operateService.count(operate);
        //处理分页逻辑
        operate.pageHandle(pageCurrent,pageSize,pageCount,rows);
        //设置完limit开s始值和结束值的订单对象调用分页查询
        List<Operate> operates = operateService.findByCondition(operate);

        //封装数据
        model.addAttribute("operates", operates);
        //将分页数据拼接成页面需要的数据格式
        String pageHTML = PageUtil.getPageContent("operateManage_{pageCurrent}_{pageSize}_{pageCount}", operate.getPageCurrent(), operate.getPageSize(), operate.getPageCount());
        //封装分页索引
        model.addAttribute("pageHTML", pageHTML);
        return "operate/operateManage";
    }
}
