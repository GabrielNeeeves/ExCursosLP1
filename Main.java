import java.util.ArrayList;
import java.util.Scanner;

import model.Curso;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        ArrayList<Curso> listaCurso = new ArrayList<>();

        boolean sair = false;
        while(!sair) {
            System.out.println("# Digite um ação: ");
            System.out.println("1. Cadastrar CURSO");
            System.out.println("9. Sair");
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    int id;
                    do {
                        System.out.println("ID do CURSO:");
                        id = scanner.nextInt();
                    } while(id <= 0);

                    String desc;
                    do {
                        System.out.println("Descição do CURSO: ");
                        desc = scanner.next();
                        // scanner.next();
                    } while(desc.length() <= 10);
                    
                    String turno;
                    do {
                        System.out.println("Turno do CURSO");
                        turno = scanner.next();
                    } while(!(turno.equalsIgnoreCase("MATUTINO")) & !(turno.equalsIgnoreCase("vespertino")) & !(turno.equalsIgnoreCase("noturno")));

                    var novoCurso = new Curso(id, desc, turno);
                    if(novoCurso.getTurno().equalsIgnoreCase("MATUTINO")) {
                        Curso.qtdMatutino ++;
                    } else if(novoCurso.getTurno().equalsIgnoreCase("vespertino")) {
                        Curso.qtdVespertino ++;
                    } else {
                        Curso.qtdNoturno ++;
                    }

                    listaCurso.add(novoCurso);
                    break;
            
                case 9:
                    System.out.println("Saiu");
                    sair = true;
                default:
                    break;
            }
        }

        System.out.println();
        for (Curso curso : listaCurso) {
            System.out.println("ID: " + curso.getId());
            System.out.println("Descrição: " + curso.getDescricao());
            System.out.println("Turno: " + curso.getTurno().toUpperCase());
            System.out.println("----------------------");
        }

        System.out.println("Quantidade de Curso MATUTINOS: "+Curso.qtdMatutino);
        System.out.println("Quantidade de Curso VESPERTINOS: "+Curso.qtdVespertino);
        System.out.println("Quantidade de Curso NOTURNOS: "+Curso.qtdNoturno);

        scanner.close();
    }   
}
