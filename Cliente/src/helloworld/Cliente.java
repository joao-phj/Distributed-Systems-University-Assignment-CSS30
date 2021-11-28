package helloworld;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Essa é a classe do cliente contendo todas as interações que podem ocorrer do
 * usuário para com o servidor através da interface de cliente
 *
 * Date: Oct 16-2018
 *
 * @author João Pedro Passos
 * @version 1.0
 */
public class Cliente {

    /**
     * @param args the command line arguments
     *
     * dentro da main eh onde sera administrada a interação do usuario, podendo
     * esta variar desde entre consulta, compra de voos, hoteis e pacotes assim
     * como a consulta, realziação e deleção de reservas referente aos
     * anteriores
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry referenciaServicoNomes = LocateRegistry.getRegistry(1099);
        InterfaceServidor refServidor = (InterfaceServidor) referenciaServicoNomes.lookup("HelloWorld");
        CliImpl clip = new CliImpl(refServidor);
        int opt = 0;
        int opt2 = 0;
        String str;
        int idAux;

        while (opt != 4) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n\n*********************Menu Principal********************\n\n");

            System.out.println("Selecione a opção de seu interesse:\n1-Hotéis"
                    + "\n2-Voos\n"
                    + "3-Pacotes\n"
                    + "4-Sair\n");
            opt = scan.nextInt();
            idAux = 0;
            opt2 = 0;

            if (opt == 1) {
                while (opt2 != 4) {
                    System.out.println("\n\n*********************Menu Hoteis********************\n\n");

                    System.out.println("Selecione a opção de seu interesse:\n"
                            + "1-Consultar Hotéis\n"
                            + "2-Comprar estadia\n"
                            + "3-Reservas\n"
                            + "4-Sair\n");
                    opt2 = scan.nextInt();
                    if (opt2 == 1) {
                        System.out.println("\n\n******************Hoteis Cadastrados******************\n\n");

                        refServidor.getHoteis(clip);
                    }
                    if (opt2 == 2) {
                        System.out.println("\n\n*******************Menu Compra Hoteis*****************\n\n");

                        System.out.println("Insira a quantidade de pessoas\n");
                        Scanner scan2 = new Scanner(System.in);
                        int pessoas = scan2.nextInt();

                        System.out.println("\nInsira a quantidade de quartos\n");
                        Scanner scan3 = new Scanner(System.in);
                        int quartos = scan3.nextInt();

                        System.out.println("\nInsira a data de entrada (dd/MM/yyyy)\n");
                        Scanner scan4 = new Scanner(System.in);
                        String entrada = scan4.nextLine();

                        System.out.println("\nInsira a data de saida (dd/MM/yyyy)\n");
                        Scanner scan5 = new Scanner(System.in);
                        String saida = scan5.nextLine();

                        System.out.println("\nQuanta deseja pagar no maximo por quarto\n");
                        Scanner scan7 = new Scanner(System.in);
                        int preco = scan7.nextInt();

                        System.out.println("\nProcurar por:\n"
                                + "1-Nome\n"
                                + "2-Localidade\n");
                        Scanner scan8 = new Scanner(System.in);
                        int opt3 = scan8.nextInt();

                        if (opt3 == 1) {
                            System.out.println("\nInsira o nome do hotel\n");
                            Scanner scan9 = new Scanner(System.in);
                            String nome = scan9.nextLine();

                            refServidor.comprarHoteis(clip, opt3, preco, pessoas, quartos, entrada, saida, nome, null);
                        }
                        if (opt3 == 2) {
                            System.out.println("\nInsira o local do hotel\n");
                            Scanner scan9 = new Scanner(System.in);
                            String local = scan9.nextLine();

                            refServidor.comprarHoteis(clip, opt3, preco, pessoas, quartos, entrada, saida, null, local);
                        }
                    }
                    if (opt2 == 3) {
                        System.out.println("\n\n*******************Menu Reserva Hoteis*****************\n\n");
                        System.out.println("Selecione a opção de seu interesse:\n"
                                + "1-Consultar suas Reservas\n"
                                + "2-Realizar uma Reserva\n"
                                + "3-Cancelar uma Reserva\n"
                                + "4-Sair\n");
                        Scanner scan2 = new Scanner(System.in);
                        int opt3 = scan2.nextInt();

                        if (opt3 == 1) {
                            System.out.println("\n\n************************Suas Reservas de Hoteis**********************\n\n");

                            refServidor.getReservasHoteis(clip);
                        }
                        if (opt3 == 2) {
                            System.out.println("\n\n************************Criação Reserva de Hotel**********************\n\n");

                            System.out.println("Insira o local onde deseja um hotel\n");
                            Scanner scan3 = new Scanner(System.in);
                            String local = scan3.nextLine();

                            System.out.println("\nInsira o preço máximo que deseja pagar\n");
                            Scanner scan4 = new Scanner(System.in);
                            int preco = scan4.nextInt();

                            refServidor.reservaHoteis(clip, local, preco);
                        }
                        if (opt3 == 3) {
                            System.out.println("\n\n************************Cancelamento Reserva de Hotel**********************\n\n");

                            System.out.println("Insira o id da reserva\n");
                            Scanner scan3 = new Scanner(System.in);
                            int idRes = scan3.nextInt();

                            refServidor.cancelarReservasHoteis(clip, idRes);
                        }

                    }
                    if (opt2 > 4) {
                        System.out.println("\nOpção Invalida!\n");
                    }
                }
            }

            if (opt == 2) {
                while (opt2 != 4) {
                    System.out.println("\n\n**********************Menu Voos**********************\n\n");

                    System.out.println("Selecione a opção de seu interesse:\n"
                            + "1-Consultar Voos\n"
                            + "2-Comprar Passagem\n"
                            + "3-Reservas\n"
                            + "4-Sair\n");
                    opt2 = scan.nextInt();
                    if (opt2 == 1) {
                        System.out.println("\n\n**********************Voos Cadastrados**********************\n\n");

                        refServidor.getVoos(clip);
                    }
                    if (opt2 == 2) {
                        System.out.println("\n\n**********************Menu Compra Voos**********************\n\n");

                        System.out.println("Insira o destino desejado\n");
                        Scanner scan2 = new Scanner(System.in);
                        String destino = scan2.nextLine();

                        System.out.println("\nInsira a origem desejada\n");
                        Scanner scan4 = new Scanner(System.in);
                        String origem = scan4.nextLine();

                        System.out.println("\nInsira o preço máximo por pessoa\n");
                        Scanner scan8 = new Scanner(System.in);
                        int preco = scan8.nextInt();

                        System.out.println("\nInsira a quantdade de pessoas\n");
                        Scanner scan3 = new Scanner(System.in);
                        int qtde = scan3.nextInt();

                        System.out.println("\n(1) Ida - (2) Ida e Volta\n");
                        Scanner scan5 = new Scanner(System.in);
                        int opt3 = scan5.nextInt();

                        if (opt3 == 1) {
                            System.out.println("\nInsira a data de partida (dd/MM/yyyy)\n");
                            Scanner scan6 = new Scanner(System.in);
                            String part = scan6.nextLine();

                            refServidor.comprarVoos(clip, opt3, qtde, preco, destino, origem, part, null);
                        }
                        if (opt3 == 2) {
                            System.out.println("\nInsira a data de partida (dd/MM/yyyy)\n");
                            Scanner scan6 = new Scanner(System.in);
                            String part = scan6.nextLine();

                            System.out.println("Insira a data de chegada (dd/MM/yyyy)\n");
                            Scanner scan7 = new Scanner(System.in);
                            String cheg = scan7.nextLine();

                            refServidor.comprarVoos(clip, opt3, qtde, preco, destino, origem, part, cheg);
                        }
                    }
                    if (opt2 == 3) {
                        System.out.println("\n\n**********************Menu Reserva Voos**********************\n\n");

                        System.out.println("Selecione a opção de seu interesse:\n"
                                + "1-Consultar suas Reservas\n"
                                + "2-Realizar uma Reserva\n"
                                + "3-Cancelar uma Reserva\n"
                                + "4-Sair\n");
                        Scanner scan2 = new Scanner(System.in);
                        int opt3 = scan2.nextInt();

                        if (opt3 == 1) {
                            System.out.println("\n\n************************Suas Reservas de Voos**********************\n\n");
                            refServidor.getReservasHoteis(clip);
                        }
                        if (opt3 == 2) {
                            System.out.println("\n\n************************Criação Reserva de Voo**********************\n\n");

                            System.out.println("Insira a origem do voo\n");
                            Scanner scan3 = new Scanner(System.in);
                            String origem = scan3.nextLine();

                            System.out.println("\nInsira o destino do voo\n");
                            Scanner scan4 = new Scanner(System.in);
                            String destino = scan4.nextLine();

                            System.out.println("\nInsira o preço do voo\n");
                            Scanner scan5 = new Scanner(System.in);
                            int preco = scan5.nextInt();

                            refServidor.reservaVoo(clip, origem, destino, preco);
                        }
                        if (opt3 == 3) {
                            System.out.println("\n\n************************Cancelamento Reserva de Voo**********************\n\n");

                            System.out.println("Insira o id da reserva\n");
                            Scanner scan3 = new Scanner(System.in);
                            int idRes = scan3.nextInt();

                            refServidor.cancelarReservasVoos(clip, idRes);
                        }
                    }
                    if (opt2 == 4) {
                    }
                    if (opt2 > 4) {
                        System.out.println("\nOpção Invalida!\n");
                    }
                }
            }

            if (opt == 3) {
                while (opt2 != 4) {
                    System.out.println("\n\n**********************Menu Pacotes**********************\n\n");

                    System.out.println("Selecione a opção de seu interesse:\n"
                            + "1-Consultar Pacotes\n"
                            + "2-Comprar Pacotes\n"
                            + "3-Reservas\n"
                            + "4-Sair\n");
                    opt2 = scan.nextInt();
                    if (opt2 == 1) {
                        System.out.println("\n\n**********************Pacotes Cdastrados**********************\n\n");

                        refServidor.getPacotes(clip);
                    }
                    if (opt2 == 2) {
                        System.out.println("\n\n**********************Menu Compra Pacotes**********************\n\n");

                        System.out.println("Insira a origem\n");
                        Scanner scan3 = new Scanner(System.in);
                        String origem = scan3.nextLine();

                        System.out.println("\nInsira o destino\n");
                        Scanner scan4 = new Scanner(System.in);
                        String destino = scan4.nextLine();

                        System.out.println("\nInsira a quantidade de pessoas\n");
                        Scanner scan5 = new Scanner(System.in);
                        int pessoas = scan5.nextInt();

                        System.out.println("\nInsira a quantidade de quartos\n");
                        Scanner scan6 = new Scanner(System.in);
                        int quartos = scan6.nextInt();

                        System.out.println("\nInsira a data de entrada (dd/MM/yyyy)\n");
                        Scanner scan7 = new Scanner(System.in);
                        String entrada = scan7.nextLine();

                        System.out.println("\nInsira a data de saida (dd/MM/yyyy)\n");
                        Scanner scan8 = new Scanner(System.in);
                        String saida = scan8.nextLine();

                        System.out.println("\nInsira o preco maximo que deseja pagar por pessoa no pacote\n");
                        Scanner scan9 = new Scanner(System.in);
                        int preco = scan9.nextInt();

                        System.out.println("\nDeseja procurar pelo nome de um hotel especifico:\n"
                                + "1-Sim\n"
                                + "2-Não\n");
                        Scanner scan10 = new Scanner(System.in);
                        int opt3 = scan10.nextInt();

                        if (opt3 == 1) {
                            System.out.println("\nInsira o nome do hotel\n");
                            Scanner scan11 = new Scanner(System.in);
                            String nome = scan11.nextLine();

                            refServidor.comprarPacotes(clip, opt3, preco, pessoas, quartos, destino, origem, entrada, saida, nome);
                        }
                        if (opt3 == 2) {
                            refServidor.comprarPacotes(clip, opt3, preco, pessoas, quartos, destino, origem, entrada, saida, null);
                        }
                    }
                    if (opt2 == 3) {
                        System.out.println("\n\n**********************Menu Reserva Pacotes**********************\n\n");

                        System.out.println("Selecione a opção de seu interesse:\n"
                                + "1-Consultar suas Reservas\n"
                                + "2-Realizar uma Reserva\n"
                                + "3-Cancelar uma Reserva\n"
                                + "4-Sair\n");
                        Scanner scan2 = new Scanner(System.in);
                        int opt3 = scan2.nextInt();

                        if (opt3 == 1) {
                            System.out.println("\n\n************************Suas Reservas de Pacotes**********************\n\n");
                            refServidor.getReservasPacotes(clip);
                        }
                        if (opt3 == 2) {
                            System.out.println("\n\n************************Criação Reserva de Pacote**********************\n\n");

                            System.out.println("Insira a origem\n");
                            Scanner scan3 = new Scanner(System.in);
                            String origem = scan3.nextLine();

                            System.out.println("\nInsira o destino\n");
                            Scanner scan4 = new Scanner(System.in);
                            String destino = scan4.nextLine();

                            System.out.println("\nInsira o preco\n");
                            Scanner scan5 = new Scanner(System.in);
                            int preco = scan5.nextInt();

                            refServidor.reservaPacote(clip, origem, destino, preco);
                        }
                        if (opt3 == 3) {
                            System.out.println("\n\n************************Cancelamento Reserva de Pacote**********************\n\n");

                            System.out.println("Insira o id da reserva\n");
                            Scanner scan3 = new Scanner(System.in);
                            int idRes = scan3.nextInt();

                            refServidor.cancelarReservasPacotes(clip, idRes);
                        }
                    }
                    if (opt2 > 4) {
                        System.out.println("\nOpção Invalida!\n");
                    }
                }
            }
            if (opt > 4) {
                System.out.println("\nOpção Invalida!\n");
            }
        }
    }

}
