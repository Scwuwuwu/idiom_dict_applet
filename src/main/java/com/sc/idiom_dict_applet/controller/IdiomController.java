package com.sc.idiom_dict_applet.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.sc.idiom_dict_applet.entity.Idiom;
import com.sc.idiom_dict_applet.service.IdiomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*") // 允许所有跨域请求
@RestController // 返回数据会转换成json格式
@RequestMapping("/search")
public class IdiomController {
    @Autowired
    private IdiomService idiomService;
    @GetMapping("/{ID}")
    public Idiom getById(@PathVariable String ID){
        Idiom idiom = idiomService.getById(ID);
        return idiom;
    }

    /**
     * 接收微信小程序发送的查询请求
     * @param request
     * @return
     */
    @PostMapping
    public Map<String, Object> querySingleIdiom(@RequestBody Map<String, String> request) {
        // 1. 创建响应对象
        Map<String, Object> response = new HashMap<>(2);
        // 2. 获取并验证输入
        String idiomName = request.get("idiom"); // 获取k为idiom的value(成语名)
        // 如果value为空,成语为空
        if (StringUtils.isBlank(idiomName)) {
            response.put("error_code", 1);
            response.put("tip", "请输入有效的成语");
            return response;
        }
        // 3. 精确查询单个成语
        // 根据name查
        Idiom idiom = idiomService.lambdaQuery()
                .eq(Idiom::getName, idiomName.trim())   // 去除字符串两端的空白字符
                .one();
        // 4. 构造响应
        if (idiom != null) {
            // 成语在mysql中能查到了
            // 设置响应数据
            response.put("error_code", 0);  // error_code:0 成功
            response.put("result", idiom);  // result:idiom
        } else {
            // 设置响应数据
            response.put("error_code", 1);  // error_code:1 成功
            response.put("tip", "未找到成语: " + idiomName); // tip:"为找到成语"
        }
        return response;    // 返回响应数据
    }
}
