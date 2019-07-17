package com.tw.apistackbase.service;

import com.tw.apistackbase.base.BaseServiceImpl;
import com.tw.apistackbase.entity.Inquisitor;
import com.tw.apistackbase.repository.InquisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquisitorServiceImpl extends BaseServiceImpl<Inquisitor, Long> implements InquisitorService {

    public InquisitorServiceImpl(@Autowired InquisitorRepository inquisitorRepository) {
        super(inquisitorRepository);
    }
}
