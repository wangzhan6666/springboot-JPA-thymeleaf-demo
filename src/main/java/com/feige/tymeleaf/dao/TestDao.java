package com.feige.tymeleaf.dao;

import com.feige.tymeleaf.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestDao extends JpaRepository<Test,Integer> {

    @Query(value = "SELECT * FROM demo where IF(:keywords is null,0 = 0,name like concat('%',:keywords,'%')) " +
            "order by modify_time desc",nativeQuery = true)
    public List<Test> findBykeywords(String keywords);

}
