package com.tw.apistackbase.service;

import com.tw.apistackbase.base.BaseRepository;
import com.tw.apistackbase.base.BaseService;
import com.tw.apistackbase.base.BaseServiceImpl;
import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseServiceImpl extends BaseServiceImpl<Case,Long> implements CaseService {

    @Autowired CaseRepository caseRepository;

    public CaseServiceImpl(CaseRepository caseRepository) {
        super(caseRepository);
    }

    @Override
    public List<Case> findAllByName(String name) {
        return caseRepository.findAllByNameEquals(name);
    }
}
