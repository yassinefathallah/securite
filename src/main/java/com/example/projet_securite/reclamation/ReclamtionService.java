package com.example.projet_securite.reclamation;

import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.time.LocalDate;
import java.util.*;

//22222

@Service
public class ReclamtionService {
    private final ReclamationRepo reclamationRepo ;
    private final Key encryptionKey;

    public ReclamtionService(ReclamationRepo reclamationRepo) throws NoSuchAlgorithmException {
        this.reclamationRepo = reclamationRepo;
        this.encryptionKey = generateEncryptionKey();
    }
    private static SecretKey generateEncryptionKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
/*
 public void save(ReclamationRequest request) {
      var reclamation = Reclamation.builder()
              .dateReclamation(request.getDateReclamation())
              .sujet(request.getSujet())
              .description(request.getDescription())
              .build();
      reclamationRepo.save(reclamation);

   public List<ReclamationResponse> getAllReclamations() {
       List<Reclamation> reclamations = reclamationRepo.findAll();

       List<ReclamationResponse> responses = new ArrayList<>();


       for (Reclamation reclamation : reclamations) {
           ReclamationResponse response = new ReclamationResponse();
           response.setSujet(reclamation.getSujet());
           response.setDescription(reclamation.getDescription());
           response.setDateReclamation(reclamation.getDateReclamation());
           responses.add(response);
       }
       return responses;

   }
    public List<ReclamationResponse> getAllReclamations() {
        List<Reclamation> reclamations = reclamationRepo.findAll();
        List<ReclamationResponse> responses = new ArrayList<>();

        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, encryptionKey);

            for (Reclamation reclamation : reclamations) {
                ReclamationResponse response = new ReclamationResponse();
                response.setSujet(reclamation.getSujet());
                byte[] encryptedData = Base64.getDecoder().decode(reclamation.getDescription());
                byte[] decryptedData = cipher.doFinal(encryptedData);
                response.setDescription(new String(decryptedData));
                response.setDateReclamation(reclamation.getDateReclamation());
                responses.add(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responses;
    }



    /*

}
/*
}

*/public List<ReclamationResponse> getAllReclamations() {
    List<Reclamation> reclamations = reclamationRepo.findAll();
    List<ReclamationResponse> responses = new ArrayList<>();

    try {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, encryptionKey);

        for (Reclamation reclamation : reclamations) {
            ReclamationResponse response = new ReclamationResponse();
            response.setSujet(reclamation.getSujet());
            byte[] encryptedData = Base64.getDecoder().decode(reclamation.getDescription());
            byte[] decryptedData = cipher.doFinal(encryptedData);
            response.setDescription(new String(decryptedData));
            response.setDateReclamation(reclamation.getDateReclamation());
            responses.add(response);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return responses;
}

    public void save(ReclamationRequest request) {
    try {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
        byte[] encryptedData = cipher.doFinal(request.getDescription().getBytes());
        Date dateReclamation = new Date();

        var reclamation = Reclamation.builder()
                .dateReclamation(dateReclamation)
                .sujet(request.getSujet())
                .description(Base64.getEncoder().encodeToString(encryptedData)) // Enregistrez la donnée chiffrée dans la base de données
                .build();
        reclamationRepo.save(reclamation);
    } catch (Exception e) {
        e.printStackTrace();
    }
}


}




