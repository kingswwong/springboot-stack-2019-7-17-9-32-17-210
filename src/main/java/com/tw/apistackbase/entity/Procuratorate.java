package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique=true,length = 50)
    private String procuratorateName;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquisitor_id")
    private List<Inquisitor> inquisitorList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcuratorateName() {
        return procuratorateName;
    }

    public void setProcuratorateName(String procuratorateName) {
        this.procuratorateName = procuratorateName;
    }

    public List<Inquisitor> getInquisitorList() {
        return inquisitorList;
    }

    public void setInquisitorList(List<Inquisitor> inquisitorList) {
        this.inquisitorList = inquisitorList;
    }
}
