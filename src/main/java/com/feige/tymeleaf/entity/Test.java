package com.feige.tymeleaf.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "demo")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String name;  //课程名称

    @Lob
    @Basic(fetch=FetchType.LAZY)
    private String des;  //课程简介

    @Column(length = 1024)
    private String remark; //备注

    @Column(length = 50)
    private Date createTime;

    @Column(length = 50)
    private Date modifyTime;

}
