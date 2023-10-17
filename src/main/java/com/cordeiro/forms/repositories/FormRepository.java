package com.cordeiro.forms.repositories;

import com.cordeiro.forms.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
}
