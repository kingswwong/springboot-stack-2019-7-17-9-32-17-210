package com.tw.apistackbase.repository;


import com.tw.apistackbase.entity.CaseBasic;
import com.tw.apistackbase.entity.CaseDetail;
import com.tw.apistackbase.entity.Inquisitor;
import com.tw.apistackbase.entity.Procuratorate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DataJpaTest
@ExtendWith(SpringExtension.class)public class CaseBasicRepositoryTest {

    @Autowired
    private CaseBasicRepository caseBasicRepository;
    @Autowired
    private CaseDetailRepository caseDetailRepository;

    @Test
    void should_save_and_find_case_basic() {

        CaseDetail caseDetail = new CaseDetail();
        caseDetail.setObjectiveDescription("objectiveDes");
        caseDetail.setSubjectiveDescription("subjectDes");
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setProcuratorateName("procuratorateName");
        Inquisitor inquisitor1 = new Inquisitor();
        inquisitor1.setName("inq1");
        Inquisitor inquisitor12 = new Inquisitor();
        inquisitor12.setName("inq2");
        List<Inquisitor> inquisitors = Arrays.asList(inquisitor1,inquisitor12);
        procuratorate.setInquisitors(inquisitors);
        CaseBasic caseBasic = new CaseBasic();
        caseBasic.setName("c1");
        caseBasic.setCaseDetail(caseDetail);
        caseBasic.setOccurrenceTime(Long.parseLong("10000"));
        caseBasic.setProcuratorate(procuratorate);
        caseBasicRepository.saveAndFlush(caseBasic);

        CaseBasic caseBasic1 = caseBasicRepository.getOne(caseDetail.getId());

        assertEquals(caseBasic.getName(),"c1");
        assertSame(caseDetailRepository.findAll().size(),1);
    }

    @Test
    void should_delete_case_basic_and_detail() {
        CaseDetail caseDetail = new CaseDetail();
        caseDetail.setObjectiveDescription("objectiveDes");
        caseDetail.setSubjectiveDescription("subjectDes");
        CaseBasic caseBasic = new CaseBasic();
        caseBasic.setName("c1");
        caseBasic.setCaseDetail(caseDetail);
        caseBasic.setOccurrenceTime(Long.parseLong("10000"));
        caseBasicRepository.saveAndFlush(caseBasic);
        caseBasicRepository.delete(caseBasic);

        assertEquals(caseBasicRepository.findAll().size(),0);
        assertEquals(caseDetailRepository.findAll().size(),0);
    }

    @Test
    void should_update_case_basic_and_detail() {
        CaseDetail caseDetail = new CaseDetail();
        caseDetail.setObjectiveDescription("objectiveDes");
        caseDetail.setSubjectiveDescription("subjectDes");
        CaseBasic caseBasic = new CaseBasic();
        caseBasic.setName("c1");
        caseBasic.setCaseDetail(caseDetail);
        caseBasic.setOccurrenceTime(Long.parseLong("10000"));
        caseBasicRepository.saveAndFlush(caseBasic);
        caseBasic.setOccurrenceTime(Long.parseLong("200000"));
        caseDetail.setSubjectiveDescription("s2");
        caseBasicRepository.saveAndFlush(caseBasic);

        assertEquals(caseBasicRepository.getOne(caseBasic.getId()).getOccurrenceTime().toString(),"200000");
        assertEquals(caseBasicRepository.getOne(caseBasic.getId()).getCaseDetail().getSubjectiveDescription(),"s2");
    }

    @Test
    void should_return_exact_name_list() {
        CaseBasic caseBasic = new CaseBasic();
        caseBasic.setName("c1");
        caseBasic.setOccurrenceTime(Long.parseLong("10000"));
        CaseBasic caseBasic1 = new CaseBasic();
        caseBasic1.setName("c2");
        caseBasic1.setOccurrenceTime(Long.parseLong("20000"));
        caseBasicRepository.saveAll(Arrays.asList(caseBasic,caseBasic1));

        List<CaseBasic> findAllByNameC2 = caseBasicRepository.findAllByNameEquals("c2");
        List<CaseBasic> findAllByNameCase = caseBasicRepository.findAllByNameEquals("case");

        assertSame(findAllByNameC2.size(),1);
        assertSame(findAllByNameCase.size(),0);
    }
}
