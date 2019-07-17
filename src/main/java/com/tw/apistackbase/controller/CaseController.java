package com.tw.apistackbase.controller;

import com.tw.apistackbase.base.BaseController;
import com.tw.apistackbase.base.BaseService;
import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/case")
public class CaseController extends BaseController<Case, Long> {

    public CaseController(@Autowired CaseService caseService) {
        super(caseService);
    }
}
