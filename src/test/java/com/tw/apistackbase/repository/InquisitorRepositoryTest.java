package com.tw.apistackbase.repository;


import com.tw.apistackbase.entity.Inquisitor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class InquisitorRepositoryTest {

    @Autowired
    private InquisitorRepository inquisitorRepository;

    @Test
    void should_save_and_find_inquistor() {
        Inquisitor inquisitor = new Inquisitor();
        inquisitor.setName("inquisitor");

        inquisitorRepository.saveAndFlush(inquisitor);
        Inquisitor correspondInquisitor = inquisitorRepository.getOne(inquisitor.getId());

        assertThat(correspondInquisitor.getName()).isEqualTo("inquisitor");
    }

    @Test
    void should_delete_inquistor_by_id(){
        Inquisitor inquisitor = new Inquisitor();
        inquisitor.setName("inquisitor");

        inquisitorRepository.saveAndFlush(inquisitor);
        inquisitorRepository.delete(inquisitor);


        assertSame(inquisitorRepository.findAll().size(),0);
    }

    @Test
    void should_find_inquistor_by_id() {
        Inquisitor inquisitor = new Inquisitor();
        inquisitor.setName("inquisitor");

        inquisitorRepository.saveAndFlush(inquisitor);
        Inquisitor correspondInquisitor = inquisitorRepository.getOne(inquisitor.getId());
        assertEquals(correspondInquisitor.getName(),"inquisitor");
    }

    @Test
    void should_update_inquistor(){
        Inquisitor inquisitor = new Inquisitor();
        inquisitor.setName("inquisitor");

        inquisitorRepository.saveAndFlush(inquisitor);
        inquisitor.setName("inquistor2");
        inquisitorRepository.saveAndFlush(inquisitor);
        Inquisitor correspondInquisitor = inquisitorRepository.getOne(inquisitor.getId());
        assertEquals(correspondInquisitor.getName(),"inquistor2");
    }
}
