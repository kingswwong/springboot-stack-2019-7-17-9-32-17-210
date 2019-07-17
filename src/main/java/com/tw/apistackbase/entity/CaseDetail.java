package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
@Table
public class CaseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String subjectiveDescription;
    @Column(nullable = false)
    private String objectiveDescription;
    @OneToOne
    @JoinColumn(name = "case_basic_id",referencedColumnName = "id")
    private CaseBasic caseBasic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectiveDescription() {
        return subjectiveDescription;
    }

    public void setSubjectiveDescription(String subjectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }

    public CaseBasic getCaseBasic() {
        return caseBasic;
    }

    public void setCaseBasic(CaseBasic caseBasic) {
        this.caseBasic = caseBasic;
    }
}
