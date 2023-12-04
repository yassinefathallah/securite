package com.example.projet_securite.reclamation;

import com.example.projet_securite.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Reclamation {
    @Id
    @GeneratedValue
    private Long id;
    private String sujet;
    private String description;
    private Date dateReclamation;

    @ManyToOne
    @JoinColumn(name = "email")
    private User user ;

    public String getSujet() {
        return sujet;
    }

    public String getDescription() {
        return description ;
    }

    public Date getDateReclamation() {
        return dateReclamation ;
    }
}