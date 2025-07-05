package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;


    @OneToOne(optional = false)
    @JoinColumn(name = "client_id", unique = true)
    private Client client;

    @Column(nullable = false)
    private LocalDate createdDate;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Holding> holdings = new HashSet<>();

    protected Portfolio() { }

    public Portfolio(Client client, LocalDate createdDate) {
        this.client       = client;
        this.createdDate  = createdDate;
    }


    public Long getPortfolioId()              { return portfolioId; }

    public Client getClient()                 { return client; }
    public void   setClient(Client client)    { this.client = client; }

    public LocalDate getCreatedDate()               { return createdDate; }
    public void      setCreatedDate(LocalDate date) { this.createdDate = date; }

    public Set<Holding> getHoldings()               { return holdings; }
}
