package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Exercicio;
import me.dio.academia.digital.entity.form.ExercicioForm;
import me.dio.academia.digital.entity.form.ExercicioUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.ExercicioRepository;
import me.dio.academia.digital.service.IExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioServiceImpl implements IExercicioService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Exercicio create(ExercicioForm form) {
        Exercicio exercicio = new Exercicio();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        exercicio.setAluno(aluno);
        exercicio.setDescricao(form.getDescricao());

        return exercicioRepository.save(exercicio);
    }

    @Override
    public Exercicio get(Long id) {
        return null;
    }

    @Override
    public List<Exercicio> getAll() {
        return exercicioRepository.findAll();
    }

    @Override
    public Exercicio update(Long id, ExercicioUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {
    
    }
    
}