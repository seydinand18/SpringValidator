package sn.seydina.springvalidator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.seydina.springvalidator.model.Voiture;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/voiture")
public class VoitureController {

    private final List<Voiture> voitures = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Voiture> create(Voiture voiture) {
        voitures.add(voiture);
        Voiture voitureAjoutee = voitures.get(voitures.size() - 1);
        return ResponseEntity.ok(voitureAjoutee);
    }

}
