package views;

import controllers.HospedeDAO;
import controllers.FuncionarioDAO;
import models.Hospede;
import models.Funcionario;

import java.util.Scanner;

public class MenuView {
    private Scanner sc = new Scanner(System.in);
    private HospedeDAO hospedeDAO = new HospedeDAO();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Sistema de Gestão da Pousada ===");
            System.out.println("1 - Criar");
            System.out.println("2 - Deletar");
            System.out.println("3 - Listar");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    menuCriar();
                    break;
                case 2:
                    menuDeletar();
                    break;
                case 3:
                    menuListar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void menuCriar() {
        System.out.println("\n--- Criar ---");
        System.out.println("1 - Hóspede");
        System.out.println("2 - Funcionário");
        System.out.print("Escolha: ");
        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1:
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Telefone: ");
                String telefone = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                hospedeDAO.inserir(new Hospede(0, nome, cpf, telefone, email));
                System.out.println("Hóspede cadastrado!");
                break;

            case 2:
                System.out.print("Nome: ");
                String nomeF = sc.nextLine();
                System.out.print("Cargo: ");
                String cargo = sc.nextLine();
                System.out.print("Jornada de trabalho (horas): ");
                int jornada = Integer.parseInt(sc.nextLine());
                funcionarioDAO.inserir(new Funcionario(0, nomeF, cargo, jornada));
                System.out.println("Funcionário cadastrado!");
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    private void menuDeletar() {
        System.out.println("\n--- Deletar ---");
        System.out.println("1 - Hóspede");
        System.out.println("2 - Funcionário");
        System.out.print("Escolha: ");
        int opcao = Integer.parseInt(sc.nextLine());

        System.out.print("ID a deletar: ");
        int id = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1:
                hospedeDAO.deletar(id);
                System.out.println("Hóspede removido.");
                break;

            case 2:
                funcionarioDAO.deletar(id);
                System.out.println("Funcionário removido.");
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    private void menuListar() {
        System.out.println("\n--- Listar ---");
        System.out.println("1 - Hóspedes");
        System.out.println("2 - Funcionários");
        System.out.print("Escolha: ");
        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1:
                hospedeDAO.listar().forEach(System.out::println);
                break;
            case 2:
                funcionarioDAO.listar().forEach(System.out::println);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}

