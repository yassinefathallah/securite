package com.example.projet_securite.reclamation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ReclamationRequest {

    private String sujet;
    private String description;
    private Date dateReclamation;
}
