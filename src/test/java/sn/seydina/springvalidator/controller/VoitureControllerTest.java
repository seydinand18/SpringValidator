package sn.seydina.springvalidator.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class VoitureControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String json = """
            {
                "numeroImmatriculation": "AA-12345-DL",
                "marque": "Range Rover",
                "modele": "Evoque",
                "annee": 2024,
                "kilometerage": 5000,
                "prix": 150000000.0
            }
            """;

    @Test
    void doitRetournerLaVoitureEnregistree() throws Exception {
        mockMvc.perform(post("/api/v1/voiture")
                .content(json)
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroImmatriculation").value("AA-12345-DL"))
                .andExpect(jsonPath("$.marque").value("Range Rover"))
                .andExpect(jsonPath("$.modele").value("Evoque"))
                .andExpect(jsonPath("$.annee").value(2024))
                .andExpect(jsonPath("$.kilometerage").value(5000))
                .andExpect(jsonPath("$.prix").value(150000000.0));

    }

    @Test
    void doitRetournerUneErreur() throws Exception {
        String json = """
                {
                    "numeroImmatriculation": "--AA-12345",
                    "modele": "E",
                    "annee": 1996,
                    "kilometerage": -5000,
                    "prix": -150000000.0
                }
                """;

        mockMvc.perform(post("/api/v1/voiture")
                .content(json)
                .contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.numeroImmatriculation").value("le numero d'immatriculation doit être de la forme XX-12345-XX"))
                .andExpect(jsonPath("$.marque").value("le nom de la marque doit être fourni"))
                .andExpect(jsonPath("$.modele").value("le model doit être compris entre 2 et 30 caractères"))
                .andExpect(jsonPath("$.prix").value("Le prix doit être positif"))
                .andExpect(jsonPath("$.kilometerage").value("Le kilométrage doit être positif"))
                .andExpect(jsonPath("$.annee").value("annee invalide"))
                .andExpect(jsonPath("$.kilometerage").value("Le kilométrage doit être positif"))
                .andExpect(jsonPath("$.prix").value("Le prix doit être positif"));

    }

}
