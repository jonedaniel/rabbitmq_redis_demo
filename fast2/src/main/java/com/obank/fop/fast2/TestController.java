package com.obank.fop.fast2;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class TestController {

    @RequestMapping(method = RequestMethod.GET,value="/post")
    @ResponseBody
    public Object index(String index, HttpServletResponse response) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("success", "1");
        map.put("dsds",2);
        map.put("sadasd",5);
        System.out.println(index+"("+JSON.toJSONString(map)+")");
        return index+"("+JSON.toJSONString(map)+")";
    }
}
