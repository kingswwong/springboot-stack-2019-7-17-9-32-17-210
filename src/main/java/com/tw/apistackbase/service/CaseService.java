package com.tw.apistackbase.service;

import com.tw.apistackbase.base.BaseService;
import com.tw.apistackbase.entity.Case;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CaseService extends BaseService<Case, Long> {
    List<Case> findAllByName(String name);
}
