package com.may.yygh.cmn.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.may.yygh.cmn.service.DictService;
import com.may.yygh.common.result.Result;
import com.may.yygh.common.utils.MD5;
import com.may.yygh.model.cmn.Dict;
import com.may.yygh.model.hosp.HospitalSet;
import com.may.yygh.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/admin/cmn/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    @GetMapping("findChildData/{id}")
    @Cacheable(value = "dict",keyGenerator = "keyGenerator")
    public  Result findChildData(@PathVariable Long id ){
         List<Dict> list =  dictService.findChildData(id);
        return  Result.ok(list);
    };

    @GetMapping("exportData")
    public void exportData(HttpServletResponse httpServletResponse){
        dictService.exportData(httpServletResponse);
    }

    @PostMapping("importData")
    @CacheEvict(value = "dict", allEntries=true)
    public void exportData(MultipartFile file){
        dictService.importData(file);
        Result.ok();
    }
}
