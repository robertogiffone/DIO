import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
    public static void main(String[] args) throws Exception {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição Curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("Descrição Curso JS");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("Descrição mentoria Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Banco Pan Java Developer");
        bootcamp.setDescricao("Descrição Banco Pan Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev dev1 = new Dev();
        dev1.setNome("Roberto");
        dev1.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Roberto: "+dev1.getConteudosInscritos());
        //dev1.progredir();
        //dev1.progredir();
        //dev1.progredir();
        dev1.progredir(mentoria);
        System.out.println("-");
        System.out.println("Conteúdos inscritos Roberto: "+dev1.getConteudosInscritos());
        System.out.println("Conteúdos concluídos Roberto: "+dev1.getConteudosConcluidos());
        System.out.println("XP: "+dev1.calcularTotalXp());

        System.out.println("-----------");

        Dev dev2 = new Dev();
        dev2.setNome("João");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos João: "+dev2.getConteudosInscritos());
        dev2.progredir();
        System.out.println("-");
        System.out.println("Conteúdos inscritos João: "+dev2.getConteudosInscritos());
        System.out.println("Conteúdos concluídos João: "+dev2.getConteudosConcluidos());
        System.out.println("XP: "+dev2.calcularTotalXp());

    }
}
