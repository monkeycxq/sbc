package com.liugh.controller.manager;


import com.liugh.annotation.AccessLimit;
import com.liugh.annotation.Log;
import com.liugh.annotation.Pass;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  后台首页
 * @author cxq
 * @since 2020-09-01
 */
@Controller
@Api(description="后台首页")
@RequestMapping("/manager")
public class IndexController {


    @GetMapping("/index")
    @Log(action="index",modelName= "index",description="后台首页路由")
    @Pass
    //5秒产生一个令牌,放入容量为0.3的令牌桶
    @AccessLimit(perSecond=0.3,timeOut = 5000)
    public String index(){
        return "manager/index";
    }

}
