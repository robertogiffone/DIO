package me.dio.academia.digital.entity.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExercicioForm {
    @Positive(message = "O Id do aluno precisa ser positivo.")
    private Long alunoId;

    @NotEmpty(message = "Preencha o campo corretamente.")
    private String descricao;
}
