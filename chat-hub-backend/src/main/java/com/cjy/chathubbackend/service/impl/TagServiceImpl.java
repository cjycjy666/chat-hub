package com.cjy.chathubbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjy.chathubbackend.model.domain.Tag;
import com.cjy.chathubbackend.service.TagService;
import com.cjy.chathubbackend.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author chenjiangyu
* @description 针对表【tag】的数据库操作Service实现
* @createDate 2024-04-16 10:24:36
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




