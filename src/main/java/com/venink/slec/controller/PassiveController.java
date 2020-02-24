package com.venink.slec.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.convert.Convert;
import com.venink.slec.base.utils.Return.DevicParam;
import com.venink.slec.base.utils.Return.SyncCustomer;
import com.venink.slec.entity.*;
import com.venink.slec.service.*;
import com.venink.slec.utils.RedisUtil;
import org.slf4j.Logger;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/WebUser")
public class PassiveController {

    //Logback
    private static final Logger logger = LoggerFactory.getLogger(PassiveController.class);

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private AdminService adminService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private PersonService personService;
    @Autowired
    private ErrRecordService errRecordService;

    //功能测试
    @RequestMapping(value = "/checkBean",method = RequestMethod.GET)
    public String testBean(){
        Integer test = (Integer) redisUtil.get("test");
        logger.info("test:  "+test);

        Admin admin = new Admin();
        admin.setUserName("1037377970@qq.com");
        admin.setPassword("123456");
        admin.setState(0);
        admin = adminService.findAdmin(admin);
        logger.info(admin.toString());

        List<Order> orders = orderService.findOrderByOrderId("38");
        logger.info(orders.toString());

        List<User> users = userService.getUserByName("");
        logger.info(users.toString());

        return "end";
    }

    //测试设置连接服务器
    @RequestMapping(value = "/setConfig",method = RequestMethod.GET)
    public String test(){
        HashMap<String, Object> paramMap = new HashMap<>();
        //服务器地址
        paramMap.put("httpServiceUr", "http://192.168.28.239");
        //每次下载用户的最大数量：可缺省
        paramMap.put("pageCount", "");
        String result3 = HttpUtil.get("http://192.168.28.111:7733/setConfig",paramMap);
        //成功返回字符串：设置成功
        logger.info("result3: "+result3);
        return result3;
    }

    //测试设备心跳
    @RequestMapping(value = "/SyncHeart",method = RequestMethod.POST)
    public String SyncHeart(@RequestBody Map<String, String> map){

        logger.info("设备心跳："+JSON.toJSONString(map));
        //设备最后更新人员的时间
        String LastDT = map.get("LastDT");
        //上次更新时间段的时间
        String timeIntervalLastDT = map.get("timeIntervalLastDT");
        //上次更新请假时间
        String leaveTimeLastDT = map.get("leaveTimeLastDT");
        //设备序列号
        String deviceCode = map.get("deviceCode");
        //设备当前的软件版本名
        String versionName = map.get("versionName");
        //设备最后的心跳时间保存至redis
        redisUtil.set(deviceCode,System.currentTimeMillis());

        //根据设备序列号查询设备
        Device device = deviceService.selectDeviceByDeviceSn(deviceCode);
        Integer code = 200;
        String msg = "成功";
        Integer SyncState = 0;
        //如果设备不存在,返回202
        if(device == null || "".equals(device.getDeviceSn())){
            code = 202;
            msg = "设备未注册";
        }else{
            SyncState = device.getSyncState();
        }
        JSONObject result =new JSONObject();
        //200：操作成功；201：操作失败，没有查询到数据；202：缺失参数，设备未注册；500：服务器错误；
        result.put("resultCode", code);
        result.put("deviceCode", deviceCode);
        result.put("msg",msg);
        //设备同步状态；0：不需要操作；1：需要更新人员信息；2：需要更新设备参数；3：重启；4：初始化；
        result.put("SyncState", ""+SyncState);
        logger.info("设备心跳服务器返回值："+result.toJSONString());
        return result.toJSONString();
    }

    //测试设备参数下载
    @RequestMapping(value = "/DownParam",method = RequestMethod.POST)
    public String DownParam(@RequestBody Map<String, String> map){
        logger.info("设备参数设置： "+JSON.toJSONString(map));
        //设备序列号
        String deviceCode = map.get("deviceCode");

        Device device = deviceService.selectDeviceByDeviceSn(deviceCode);
        Integer code = 200;
        DevicParam devicParam = null;
        //如果设备不存在,返回202
        if(device == null || "".equals(device.getDeviceSn())){
            code = 202;
        }else{
            devicParam = new DevicParam(device);
        }
        JSONObject result =new JSONObject();
        result.put("resultCode", code);
        result.put("deviceCode", deviceCode);
        result.put("aaData", devicParam);
        logger.info("设备参数设置返回值："+result.toJSONString());
        return result.toJSONString();
    }

    //测试同步人员
    @RequestMapping(value = "/SyncCustomer",method = RequestMethod.POST)
    public String SyncCustomer(@RequestBody Map<String, String> map){
        logger.info("同步人员： "+JSON.toJSONString(map));
        //设备最后更新人员的时间
        String lastDT = map.get("LastDT");
        //设备序列号
        String deviceCode = map.get("deviceCode");
        //该次请求返回的人员数量的最大值
        String pageCount = map.get("PageCount");
        List<Person> personList = personService.queryAllData();
        List<SyncCustomer> syncCustomerList = new ArrayList<>();
        for (Person person1: personList) {
            if(person1.getCreateManId() ==1){
                SyncCustomer syncCustomer = new SyncCustomer(person1);
                syncCustomerList.add(syncCustomer);
            }
        }
        JSONObject result =new JSONObject();
        result.put("resultCode", 200);
        result.put("deviceCode", deviceCode);
        result.put("aaData", syncCustomerList);
        logger.info("同步人员返回值： "+result.toJSONString());
        return result.toJSONString();
    }

    //上传通行记录
    @RequestMapping(value = "/SyncInOutRecord",method = RequestMethod.POST)
    public String SyncInOutRecord(@RequestBody Map<String, String> map){
        logger.info("上传通行记录: "+JSON.toJSONString(map));
        //图片的Base64数据
        String InOutImg = map.get("InOutImg");
        String decodeStr = Base64.decodeStr(InOutImg);
        //识别类型；face：人脸比对；card：ic卡比对；qr：二维码比对；idCard：人证比对；
        String type = map.get("type");
        //只有type为idCard为身份证json数据，其他类型为人员id
        String personMessage = map.get("personMessage");
        //通行的时间
        String time = map.get("time");
        //设备序列号
        String deviceCode = map.get("deviceCode");
        //人员类型
        String personType = map.get("personType");
        //体温值
        String temperature = map.get("temperature");
        //是否带口罩：0：戴了口罩；1：未戴口罩；
        String maskState = map.get("maskState");

        logger.info("人员编号："+personMessage);

        JSONObject result =new JSONObject();
        result.put("resultCode", 200);
        result.put("deviceCode", deviceCode);
        logger.info("上传通行记录返回值： "+result.toJSONString());
        return result.toJSONString();
    }

    //上报同步人员异常
    @RequestMapping(value = "/UploadErr",method = RequestMethod.POST)
    public String UploadErr(@RequestBody Map<String, String> map){
        logger.info("上报同步人员异常:"+JSON.toJSONString(map));
        //身份证号
        String customerIDNO = map.get("CustomerIDNO");
        //用户姓名
        String CustomerName = map.get("CustomerName");
        //错误信息
        String ErrMsg = map.get("ErrMsg");
        //错误类型：1：personId无效;2：图片转换失败;3：图片提取特征码失败;
        String ErrType = map.get("Errtype");
        //识别序列号
        String deviceCode = map.get("deviceCode");
        ErrRecord errRecord = new ErrRecord();
        errRecord.setErrType(ErrType);
        errRecord.setDeviceSN(deviceCode);
        errRecord.setErrMsg(ErrMsg);
        errRecord.setPersonName(CustomerName);
        errRecord.setPersonId(Convert.toInt(customerIDNO));
        int i = errRecordService.insertSelective(errRecord);
        JSONObject result =new JSONObject();
        result.put("resultCode", 200);
        result.put("deviceCode", deviceCode);
        result.put("msg", "成功");
        logger.info("上报同步人员异常返回值:"+result.toJSONString());
        return result.toJSONString();
    }

}
