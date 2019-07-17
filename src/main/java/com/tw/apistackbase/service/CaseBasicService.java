package com.tw.apistackbase.service;

import com.tw.apistackbase.base.BaseService;
import com.tw.apistackbase.entity.CaseBasic;

import java.util.List;


public interface CaseBasicService extends BaseService<CaseBasic, Long> {
    List<CaseBasic> findAllByName(String name);
}
