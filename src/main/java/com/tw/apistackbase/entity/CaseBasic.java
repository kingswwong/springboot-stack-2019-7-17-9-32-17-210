package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
@Table
public class CaseBasic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long occurrenceTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "case_detail_id",referencedColumnName = "id")
    private CaseDetail caseDetail;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "procuratorate_id",referencedColumnName = "id")
    private Procuratorate procuratorate;


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

    public CaseDetail getCaseDetail() {
        return caseDetail;
    }

    public void setCaseDetail(CaseDetail caseDetail) {
        this.caseDetail = caseDetail;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }
}
