package unipe.edu.br.jeff;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MinhaAgendaDeAniversarios minhaAgenda = new MinhaAgendaDeAniversarios();
        Scanner input = new Scanner(System.in);

        System.out.println("---------------- Sistema de Gerenciamento de Aniversários ----------------");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar aniversariante");
            System.out.println("2 - Consultar aniversariantes de uma data");
            System.out.println("3 - Remover aniversariante");
            System.out.println("4 - Listar todos os aniversariantes");
            System.out.println("5 - Sair");

            System.out.print("Opção: ");
            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = input.nextLine();

                    System.out.print("Digite o dia de aniversário: ");
                    int dia = input.nextInt();

                    System.out.print("Digite o mês de aniversário: ");
                    int mes = input.nextInt();
                    input.nextLine();

                    minhaAgenda.adicionarAniversariante(nome, dia, mes);
                    System.out.println("✅ Aniversariante adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o dia: ");
                    int diaConsulta = input.nextInt();
                    System.out.print("Digite o mês: ");
                    int mesConsulta = input.nextInt();
                    input.nextLine();

                    ArrayList<String> aniversariantes = minhaAgenda.obterAniversariantesDoDia(diaConsulta, mesConsulta);

                    if (aniversariantes.isEmpty()) {
                        System.out.println("❌ Nenhum aniversariante encontrado nessa data.");
                    } else {
                        System.out.println("🎂 Aniversariantes em " + diaConsulta + "/" + mesConsulta + ":");
                        for (String a : aniversariantes) {
                            System.out.println("- " + a);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome do aniversariante a remover: ");
                    String nomeRemover = input.nextLine();
                    minhaAgenda.removerAniversariante(nomeRemover);
                    System.out.println("🗑️ Aniversariante removido (se existia).");
                    break;

                case 4:
                    System.out.println("📋 Lista completa de aniversariantes:");
                    System.out.println(minhaAgenda.toString());
                    break;

                case 5:
                    System.out.println("👋 Saindo do sistema. Até logo!");
                    input.close();
                    return;

                default:
                    System.out.println("⚠️ Opção inválida. Tente novamente.");
            }
        }
    }
}