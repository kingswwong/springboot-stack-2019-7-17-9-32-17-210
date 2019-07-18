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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "inquisitor_id")
    private List<Inquisitor> inquisitors;

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

    public List<Inquisitor> getInquisitors() {
        return inquisitors;
    }

    public void setInquisitors(List<Inquisitor> inquisitors) {
        this.inquisitors = inquisitors;
    }
}
