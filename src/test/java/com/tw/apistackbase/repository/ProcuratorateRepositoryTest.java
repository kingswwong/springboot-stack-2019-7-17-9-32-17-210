package com.tw.apistackbase.repository;


import com.tw.apistackbase.entity.Inquisitor;
import com.tw.apistackbase.entity.Procuratorate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ProcuratorateRepositoryTest {

    @Autowired
    private ProcuratorateRepository procuratorateRepository;

    @Autowired
    private InquisitorRepository inquisitorRepository;

    @Test
    void should_save_and_find_procuratorate() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setProcuratorateName("procuratorateName");
        Inquisitor inquisitor1 = new Inquisitor();
        inquisitor1.setName("inq1");
        Inquisitor inquisitor12 = new Inquisitor();
        inquisitor12.setName("inq2");
        List<Inquisitor> inquisitors = Arrays.asList(inquisitor1,inquisitor12);
        procuratorate.setInquisitors(inquisitors);
        procuratorateRepository.saveAndFlush(procuratorate);

        Procuratorate correspondProcuratorate = procuratorateRepository.getOne(procuratorate.getId());

        assertEquals(correspondProcuratorate.getProcuratorateName(),"procuratorateName");
        assertEquals(correspondProcuratorate.getInquisitors().size(),2);
        assertEquals(inquisitorRepository.findAll().size(),2);
    }

    @Test
    void should_delete_procuratorate() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setProcuratorateName("procuratorateName");
        procuratorateRepository.saveAndFlush(procuratorate);

        procuratorateRepository.delete(procuratorate);

        assertSame(procuratorateRepository.findAll().size(),0);

    }

    @Test
    void should_update_procuratorate() {
        Procuratorate procuratorate = new Procuratorate();
        procuratorate.setProcuratorateName("procuratorateName");
        procuratorateRepository.saveAndFlush(procuratorate);
        Inquisitor inquisitor1 = new Inquisitor();
        inquisitor1.setName("inq1");
        Inquisitor inquisitor12 = new Inquisitor();
        inquisitor12.setName("inq2");
        List<Inquisitor> inquisitors = new ArrayList<>();
        inquisitors.add(inquisitor1);
        inquisitors.add(inquisitor12);
        procuratorate.setInquisitors(inquisitors);
        procuratorate.setProcuratorateName("procuratorateName1");
        procuratorateRepository.saveAndFlush(procuratorate);

        Procuratorate correspondProcurate = procuratorateRepository.getOne(procuratorate.getId());

        assertEquals(correspondProcurate.getProcuratorateName(),"procuratorateName1");
        assertEquals(correspondProcurate.getInquisitors().size(),2);
        assertEquals(inquisitorRepository.findAll().size(),2);
    }


}
