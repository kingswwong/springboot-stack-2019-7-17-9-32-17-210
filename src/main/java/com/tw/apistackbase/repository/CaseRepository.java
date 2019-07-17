package com.tw.apistackbase.repository;

import com.tw.apistackbase.base.BaseRepository;
import com.tw.apistackbase.entity.Case;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends BaseRepository<Case, Long> {

    List<Case> findAllByNameEquals(String name);
}
