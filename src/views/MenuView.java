package views;

import controllers.HospedeDAO;
import controllers.FuncionarioDAO;
import controllers.QuartoDAO;

import models.Hospede;
import models.Funcionario;
import models.Quarto;

import java.util.Scanner;

public class MenuView {
    private Scanner sc = new Scanner(System.in);
    private HospedeDAO hospedeDAO = new HospedeDAO();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private QuartoDAO quartoDAO = new QuartoDAO();

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
                    menuCriacao();
                    break;
                case 2:
                    menuDelecao();
                    break;
                case 3:
                    menuListagem();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void menuCriacao() {
        System.out.println("\n--- Menu de Criação ---");
        System.out.println("1 - Hóspede");
        System.out.println("2 - Funcionário");
        System.out.println("3 - Quarto");
        System.out.print("Opção: ");
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

                Hospede h = new Hospede(0, nome, cpf, telefone, email);
                hospedeDAO.inserir(h);
                System.out.println("Hóspede cadastrado!");
                break;

            case 2:
                System.out.print("Nome: ");
                String nomeFunc = sc.nextLine();
                System.out.print("Cargo: ");
                String cargo = sc.nextLine();
                System.out.print("Login: ");
                String login = sc.nextLine();
                System.out.print("Senha: ");
                String senha = sc.nextLine();

                Funcionario f = new Funcionario(0, nomeFunc, cargo, login, senha);
                funcionarioDAO.inserir(f);
                System.out.println("Funcionário cadastrado!");
                break;

            case 3:
                System.out.print("Número do quarto: ");
                int numero = Integer.parseInt(sc.nextLine());
                System.out.print("Tipo: ");
                String tipo = sc.nextLine();
                System.out.print("Preço por diária: ");
                double preco = Double.parseDouble(sc.nextLine());
                Quarto q = new Quarto(0, numero, tipo, preco);
                quartoDAO.inserir(q);
                System.out.println("Quarto cadastrado!");
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    private void menuDelecao() {
        System.out.println("\n--- Menu de Deleção ---");
        System.out.println("1 - Hóspede");
        System.out.println("2 - Funcionário");
        System.out.println("3 - Quarto");
        System.out.print("Opção: ");
        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1:
                System.out.print("ID do hóspede: ");
                int idHospede = Integer.parseInt(sc.nextLine());
                hospedeDAO.deletar(idHospede);
                System.out.println("Hóspede deletado.");
                break;

            case 2:
                System.out.print("ID do funcionário: ");
                int idFunc = Integer.parseInt(sc.nextLine());
                funcionarioDAO.deletar(idFunc);
                System.out.println("Funcionário deletado.");
                break;

            case 3:
                System.out.print("ID do quarto: ");
                int idQuarto = Integer.parseInt(sc.nextLine());
                quartoDAO.deletar(idQuarto);
                System.out.println("Quarto deletado.");
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    private void menuListagem() {
        System.out.println("\n--- Menu de Listagem ---");
        System.out.println("1 - Hóspedes");
        System.out.println("2 - Funcionários");
        System.out.println("3 - Quartos");
        System.out.print("Opção: ");
        int opcao = Integer.parseInt(sc.nextLine());

        switch (opcao) {
            case 1:
                System.out.println("\n--- Lista de Hóspedes ---");
                hospedeDAO.listar().forEach(System.out::println);
                break;

            case 2:
                System.out.println("\n--- Lista de Funcionários ---");
                funcionarioDAO.listar().forEach(System.out::println);
                break;

            case 3:
                System.out.println("\n--- Lista de Quartos ---");
                quartoDAO.listar().forEach(System.out::println);
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }
}


