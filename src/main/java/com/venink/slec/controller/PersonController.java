package com.venink.slec.controller;

import com.venink.slec.base.utils.page.PageUtil;
import com.venink.slec.entity.Person;
import com.venink.slec.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/personManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String newsManage(Person person, @PathVariable Integer pageCurrent, @PathVariable Integer pageSize, @PathVariable Integer pageCount, Model model){

        //查询数据的总记录数：不分页
        int rows = personService.count(person);
        //处理分页逻辑
        person.pageHandle(pageCurrent,pageSize,pageCount,rows);
        //设置完limit开s始值和结束值的订单对象调用分页查询
        List<Person> persons = personService.findByCondition(person);

        //封装数据
        model.addAttribute("persons", persons);
        //将分页数据拼接成页面需要的数据格式
        String pageHTML = PageUtil.getPageContent("personManage_{pageCurrent}_{pageSize}_{pageCount}", person.getPageCurrent(), person.getPageSize(), person.getPageCount());
        //封装分页索引
        model.addAttribute("pageHTML", pageHTML);
        return "person/personManage";
    }
}
