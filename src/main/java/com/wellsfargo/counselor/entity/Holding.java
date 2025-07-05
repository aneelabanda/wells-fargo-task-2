package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Holding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long holdingId;


    @ManyToOne(optional = false)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "security_id")
    private Security security;


    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    private int purchaseQuantity;

    protected Holding() { }

    public Holding(Portfolio portfolio,
                   Security security,
                   LocalDate purchaseDate,
                   BigDecimal purchasePrice,
                   int purchaseQuantity) {
        this.portfolio        = portfolio;
        this.security         = security;
        this.purchaseDate     = purchaseDate;
        this.purchasePrice    = purchasePrice;
        this.purchaseQuantity = purchaseQuantity;
    }


    public Long getHoldingId()                 { return holdingId; }

    public Portfolio getPortfolio()            { return portfolio; }
    public void      setPortfolio(Portfolio p) { this.portfolio = p; }

    public Security getSecurity()              { return security; }
    public void     setSecurity(Security s)    { this.security = s; }

    public LocalDate getPurchaseDate()               { return purchaseDate; }
    public void      setPurchaseDate(LocalDate d)    { this.purchaseDate = d; }

    public BigDecimal getPurchasePrice()                { return purchasePrice; }
    public void       setPurchasePrice(BigDecimal price){ this.purchasePrice = price; }

    public int  getPurchaseQuantity()              { return purchaseQuantity; }
    public void setPurchaseQuantity(int quantity)  { this.purchaseQuantity = quantity; }
}
