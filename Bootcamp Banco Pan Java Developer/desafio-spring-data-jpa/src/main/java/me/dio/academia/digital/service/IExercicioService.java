package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Exercicio;
import me.dio.academia.digital.entity.form.ExercicioForm;
import me.dio.academia.digital.entity.form.ExercicioUpdateForm;

import java.util.List;

public interface IExercicioService {
    Exercicio create(ExercicioForm form);

    Exercicio get(Long id);

    List<Exercicio> getAll();

    Exercicio update(Long id, ExercicioUpdateForm formUpdate);

    void delete(Long id);
}
