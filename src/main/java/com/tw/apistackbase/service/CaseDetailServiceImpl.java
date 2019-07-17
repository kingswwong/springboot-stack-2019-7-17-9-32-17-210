package com.tw.apistackbase.service;

import com.tw.apistackbase.base.BaseRepository;
import com.tw.apistackbase.base.BaseServiceImpl;
import com.tw.apistackbase.entity.CaseDetail;
import com.tw.apistackbase.repository.CaseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseDetailServiceImpl extends BaseServiceImpl<CaseDetail, Long> implements CaseDetailService {

    public CaseDetailServiceImpl(@Autowired CaseDetailRepository caseDetailRepository) {
        super(caseDetailRepository);
    }
}
