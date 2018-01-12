package com.obank.fop.fast2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Fast2ApplicationTests {

	@Test
	public void contextLoads() {
	    String    str = "{'creditscore':'60.0', 'abilityscore':'70.0', 'qualificationscore':'70.0', 'totalscore':'80.0', 'entId':'3'}";
       JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject.get("creditscore"));
    }

}
