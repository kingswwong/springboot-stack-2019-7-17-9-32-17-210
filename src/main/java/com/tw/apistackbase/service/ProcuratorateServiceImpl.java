package com.tw.apistackbase.service;

import com.tw.apistackbase.base.BaseRepository;
import com.tw.apistackbase.base.BaseServiceImpl;
import com.tw.apistackbase.entity.CaseDetail;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.repository.CaseDetailRepository;
import com.tw.apistackbase.repository.ProcuratorateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcuratorateServiceImpl extends BaseServiceImpl<Procuratorate, Long> implements ProcuratorateService {

    public ProcuratorateServiceImpl(@Autowired ProcuratorateRepository procuratorateRepository) {
        super(procuratorateRepository);
    }
}
