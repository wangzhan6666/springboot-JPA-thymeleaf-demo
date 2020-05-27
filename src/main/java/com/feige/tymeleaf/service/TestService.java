package com.feige.tymeleaf.service;

import com.feige.tymeleaf.common.Pager;
import com.feige.tymeleaf.common.Result;
import com.feige.tymeleaf.entity.Test;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface TestService {

    public Pager<Test> findAll(Map<String,String> map,int size) throws Exception;

    public void save(Map<String,String> map) throws Exception;

    public void del(int id) throws Exception;
}
