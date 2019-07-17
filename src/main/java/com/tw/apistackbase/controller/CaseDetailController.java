package com.tw.apistackbase.controller;

import com.tw.apistackbase.base.BaseController;
import com.tw.apistackbase.entity.CaseDetail;
import com.tw.apistackbase.service.CaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/caseDetail")
public class CaseDetailController extends BaseController<CaseDetail, Long> {

    public CaseDetailController(@Autowired CaseDetailService caseDetailService) {
        super(caseDetailService);
    }
}
