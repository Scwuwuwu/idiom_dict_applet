package com.sc.idiom_dict_applet.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("idiom_dict") // 确保这里与数据库表名一致
public class Idiom {
    private Long id;
    private String name;
    private String spell;
    private String derivation;
    private String content;
    private String samples;
}
