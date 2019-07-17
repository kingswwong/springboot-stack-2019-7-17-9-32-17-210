package com.tw.apistackbase.controller;

import com.tw.apistackbase.base.BaseController;
import com.tw.apistackbase.entity.Inquisitor;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.service.InquisitorService;
import com.tw.apistackbase.service.ProcuratorateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/inquisitor")
public class InquisitorController extends BaseController<Inquisitor, Long> {

    public InquisitorController(@Autowired InquisitorService inquisitorService) {
        super(inquisitorService);
    }
}
