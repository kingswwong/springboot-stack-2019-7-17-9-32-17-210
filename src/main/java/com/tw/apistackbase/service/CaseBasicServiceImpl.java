package com.tw.apistackbase.service;

import com.tw.apistackbase.base.BaseServiceImpl;
import com.tw.apistackbase.entity.CaseBasic;
import com.tw.apistackbase.repository.CaseBasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseBasicServiceImpl extends BaseServiceImpl<CaseBasic,Long> implements CaseBasicService {

    @Autowired
    CaseBasicRepository caseBasicRepository;

    public CaseBasicServiceImpl(CaseBasicRepository caseBasicRepository) {
        super(caseBasicRepository);
    }

    @Override
    public List<CaseBasic> findAllByName(String name) {
        return caseBasicRepository.findAllByNameEquals(name);
    }
}
