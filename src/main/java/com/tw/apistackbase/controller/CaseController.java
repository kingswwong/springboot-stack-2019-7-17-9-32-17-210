package com.tw.apistackbase.controller;

import com.tw.apistackbase.base.BaseController;
import com.tw.apistackbase.base.BaseService;
import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.SortedMap;

@RestController
@RequestMapping("/cases")
public class CaseController extends BaseController<Case, Long> {

    @Autowired
    private CaseService caseService;

    public CaseController(@Autowired CaseService caseService) {
        super(caseService);
    }

    @GetMapping
    public List<Case> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC,"occurrenceTime");
        return caseService.findAll(sort);
    }
}
