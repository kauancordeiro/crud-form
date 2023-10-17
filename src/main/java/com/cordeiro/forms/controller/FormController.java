package com.cordeiro.forms.controller;

import com.cordeiro.forms.DTO.FormResponseDTO;
import com.cordeiro.forms.entities.Form;
import com.cordeiro.forms.repositories.FormRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/formularios")
public class FormController {

    @Autowired
    private FormRepository formRepository;

    @GetMapping
    public List<FormResponseDTO> getAll(){
        List<FormResponseDTO> formList = formRepository.findAll().stream().map(FormResponseDTO::new).toList();
        return formList;

    }

    @GetMapping("/{id}")
    public ResponseEntity<FormResponseDTO> findById(@PathVariable Long id){
        Optional<Form> optionalForm = formRepository.findById(id);

        if (optionalForm.isPresent()) {
            Form form = optionalForm.get();
            FormResponseDTO formResponseDTO = new FormResponseDTO(form);
            return ResponseEntity.ok(formResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<FormResponseDTO> registerProduct(@RequestBody FormResponseDTO data){
        Form newForm = new Form(data);
        formRepository.save(newForm);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        formRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateForm(@PathVariable Long id, @RequestBody FormResponseDTO formResponseDTO) {
        Optional<Form> optionalForm = formRepository.findById(id);

        if (optionalForm.isPresent()) {
            Form form = optionalForm.get();
            form.setTitle(formResponseDTO.title());
            form.setDescription(formResponseDTO.description());
            form.setImage(formResponseDTO.image());
            return ResponseEntity.ok(form);
        } else {
            return ResponseEntity.notFound().build();
        }
    }







}
