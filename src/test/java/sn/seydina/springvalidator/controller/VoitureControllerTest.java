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

}
