package com.tw.apistackbase.repository;

import com.tw.apistackbase.base.BaseRepository;
import com.tw.apistackbase.entity.CaseBasic;
import com.tw.apistackbase.entity.Inquisitor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquisitorRepository extends BaseRepository<Inquisitor, Long> {

}
