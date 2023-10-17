package com.cordeiro.forms.DTO;

import com.cordeiro.forms.entities.Form;

public record FormResponseDTO(Long id, String title, String description, String image, String signature) {

    public FormResponseDTO(Form form){
        this(form.getId(), form.getTitle(), form.getDescription(), form.getImage(), form.getSignature());
    }
}
