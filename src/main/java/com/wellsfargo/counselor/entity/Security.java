package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @OneToMany(mappedBy = "security", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Holding> holdings = new HashSet<>();

    protected Security() { }

    public Security(String name, String category) {
        this.name     = name;
        this.category = category;
    }


    public Long getSecurityId()          { return securityId; }

    public String getName()              { return name; }
    public void   setName(String name)   { this.name = name; }

    public String getCategory()               { return category; }
    public void   setCategory(String category){ this.category = category; }

    public Set<Holding> getHoldings()    { return holdings; }
}
