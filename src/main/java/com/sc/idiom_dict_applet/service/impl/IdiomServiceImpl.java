package com.sc.idiom_dict_applet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.idiom_dict_applet.entity.Idiom;
import com.sc.idiom_dict_applet.mapper.IdiomMapper;
import com.sc.idiom_dict_applet.service.IdiomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdiomServiceImpl extends ServiceImpl<IdiomMapper, Idiom>implements IdiomService {
}
