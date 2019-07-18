package com.tw.apistackbase.repository;


import com.tw.apistackbase.entity.CaseDetail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CaseDetailRepositoryTest {

    @Autowired
    private CaseDetailRepository caseDetailRepository;

    @Test
    void should_save_case_detail_and_find() {
        CaseDetail caseDetail = new CaseDetail();
        caseDetail.setObjectiveDescription("objectiveDes");
        caseDetail.setSubjectiveDescription("subjectDes");
        caseDetailRepository.saveAndFlush(caseDetail);

        CaseDetail correspondCaseDetail = caseDetailRepository.getOne(caseDetail.getId());

        assertEquals(correspondCaseDetail.getObjectiveDescription(),"objectiveDes");
        assertEquals(correspondCaseDetail.getSubjectiveDescription(),"subjectDes");

    }

    @Test
    void should_delete_case_detail() {
        CaseDetail caseDetail = new CaseDetail();
        caseDetail.setObjectiveDescription("objectiveDes");
        caseDetail.setSubjectiveDescription("subjectDes");
        caseDetailRepository.saveAndFlush(caseDetail);
        caseDetailRepository.delete(caseDetail);

        assertSame(caseDetailRepository.findAll().size(),0);
    }

    @Test
    void should_update_case_datail(){
        CaseDetail caseDetail = new CaseDetail();
        caseDetail.setObjectiveDescription("objectiveDes");
        caseDetail.setSubjectiveDescription("subjectDes");
        caseDetailRepository.saveAndFlush(caseDetail);
        caseDetail.setSubjectiveDescription("s1");
        caseDetailRepository.saveAndFlush(caseDetail);

        assertEquals(caseDetail.getSubjectiveDescription(),"s1");

    }
}
