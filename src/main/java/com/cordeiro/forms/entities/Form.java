package com.cordeiro.forms.entities;

import com.cordeiro.forms.DTO.FormResponseDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "forms")
@Entity(name = "forms")
@EqualsAndHashCode(of = "id")
public class Form {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String image;

    private String signature;


    public Form (FormResponseDTO formResponseDTO){
        this.title = formResponseDTO.title();
        this.description = formResponseDTO.description();
        this.image = formResponseDTO.image();
        this.signature = formResponseDTO.signature();
    }

}
