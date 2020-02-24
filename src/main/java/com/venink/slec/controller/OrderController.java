package com.venink.slec.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.venink.slec.base.utils.page.PageUtil;
import com.venink.slec.entity.Order;
import com.venink.slec.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 添加订单
     */
    @ResponseBody
    @RequestMapping(value = "/addorder", method = RequestMethod.POST)
    private Map<String, Object> addUser(@RequestBody Order order)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<>();
        System.out.println(order);
        modelMap.put("success", orderService.addOrder(order));
        return modelMap;
    }

    @RequestMapping("/orderManage_{pageCurrent}_{pageSize}_{pageCount}")
    public String newsManage(Order order, @PathVariable Integer pageCurrent, @PathVariable Integer pageSize, @PathVariable Integer pageCount, Model model){

        //空字符串设置为null
        if("".equals(order.getUserName())){
            order.setUserName(null);
        }
        //空字符串设置为null
        if("".equals(order.getPhoneNum())){
            order.setPhoneNum(null);
        }

        //查询数据的总记录数：不分页
        int rows = orderService.count(order);
        //处理分页逻辑
        order.pageHandle(pageCurrent,pageSize,pageCount,rows);
        //设置完limit开始值和结束值的订单对象调用分页查询
        List<Order> orders = orderService.findByCondition(order);

        //封装数据
        model.addAttribute("orders", orders);
        //将分页数据拼接成页面需要的数据格式
        String pageHTML = PageUtil.getPageContent("orderManage_{pageCurrent}_{pageSize}_{pageCount}", order.getPageCurrent(), order.getPageSize(), order.getPageCount());
        //封装分页索引
        model.addAttribute("pageHTML", pageHTML);
        return "order/orderManage";
    }

    @RequestMapping(value = "/orderDetail")
    private String orderDetail(Order order, Model model) {
        String orderId = order.getOrderId();
        List<Order> orders = orderService.findOrderByOrderId(orderId);
        model.addAttribute("orders", orders);
        return "order/orderDetail";
    }
    @RequestMapping(value = "/orderHandle")
    private String orderHandle(Order order, Model model) {
        System.out.println(order);
        String orderId = order.getOrderId();
        List<Order> orders = orderService.findOrderByOrderId(orderId);
        model.addAttribute("orders", orders);
        return "order/orderHandle";
    }

}
