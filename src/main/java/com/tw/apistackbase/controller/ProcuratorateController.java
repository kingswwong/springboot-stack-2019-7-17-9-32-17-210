package com.tw.apistackbase.controller;

import com.tw.apistackbase.base.BaseController;
import com.tw.apistackbase.entity.CaseDetail;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.service.CaseDetailService;
import com.tw.apistackbase.service.ProcuratorateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/procurator")
public class ProcuratorateController extends BaseController<Procuratorate, Long> {

    public ProcuratorateController(@Autowired ProcuratorateService procuratorateService) {
        super(procuratorateService);
    }
}
