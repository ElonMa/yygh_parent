package com.may.yygh.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.may.yygh.model.cmn.Dict;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DictService extends IService<Dict> {
    List<Dict> findChildData(Long id);

    public void exportData(HttpServletResponse httpServletResponse);

    public void importData(MultipartFile file);
}
