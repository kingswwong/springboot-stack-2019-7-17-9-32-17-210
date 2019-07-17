package com.tw.apistackbase.repository;

import com.tw.apistackbase.base.BaseRepository;
import com.tw.apistackbase.entity.CaseBasic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseBasicRepository extends BaseRepository<CaseBasic, Long> {

    List<CaseBasic> findAllByNameEquals(String name);
}
