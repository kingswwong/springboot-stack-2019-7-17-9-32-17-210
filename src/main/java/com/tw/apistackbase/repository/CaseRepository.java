package com.tw.apistackbase.repository;

import com.tw.apistackbase.base.BaseRepository;
import com.tw.apistackbase.entity.Case;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends BaseRepository<Case, Long> {
}
