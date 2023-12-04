package com.example.projet_securite.reclamation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ReclamationResponse {
    private String sujet;
    private String description;
    private Date dateReclamation;

    public ReclamationResponse() {

    }




}
