package com.tw.apistackbase.controller;

import com.tw.apistackbase.base.BaseController;
import com.tw.apistackbase.entity.CaseBasic;
import com.tw.apistackbase.service.CaseBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class CaseBasicController extends BaseController<CaseBasic, Long> {

    @Autowired
    private CaseBasicService caseBasicService;

    public CaseBasicController(CaseBasicService caseBasicService) {
        super(caseBasicService);
    }

    @GetMapping
    public List<CaseBasic> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC,"occurrenceTime");
        return caseBasicService.findAll(sort);
    }

    @GetMapping(params = {"name"})
    public List<CaseBasic> findAllByName(@RequestParam String name){
        return caseBasicService.findAllByName(name);
    }
}
