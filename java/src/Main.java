
import database.ConnectionFactory;
import models.Aluno;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = ConnectionFactory.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n1 - Adicionar");
                System.out.println("2 - Buscar por ID");
                System.out.println("3 - Listar todos");
                System.out.println("4 - Deletar");
                System.out.println("0 - Sair");
                String op = scanner.nextLine();

                switch (op) {
                    case "1" -> {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = Integer.parseInt(scanner.nextLine());
                        System.out.print("Matrícula: ");
                        String mat = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        int id = Aluno.create(conn, new Aluno(0, nome, idade, mat, email));
                        System.out.println("Aluno criado com ID: " + id);
                    }
                    case "2" -> {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        Aluno aluno = Aluno.read(conn, id);
                        if (aluno != null) System.out.printf("ID: %d, Nome: %s\n", aluno.id, aluno.nome);
                        else System.out.println("Não encontrado");
                    }
                    case "3" -> {
                        List<Aluno> alunos = Aluno.readAll(conn);
                        for (Aluno a : alunos) System.out.printf("ID: %d, Nome: %s\n", a.id, a.nome);
                    }
                    case "4" -> {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        Aluno.delete(conn, id);
                        System.out.println("Deletado");
                    }
                    case "0" -> System.exit(0);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
