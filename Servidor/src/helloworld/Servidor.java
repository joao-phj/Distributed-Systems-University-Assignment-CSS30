package helloworld;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Essa é uma classe responsável por administrar a interação do usuário aos
 * métodos presenetes no servidor
 *
 * Date: Oct 16-2018
 *
 * @author João Pedro Passos
 * @version 1.0
 */
public class Servidor {

    /**
     * @param args the command line arguments
     *
     * dentro da main eh onde sera administrada a interação do usuario, podendo
     * esta variar desde entre adição e consulta de itens existentes dentro do
     * servidor, podendo este ser hoteis, voos e pacotes assim como a consulta 
     * a reservas feitas para itens desse tipo
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, ParseException {
        Registry sn = LocateRegistry.createRegistry(1099);
        ServImpl eu_Imp = new ServImpl();
        sn.bind("HelloWorld", eu_Imp);

        int opt = 0;
        int opt2 = 0;
        String str;
        int idAux;

        while (opt != 4) {
            System.out.println("\n\n*********************Menu Principal********************\n\n");

            Scanner scan = new Scanner(System.in);
            System.out.println("\nSelecione a opção de seu interesse:\n1-Hoteis\n2-Voos\n3-Pacotes\n4-Sair\n");
            opt = scan.nextInt();
            idAux = 0;
            opt2 = 0;

            if (opt == 1) {
                while (opt2 != 4) {
                    System.out.println("\n\n*********************Menu Hoteis********************\n\n");

                    System.out.println("\nSelecione a opção de seu interesse:\n"
                            + "1-Consultar Hotéis\n"
                            + "2-Adicionar Hotel\n"
                            + "3-Consultar Reservas\n"
                            + "4-Sair\n");
                    opt2 = scan.nextInt();
                    if (opt2 == 1) {
                        System.out.println("\n\n*********************Hoteis Cadastrados********************\n\n");

                        eu_Imp.getHoteisServ();
                    }
                    if (opt2 == 2) {
                        System.out.println("\n\n*********************Menu Adição Hotel********************\n\n");

                        System.out.println("\nInsira o id do hotel\n");
                        int id = scan.nextInt();

                        System.out.println("\nInsira o preco da diaria\n");
                        Scanner scan2 = new Scanner(System.in);
                        int preco = scan2.nextInt();

                        System.out.println("\nInsira o nome do hotel\n");
                        Scanner scan3 = new Scanner(System.in);
                        String nome = scan3.nextLine();

                        System.out.println("\nInsira o local do hotel\n");
                        Scanner scan4 = new Scanner(System.in);
                        String local = scan4.nextLine();

                        System.out.println("\nInsira o numero maximo de pessoas\n");
                        Scanner scan5 = new Scanner(System.in);
                        int pessoas = scan5.nextInt();

                        System.out.println("\nInsira a quantidade de quartos do hotel\n");
                        Scanner scan6 = new Scanner(System.in);
                        int quartos = scan6.nextInt();

                        eu_Imp.addHoteis(id, preco, pessoas, quartos, nome, local);
                    }
                    if (opt2 == 3) {
                        System.out.println("\n\n*********************Menu Reservas Hoteis********************\n\n");

                        eu_Imp.getReservasHoteisServ();
                    }
                    if (opt2 > 4) {
                        System.out.println("\nOpção Invalida!\n");
                    }
                }
            }

            if (opt == 2) {
                while (opt2 != 4) {
                    System.out.println("\n\n*********************Menu Voos********************\n\n");

                    System.out.println("\nSelecione a opção de seu interesse:\n"
                            + "1-Consultar Voos\n"
                            + "2-Adicionar Voo\n"
                            + "3-Consultar Reservas\n"
                            + "4-Sair\n");
                    opt2 = scan.nextInt();
                    if (opt2 == 1) {
                        System.out.println("\n\n*********************Voos Cadastrados********************\n\n");

                        eu_Imp.getVoosServ();
                    }
                    if (opt2 == 2) {
                        System.out.println("\n\n*********************Menu Adição Voos********************\n\n");

                        System.out.println("\nInsira o id do voo\n");
                        idAux = scan.nextInt();

                        System.out.println("\nInsira a quantidade de assentos no voo\n");
                        Scanner scan2 = new Scanner(System.in);
                        int ass = scan2.nextInt();

                        System.out.println("\nInsira o preço do voo\n");
                        Scanner scan3 = new Scanner(System.in);
                        int preco = scan3.nextInt();

                        System.out.println("\nInsira a origem do voo\n");
                        Scanner scan4 = new Scanner(System.in);
                        String origem = scan4.nextLine();

                        System.out.println("\nInsira o destino do voo\n");
                        Scanner scan5 = new Scanner(System.in);
                        String destino = scan5.nextLine();

                        System.out.println("\nInsira a data de saida (dd/MM/yyyy hh:mm:ss)\n");
                        Scanner scan6 = new Scanner(System.in);
                        String dataPart = scan6.nextLine();

                        eu_Imp.addVoo(idAux, ass, preco, origem, destino, dataPart);
                    }
                    if (opt2 == 3) {
                        System.out.println("\n\n*********************Menu Reservas Voos********************\n\n");

                        eu_Imp.getReservasVoosServ();
                    }
                    if (opt2 > 4) {
                        System.out.println("\nOpção Invalida!\n");
                    }
                }
            }

            if (opt == 3) {
                while (opt2 != 4) {
                    System.out.println("\n\n*********************Menu Pacotes********************\n\n");

                    System.out.println("\nSelecione a opção de seu interesse:\n"
                            + "1-Consultar Pacotes\n"
                            + "2-Adicionar Pacote\n"
                            + "3-Consultar Reservas\n"
                            + "4-Sair\n");
                    opt2 = scan.nextInt();
                    if (opt2 == 1) {
                        System.out.println("\n\n*********************Pacotes Cadastrados********************\n\n");

                        eu_Imp.getPacotesServ();
                    }
                    if (opt2 == 2) {
                        System.out.println("\n\n*********************Menu Adição Pacotes********************\n\n");

                        System.out.println("\nInsira o id do pacote\n");
                        idAux = scan.nextInt();

                        System.out.println("\nInsira o id do hotel\n");
                        Scanner scan2 = new Scanner(System.in);
                        int hot = scan2.nextInt();

                        System.out.println("\nInsira o id do voo de ida\n");
                        Scanner scan3 = new Scanner(System.in);
                        int voo1 = scan3.nextInt();

                        System.out.println("\nInsira o id do voo de volta\n");
                        Scanner scan4 = new Scanner(System.in);
                        int voo2 = scan4.nextInt();

                        eu_Imp.addPacote(idAux, hot, voo1, voo2);
                    }
                    if (opt2 == 3) {
                        System.out.println("\n\n*********************Menu Reservas Pacotes********************\n\n");

                        eu_Imp.getReservasPacotesServ();
                    }
                    if (opt2 > 4) {
                        System.out.println("\nOpção Invalida!\n");
                    }
                }
            }
        }
    }

}
