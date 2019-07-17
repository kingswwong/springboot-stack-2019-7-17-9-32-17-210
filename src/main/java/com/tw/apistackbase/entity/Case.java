package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
@Table
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long occurrenceTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Long occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }
}
