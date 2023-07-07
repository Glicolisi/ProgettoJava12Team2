package com.Team2Java12.MechAppoint.entities;




import com.Team2Java12.MechAppoint.dataStatus.ValidationEnum;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Clienti")
public class Cliente {
    @Id
    @Column (name = "Id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer cellulare;
    private ValidationEnum validation;

    public Cliente(Integer id ,String username, String password, String email, Integer cellulare, ValidationEnum validation) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cellulare = cellulare;
        this.validation = validation;

    }
    public Cliente(String username, String password, String email, Integer cellulare, ValidationEnum validation) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.cellulare = cellulare;
        this.validation = validation;
    }

    public Cliente() {
    }

    @ManyToMany
    @JoinTable(name = "Clienti_Officine",
            joinColumns = @JoinColumn(name = "Id"),
            inverseJoinColumns = @JoinColumn(name = "officinaid"))

    private List<Officina> officine;


    @OneToMany (mappedBy = "cliente")
    private List<Veicolo> veicoli;

    public List<Veicolo> getVeicoli() {
        return veicoli;
    }

    public void setVeicoli(List<Veicolo> veicoli) {
        this.veicoli = veicoli;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Officina> getOfficine() {
        return officine;
    }

    public void setOfficine(List<Officina> officine) {
        this.officine = officine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCellulare() {
        return cellulare;
    }

    public void setCellulare(Integer cellulare) {
        this.cellulare = cellulare;
    }


    public ValidationEnum getValidation() {
        return validation;
    }

    public void setValidation(ValidationEnum validation) {
        this.validation = validation;
    }
}
