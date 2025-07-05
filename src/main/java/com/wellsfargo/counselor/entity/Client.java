package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;


    @ManyToOne(optional = false)
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Portfolio portfolio;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    protected Client() { }

    public Client(Advisor advisor, String name, String phone, String email) {
        this.advisor = advisor;
        this.name    = name;
        this.phone   = phone;
        this.email   = email;
    }

    public Long getClientId()           { return clientId; }
    public Advisor getAdvisor()         { return advisor; }
    public void   setAdvisor(Advisor a) { this.advisor = a; }

    public Portfolio getPortfolio()          { return portfolio; }
    public void      setPortfolio(Portfolio p) { this.portfolio = p; }

    public String getName()             { return name;   }
    public void   setName(String name)  { this.name = name; }

    public String getPhone()            { return phone;  }
    public void   setPhone(String phone){ this.phone = phone; }

    public String getEmail()            { return email;  }
    public void   setEmail(String email){ this.email = email; }
}
