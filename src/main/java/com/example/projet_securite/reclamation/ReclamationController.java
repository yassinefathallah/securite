package com.example.projet_securite.reclamation;

import com.example.projet_securite.reclamation.Reclamation;
import com.example.projet_securite.reclamation.ReclamtionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamations")
@RequiredArgsConstructor
public class ReclamationController {
    private final ReclamtionService reclamationService;

    /*@PostMapping("/add")
    public ResponseEntity<Reclamation> ajouterReclamation(@RequestBody Reclamation reclamation) {
        Reclamation newReclamation = reclamationService.addReclamation(reclamation);
        return new ResponseEntity<>(newReclamation, HttpStatus.OK);
    }*/



   @PostMapping("/add")
public ResponseEntity<?> ajouterReclamation(
        @RequestBody ReclamationRequest request) {
    try {
        reclamationService.save(request);
        return ResponseEntity.accepted().build();
        } catch (Exception e) {
        // Gérer toute exception liée au chiffrement ou à la sauvegarde
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'enregistrement de la réclamation.");
           }
    }

   /* @GetMapping("/all")
    public ResponseEntity<List<Reclamation>> findAllReclamation() {
        return ResponseEntity.ok(reclamationService.findAll());
    }
*/

   @GetMapping("/all")
    public ResponseEntity<List<ReclamationResponse>> getAllReclamations() {
        List<ReclamationResponse> reclamations = reclamationService.getAllReclamations();
        return ResponseEntity.ok(reclamations);

}}



