package com.feige.tymeleaf.serviceImpl;

import com.feige.tymeleaf.common.Pager;
import com.feige.tymeleaf.common.Result;
import com.feige.tymeleaf.dao.TestDao;
import com.feige.tymeleaf.entity.Test;
import com.feige.tymeleaf.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;


    @Override
    public Pager<Test> findAll(Map<String,String> map,int size) throws Exception{
        List<Test> list = testDao.findBykeywords(map.get("keywords"));
        Pager<Test> pager = new Pager<Test>(list,1,size);
        if(map.get("page") != null ) {
            pager = new Pager<Test>(list,Integer.parseInt(map.get("page")+""),size);
        }
        return pager;
    }

    @Override
    public void save(Map<String,String> map) throws Exception {

        Test test = new Test();
        if(map.get("id") != null && !map.get("id").equals("") ){
            test.setId(Integer.parseInt(map.get("id")));
            map.put("msg","修改");
        }
        map.put("msg","添加");
        test.setModifyTime(new Date());
        test.setName(map.get("name"));
        test.setRemark(map.get("remark"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        test.setCreateTime(sdf.parse(map.get("createTime")));
        test.setDes(map.get("des"));
        testDao.save(test);
    }

    @Override
    public void del(int id) throws Exception {
        testDao.deleteById(id);
    }
}
