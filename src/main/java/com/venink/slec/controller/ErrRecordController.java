package com.venink.slec.controller;

import com.venink.slec.base.utils.page.PageUtil;
import com.venink.slec.entity.ErrRecord;
import com.venink.slec.service.ErrRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/errRecord")
public class ErrRecordController {

    @Autowired
    private ErrRecordService errRecordService;

    @RequestMapping("/errRecordManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String newsManage(ErrRecord errRecord, @PathVariable Integer pageCurrent, @PathVariable Integer pageSize, @PathVariable Integer pageCount, Model model){

        //查询数据的总记录数：不分页
        int rows = errRecordService.count(errRecord);
        //处理分页逻辑
        errRecord.pageHandle(pageCurrent,pageSize,pageCount,rows);
        //设置完limit开s始值和结束值的订单对象调用分页查询
        List<ErrRecord> errRecords = errRecordService.findByCondition(errRecord);

        //封装数据
        model.addAttribute("errRecords", errRecords);
        //将分页数据拼接成页面需要的数据格式
        String pageHTML = PageUtil.getPageContent("errRecordManage_{pageCurrent}_{pageSize}_{pageCount}", errRecord.getPageCurrent(), errRecord.getPageSize(), errRecord.getPageCount());
        //封装分页索引
        model.addAttribute("pageHTML", pageHTML);
        return "errRecord/errRecordManage";
    }
}
