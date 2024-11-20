package sn.seydina.springvalidator.model;

import jakarta.validation.constraints.*;
import sn.seydina.springvalidator.validator.AnneeValid;

public class Voiture {

    @NotNull(message = "le numero d'immatriculation doit être fourni")
    @Pattern(regexp = "[A-Z]{2}-[0-9]{5}-[A-Z]{2}", message = "le numero d'immatriculation doit être de la forme XX-12345-XX")
    private String numeroImmatriculation;

    @NotBlank(message = "le nom de la marque doit être fourni")
    private String marque;


    @NotBlank(message = "Le modèle doit être fourni")
    @Size(min = 2, max = 30 , message = "le model doit être compris entre 2 et 30 caractères")
    private String modele;

    @AnneeValid(message = "annee invalide")
    private int annee;

    @PositiveOrZero(message = "Le kilométrage doit être positif")
    private double kilometerage;

    @NotNull(message = "Le prix doit être fourni")
    @Positive(message = "Le prix doit être positif")
    private double prix;


}
