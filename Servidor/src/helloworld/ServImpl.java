package helloworld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Essa é uma classe responsável por implementar os métodos declarados na
 * interface, incluindo as construtora, adições de objetos, consulta de objetos,
 * realização, consulta e deleção de reservas
 *
 * Date: Oct 16-2018
 *
 * @author João Pedro Passos
 * @version 1.0
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServidor {

    /**
     * Vetor do tipo Hoteis reponsável por armazernar todos os hotéis
     * cadastrados no servidor
     */
    Hoteis[] hoteis = new Hoteis[2];
    /**
     * Valor inteiro responsavel por manter uma referência da quantidade de
     * hotéis cadastrados no servidor
     */
    int sizeHoteis = 2;

    /**
     * Vetor do tipo Voo reponsável por armazernar todos os voos cadastrados no
     * servidor
     */
    Voo[] voos = new Voo[2];
    /**
     * Valor inteiro responsavel por manter uma referência da quantidade de voos
     * cadastrados no servidor
     */
    int sizeVoos = 2;

    /**
     * Vetor do tipo Pacote reponsável por armazernar todos os pacotes
     * cadastrados no servidor
     */
    Pacote[] pacotes = new Pacote[1];
    /**
     * Valor inteiro responsavel por manter uma referência da quantidade de
     * pacotes cadastrados no servidor
     */
    int sizePacotes = 1;

    /**
     * Vetor do tipo Reserva reponsável por armazernar todas as reservas de
     * hotéis cadastrados no servidor
     */
    Reserva[] refHoteis;
    /**
     * Valor inteiro responsavel por manter uma referência da quantidade de
     * reservas de hotéis cadastradas no servidor
     */
    int reservaHoteis = 0;
    /**
     * Valor inteiro responsavel por gerar identificadores unicos para as
     * reservas de hotéis cadastradas no servidor
     */
    int countHoteis = 0;

    /**
     * Vetor do tipo Reserva reponsável por armazernar todas as reservas de voos
     * cadastrados no servidor
     */
    Reserva[] refVoos;
    /**
     * Valor inteiro responsavel por manter uma referência da quantidade de
     * reservas de voos cadastradas no servidor
     */
    int reservaVoos = 0;
    /**
     * Valor inteiro responsavel por gerar identificadores unicos para as
     * reservas de voos cadastradas no servidor
     */
    int countVoos = 0;

    /**
     * Vetor do tipo Reserva reponsável por armazernar todas as reservas de
     * pacotes cadastrados no servidor
     */
    Reserva[] refPacotes;
    /**
     * Valor inteiro responsavel por manter uma referência da quantidade de
     * reservas de pacotes cadastradas no servidor
     */
    int reservaPacotes = 0;
    /**
     * Valor inteiro responsavel por gerar identificadores unicos para as
     * reservas de pacotes cadastradas no servidor
     */
    int countPacotes = 0;

    /**
     * Vetor do tipo Compra reponsável por armazernar todas as comprais de
     * hoteis cadastrados no servidor
     */
    Compra[] comprasHoteis;
    /**
     * Valor inteiro responsavel por manter uma referência da quantidade de
     * compras de hoteis cadastradas no servidor
     */
    int tamCompHoteis = 0;

    /**
     * Método construtor responsável por incializar alguns dos objetos dentro do
     * servidor
     *
     * @throws RemoteException
     */
    ServImpl() throws RemoteException {
        hoteis[0] = new Hoteis(1, 120, 75, 130, "El Dorado", "México");
        hoteis[1] = new Hoteis(2, 200, 120, 210, "Tipton", "Manhatan");

        voos[0] = new Voo(7060, 160, 200, "Brazil", "México", "02/04/2019");
        voos[1] = new Voo(7074, 120, 210, "México", "Brazil", "07/04/2019");

        pacotes[0] = new Pacote(1, hoteis[0], voos[0], voos[1]);
    }

    /**
     * Método responsavel por imprimir no terminal do servidor informações
     * referentes aos hoteis cadastrados
     *
     * @throws RemoteException
     */
    public void getHoteisServ() throws RemoteException {
        String str;
        for (int i = 0; i < sizeHoteis; i++) {
            str = "\nId: " + hoteis[i].id
                    + "\nNome: " + hoteis[i].nome
                    + "\nLocal: " + hoteis[i].local
                    + "\nQuantidade de Quartos: " + hoteis[i].quartos
                    + "\nCapacidade de Pessoas: " + hoteis[i].pessoas
                    + "\nPreço por Quarto: " + hoteis[i].preco
                    + "\n";
            System.out.println(str);
        }
    }

    /**
     * Método responsavel por imprimir no terminal do servidor informações
     * referentes aos voos cadastrados
     *
     * @throws RemoteException
     */
    public void getVoosServ() throws RemoteException {
        String str;
        for (int i = 0; i < sizeVoos; i++) {
            str = "\nId: " + voos[i].id
                    + "\nOrigem: " + voos[i].origem
                    + "\nDestino: " + voos[i].destino
                    + "\nAssentos Disponiveis: " + voos[i].assentos
                    + "\nPreço por Passagem: " + voos[i].preco
                    + "\n";
            System.out.println(str);
        }
    }

    /**
     * Método responsavel por imprimir no terminal do servidor informações
     * referentes aos pacotes cadastrados
     *
     * @throws RemoteException
     */
    public void getPacotesServ() throws RemoteException {
        String str;
        for (int i = 0; i < sizePacotes; i++) {
            str = "\n\nPacote"
                    + "\nId Pacote: " + pacotes[i].id
                    + "\n\nVoo Ida"
                    + "\nId Voo Ida" + pacotes[i].ida.id
                    + "\nOrigem Voo Ida: " + pacotes[i].ida.origem
                    + "\nDestino Voo Ida: " + pacotes[i].ida.destino
                    + "\nAssentos Disponiveis Ida: " + pacotes[i].ida.destino
                    + "\nPreço por Passagem: " + pacotes[i].ida.preco
                    + "\n\nVoo Volta"
                    + "\nId Voo Volta" + pacotes[i].ida.id
                    + "\nOrigem Voo Volta: " + pacotes[i].ida.origem
                    + "\nDestino Voo Volta: " + pacotes[i].ida.destino
                    + "\nAssentos Disponiveis Volta: " + pacotes[i].ida.destino
                    + "\nPreço por Passagem: " + pacotes[i].ida.preco
                    + "\n\nHotel"
                    + "\nId Hotel: " + pacotes[i].hotel.id
                    + "\nNome Hotel: " + pacotes[i].hotel.nome
                    + "\nLocal Hotel: " + pacotes[i].hotel.local
                    + "\nQuantidade de Quartos: " + pacotes[i].hotel.quartos
                    + "\nCapacidade de Pessoas: " + pacotes[i].hotel.pessoas
                    + "\nPreço por Quarto: " + pacotes[i].hotel.preco
                    + "\n";
            System.out.println(str);
        }
    }

    /**
     * Método responsavel por imprimir no terminal do cliente informações
     * referentes aos hoteis cadastrados
     *
     * @param ref_Cli referência do cliente que chama o método
     * @throws RemoteException
     */
    public void getHoteis(InterfaceCliente ref_Cli) throws RemoteException {
        String str;
        for (int i = 0; i < sizeHoteis; i++) {
            str = "Id: " + hoteis[i].id
                    + "\nNome: " + hoteis[i].nome
                    + "\nLocal: " + hoteis[i].local
                    + "\nQuantidade de Quartos: " + hoteis[i].quartos
                    + "\nCapacidade de Pessoas: " + hoteis[i].pessoas
                    + "\nPreço por Quarto: " + hoteis[i].preco
                    + "\n";
            ref_Cli.echo(str);
        }
    }

    /**
     * Método responsavel por imprimir no terminal do cliente informações
     * referentes aos voos cadastrados
     *
     * @param ref_Cli referência do cliente que chama o método
     * @throws RemoteException
     */
    public void getVoos(InterfaceCliente ref_Cli) throws RemoteException {
        String str;
        for (int i = 0; i < sizeHoteis; i++) {
            str = "\nId: " + voos[i].id
                    + "\nOrigem: " + voos[i].origem
                    + "\nDestino: " + voos[i].destino
                    + "\nData: " + voos[i].partida
                    + "\nAssentos Disponiveis: " + voos[i].assentos
                    + "\nPreço por Passagem: " + voos[i].preco
                    + "\n";
            ref_Cli.echo(str);
        }
    }

    /**
     * Método responsavel por imprimir no terminal do cliente informações
     * referentes aos pacotes cadastrados
     *
     * @param ref_Cli referência do cliente que chama o método
     * @throws RemoteException
     */
    public void getPacotes(InterfaceCliente ref_Cli) throws RemoteException {
        String str;
        for (int i = 0; i < sizePacotes; i++) {
            str = "\n\nPacote"
                    + "\nId Pacote: " + pacotes[i].id
                    + "\n\nVoo Ida"
                    + "\nId Voo Ida" + pacotes[i].ida.id
                    + "\nOrigem Voo Ida: " + pacotes[i].ida.origem
                    + "\nDestino Voo Ida: " + pacotes[i].ida.destino
                    + "\nData Voo Ida: " + pacotes[i].ida.partida
                    + "\nAssentos Disponiveis Ida: " + pacotes[i].ida.destino
                    + "\nPreço por Passagem: " + pacotes[i].ida.preco
                    + "\n\nVoo Volta"
                    + "\nId Voo Volta" + pacotes[i].volta.id
                    + "\nOrigem Voo Volta: " + pacotes[i].volta.origem
                    + "\nDestino Voo Volta: " + pacotes[i].volta.destino
                    + "\nData Voo Volta: " + pacotes[i].volta.partida
                    + "\nAssentos Disponiveis Volta: " + pacotes[i].volta.destino
                    + "\nPreço por Passagem: " + pacotes[i].volta.preco
                    + "\n\nHotel"
                    + "\nId Hotel: " + pacotes[i].hotel.id
                    + "\nNome Hotel: " + pacotes[i].hotel.nome
                    + "\nLocal Hotel: " + pacotes[i].hotel.local
                    + "\nQuantidade de Quartos: " + pacotes[i].hotel.quartos
                    + "\nCapacidade de Pessoas: " + pacotes[i].hotel.pessoas
                    + "\nPreço por Quarto: " + pacotes[i].hotel.preco
                    + "\n";
            ref_Cli.echo(str);
        }
    }

    /**
     * Cadastra um hotel com as informações passadas ao servidor e notifica os clientes que criaram uma reserva que se encaixe nestes parametros
     *
     * @param idAux id do hotel
     * @param preco preço por quarto do hotel
     * @param pessoas capacidade de pessoas do hotel
     * @param quartos quantidade de quartos do hotel
     * @param nome nome do hotel
     * @param local localização do hotel
     * @throws RemoteException
     */
    public void addHoteis(int idAux, int preco, int pessoas, int quartos, String nome, String local) throws RemoteException {
        Hoteis[] aux = new Hoteis[sizeHoteis];
        String str;

        for (int i = 0; i < sizeHoteis; i++) {
            aux[i] = hoteis[i];
        }
        sizeHoteis++;

        hoteis = new Hoteis[sizeHoteis];

        for (int i = 0; i < sizeHoteis - 1; i++) {
            hoteis[i] = aux[i];
        }

        hoteis[sizeHoteis - 1] = new Hoteis(idAux, preco, pessoas, quartos, nome, local);

        System.out.println("\nHotel adicionado com sucesso\n");

        for (int i = 0; i < reservaHoteis; i++) {
            if (refHoteis[i].hotel.local.equals(hoteis[sizeHoteis - 1].local)
                    && refHoteis[i].hotel.preco > preco) {
                str = "O hotel " + hoteis[sizeHoteis - 1].nome + " foi adicionado à base de dados na localização " + hoteis[sizeHoteis - 1].local + " com id " + hoteis[sizeHoteis - 1].id;
                refHoteis[i].ic.echo(str);
            }
        }
    }

    /**
     * Cadastra um voo com as informações passadas ao servidor e notifica os clientes que criaram uma reserva que se encaixe nestes parametros
     *
     * @param idAux id do voo
     * @param assentos quantidade de assentos disponiveis
     * @param preco preco por passagem
     * @param origem local de partida
     * @param destino local de chegada
     * @param saida data de partida
     * @throws RemoteException
     * @throws ParseException
     */
    public void addVoo(int idAux, int assentos, int preco, String origem, String destino, String saida) throws RemoteException, ParseException {
        Voo[] aux = new Voo[sizeVoos];
        String str;

        for (int i = 0; i < sizeVoos; i++) {
            aux[i] = voos[i];
        }
        sizeVoos++;

        voos = new Voo[sizeVoos];

        for (int i = 0; i < sizeVoos - 1; i++) {
            voos[i] = aux[i];
        }

        System.out.println("\nVoo adicionado com sucesso\n");

        voos[sizeVoos - 1] = new Voo(idAux, assentos, preco, origem, destino, saida);

        for (int i = 0; i < reservaVoos; i++) {
            if (refVoos[i].voo.origem.equals(voos[sizeVoos - 1].origem)
                    && refVoos[i].voo.destino.equals(voos[sizeVoos - 1].destino)
                    && refVoos[i].voo.preco < preco) {
                str = "Um voo com origem " + voos[sizeVoos - 1].origem + " e destino " + voos[sizeVoos - 1].destino + " foi adicionado à base de dados com id " + voos[sizeVoos - 1].id;
                refVoos[i].ic.echo(str);
            }
        }
    }

    /**
     * Cadastra um pacote com as informações passadas ao servidor e notifica os clientes que criaram uma reserva que se encaixe nestes parametros
     *
     * @param idAux id do pacote
     * @param idHotel id do hotel
     * @param idVoo1 id do voo de ida
     * @param idVoo2 id do voo de volta
     * @throws RemoteException
     * @throws ParseException
     */
    public void addPacote(int idAux, int idHotel, int idVoo1, int idVoo2) throws RemoteException, ParseException {
        Pacote[] aux = new Pacote[sizePacotes];
        String str;
        Voo aux1 = null, aux2 = null;
        Hoteis hot = null;
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        for (int i = 0; i < sizeHoteis; i++) {
            if (idHotel == hoteis[i].id) {
                hot = new Hoteis(hoteis[i].id, hoteis[i].preco, hoteis[i].pessoas, hoteis[i].quartos, hoteis[i].nome, hoteis[i].local);
                break;
            }
        }
        for (int i = 0; i < sizeVoos; i++) {
            if (idVoo1 == voos[i].id) {
                aux1 = new Voo(voos[i].id, voos[i].assentos, voos[i].preco, voos[i].origem, voos[i].destino, sf.format(voos[i].partida));
                break;
            }
            if (idVoo2 == voos[i].id) {
                aux2 = new Voo(voos[i].id, voos[i].assentos, voos[i].preco, voos[i].origem, voos[i].destino, sf.format(voos[i].partida));
                break;
            }
        }
        for (int i = 0; i < sizePacotes; i++) {
            aux[i] = pacotes[i];
        }

        sizePacotes++;

        pacotes = new Pacote[sizePacotes];

        for (int i = 0; i < sizePacotes - 1; i++) {
            pacotes[i] = aux[i];
        }

        pacotes[sizePacotes - 1] = new Pacote(idAux, hot, aux1, aux2);

        System.out.println("\nPacote adicionado com sucesso\n");

        for (int i = 0; i < reservaPacotes; i++) {
            if (refPacotes[i].pac.ida.origem.equals(pacotes[sizePacotes - 1].ida.origem)
                    && refPacotes[i].pac.ida.destino.equals(pacotes[sizePacotes - 1].ida.destino)
                    && refPacotes[i].pac.hotel.local.equals(pacotes[sizePacotes - 1].hotel.local)
                    && refPacotes[i].pac.preco < pacotes[sizePacotes - 1].preco) {
                str = "Um Pacote com origem " + pacotes[sizePacotes - 1].ida.origem + ", destino " + pacotes[sizePacotes - 1].ida.destino + " e hotel de nome " + pacotes[sizePacotes - 1].hotel.nome + " foi adicionado à base de dados com id " + pacotes[sizePacotes - 1].id;
                refPacotes[i].ic.echo(str);
            }
        }
    }

    /**
     * Imprime no terminal do servidor as reservas de hotel existentes 
     *
     * @throws RemoteException
     */
    public void getReservasHoteisServ() throws RemoteException {
        int ver1 = 0;
        for (int i = 0; i < reservaHoteis; i++) {
            System.out.println("id reserva: " + refHoteis[i].id
                    + "\nLocal: " + refHoteis[i].hotel.local
                    + "\nPreço Máximo: " + refHoteis[i].hotel.preco
                    + "\n");
            ver1 = 1;
        }
        if (ver1 == 0) {
            System.out.println("Não há nehuma\n");
        }
    }

    /**
     * Imprime no terminal do servidor as reservas de voos existentes
     *
     * @throws RemoteException
     */
    public void getReservasVoosServ() throws RemoteException {
        int ver2 = 0;
        System.out.println("Rervas De Voo\n");
        for (int i = 0; i < reservaVoos; i++) {
            System.out.println("id reserva: " + refVoos[i].id
                    + "\nPreco Máximo: " + refVoos[i].voo.preco
                    + "\nOrigem: " + refVoos[i].voo.origem
                    + "\nDestino: " + refVoos[i].voo.destino);
            ver2 = 1;
        }
        if (ver2 == 0) {
            System.out.println("Não há nehuma");
        }
    }

    /**
     * Imprime no terminal do servidor as reservas de pacotes existentes
     *
     * @throws RemoteException
     */
    public void getReservasPacotesServ() throws RemoteException {
        int ver3 = 0;
        System.out.println("Rervas De Pacote\n");
        for (int i = 0; i < reservaHoteis; i++) {
            System.out.println("id reserva: " + refPacotes[i].id
                    + "\nOrigem: " + refPacotes[i].pac.ida.origem
                    + "\nDestino: " + refPacotes[i].pac.ida.destino
                    + "\nPreço: " + refPacotes[i].pac.ida.preco);
            ver3 = 1;
        }
        if (ver3 == 0) {
            System.out.println("Não há nehuma");
        }
    }

    /**
     * Imprime no terminal do cliente as reservas de hoteis existentes
     *
     * @param ref_Cli referência do cliente
     * @throws RemoteException
     */
    public void getReservasHoteis(InterfaceCliente ref_Cli) throws RemoteException {
        int ver1 = 0;
        for (int i = 0; i < reservaHoteis; i++) {
            if (ref_Cli.verificarReservaHotel(refHoteis[i].id) == 1) {
                String str = "id reserva: " + refHoteis[i].id
                        + "\nLocal: " + refHoteis[i].hotel.local
                        + "\nPreço Máximo: " + refHoteis[i].hotel.preco
                        + "\n";
                ref_Cli.echo(str);
                ver1 = 1;
            }
        }
        if (ver1 == 0) {
            ref_Cli.echo("Não há nehuma");
        }
    }

    /**
     * Imprime no terminal do cliente as reservas de voos existentes
     *
     * @param ref_Cli referência do cliente
     * @throws RemoteException
     */
    public void getReservasVoos(InterfaceCliente ref_Cli) throws RemoteException {
        int ver2 = 0;
        System.out.println("Rervas De Voo\n");
        for (int i = 0; i < reservaVoos; i++) {
            if (ref_Cli.verificarReservaVoo(refVoos[i].id) == 1) {
                String str = "id reserva: " + refVoos[i].id
                        + "\nPreco Máximo: " + refVoos[i].voo.preco
                        + "\nOrigem: " + refVoos[i].voo.origem
                        + "\nDestino: " + refVoos[i].voo.destino;
                ref_Cli.echo(str);
                ver2 = 1;
            }
        }
        if (ver2 == 0) {
            ref_Cli.echo("Não há nehuma");
        }
    }

    /**
     * Imprime no terminal do cliente as reservas de pacotes existentes
     *
     * @param ref_Cli referência do cliente
     * @throws RemoteException
     */
    public void getReservasPacotes(InterfaceCliente ref_Cli) throws RemoteException {
        int ver3 = 0;
        System.out.println("Rervas De Pacote\n");
        for (int i = 0; i < reservaHoteis; i++) {
            if (ref_Cli.verificarReservaPacote(refPacotes[i].id) == 1) {
                String str = "id reserva: " + refPacotes[i].id
                        + "\nOrigem: " + refPacotes[i].pac.ida.origem
                        + "\nDestino: " + refPacotes[i].pac.ida.destino
                        + "\nPreço: " + refPacotes[i].pac.ida.preco;
                ref_Cli.echo(str);
                ver3 = 1;
            }
        }
        if (ver3 == 0) {
            ref_Cli.echo("Não há nehuma");
        }
    }

    /**
     * Exclui a reserva de hotel com o id passado
     *
     * @param ref_Cli referência cliente
     * @param id id da reserva a ser excluida
     * @throws RemoteException
     */
    public void cancelarReservasHoteis(InterfaceCliente ref_Cli, int id) throws RemoteException {
        int ver1 = 0;
        int j2 = 0;
        Reserva[] aux = new Reserva[reservaHoteis - 1];
        for (int i = 0; i < reservaHoteis; i++) {
            if (refHoteis[i].id == id && ref_Cli.verificarReservaHotel(id) == 1) {
                ver1 = 1;
            }
        }
        if (ver1 == 0) {
            ref_Cli.echo("Id de reserva não encontrado");
        }
        if (ver1 == 1) {
            for (int j1 = 0; j1 < reservaHoteis; j1++) {
                if (refHoteis[j1].id != id) {
                    aux[j2] = refHoteis[j1];
                    j2++;
                }
            }
            reservaHoteis--;
            refHoteis = new Reserva[reservaHoteis];
            for (int j = 0; j < reservaHoteis; j++) {
                refHoteis[j] = aux[j];
            }

            ref_Cli.cancelarReservaHotel(id);
            ref_Cli.echo("Reserva Cancelada com Sucesso");
        }
    }

    /**
     * Exclui a reserva de voo com o id passado
     *
     * @param ref_Cli referência cliente
     * @param id id da reserva a ser excluida
     * @throws RemoteException
     */
    public void cancelarReservasVoos(InterfaceCliente ref_Cli, int id) throws RemoteException {
        int ver1 = 0;
        int j2 = 0;
        Reserva[] aux = new Reserva[reservaVoos - 1];
        for (int i = 0; i < reservaVoos; i++) {
            if (refVoos[i].id == id && ref_Cli.verificarReservaVoo(id) == 1) {
                ver1 = 1;
            }
        }
        if (ver1 == 0) {
            ref_Cli.echo("Id de reserva não encontrado");
        }
        if (ver1 == 1) {
            for (int j1 = 0; j1 < reservaVoos; j1++) {
                if (refVoos[j1].id != id) {
                    aux[j2] = refVoos[j1];
                    j2++;
                }
            }
            reservaVoos--;
            refVoos = new Reserva[reservaVoos];
            for (int j = 0; j < reservaVoos; j++) {
                refVoos[j] = aux[j];
            }
            ref_Cli.cancelarReservaVoo(id);
            ref_Cli.echo("Reserva Cancelada com Sucesso");
        }
    }

    /**
     * Exclui a reserva de pacote com o id passado
     *
     * @param ref_Cli referência cliente
     * @param id id da reserva a ser excluida
     * @throws RemoteException
     */
    public void cancelarReservasPacotes(InterfaceCliente ref_Cli, int id) throws RemoteException {
        int ver1 = 0;
        int j2 = 0;
        Reserva[] aux = new Reserva[reservaPacotes - 1];
        for (int i = 0; i < reservaPacotes; i++) {
            if (refPacotes[i].id == id && ref_Cli.verificarReservaVoo(id) == 1) {
                ver1 = 1;
            }
        }
        if (ver1 == 0) {
            ref_Cli.echo("Id de reserva não encontrado");
        }
        if (ver1 == 1) {
            for (int j1 = 0; j1 < reservaPacotes; j1++) {
                if (refPacotes[j1].id != id) {
                    aux[j2] = refPacotes[j1];
                    j2++;
                }
            }
            reservaPacotes--;
            refPacotes = new Reserva[reservaPacotes];
            for (int j = 0; j < reservaPacotes; j++) {
                refPacotes[j] = aux[j];
            }
            ref_Cli.cancelarReservaPacote(id);
            ref_Cli.echo("Reserva Cancelada com Sucesso");
        }
    }
    
    /**
     * Cria uma entrada de reserva para hoteis a ser notificada
     * 
     * @param ref_Cli referência cliente
     * @param local local onde procurasse o hotel
     * @param preco preco maximo a pagar por quarto
     * @throws RemoteException 
     */
    public synchronized void reservaHoteis(InterfaceCliente ref_Cli, String local, int preco) throws RemoteException {
        Reserva[] res = new Reserva[reservaHoteis];

        Hoteis hot = new Hoteis(0, preco, 0, 0, null, local);

        for (int i = 0; i < reservaHoteis; i++) {
            res[i] = refHoteis[i];
        }
        reservaHoteis++;

        refHoteis = new Reserva[reservaHoteis];

        for (int i = 0; i < reservaHoteis - 1; i++) {
            refHoteis[i] = res[i];
        }

        int id = countHoteis;
        countHoteis++;

        ref_Cli.ReservarHotel(id);

        refHoteis[reservaHoteis - 1] = new Reserva(id, hot, null, null, ref_Cli);

        String str = "A Reserva foi realizada com sucesso e possui id " + id;

        ref_Cli.echo(str);
    }
    
    /**
     * Cria uma entrada de reserva para voos a ser notificada
     * 
     * @param ref_Cli referência cliente
     * @param origem local de origem
     * @param destino local de destino
     * @param preco preço máximo a papgar por passagem
     * @throws RemoteException 
     */
    public synchronized void reservaVoo(InterfaceCliente ref_Cli, String origem, String destino, int preco) throws RemoteException {
        Reserva[] res = new Reserva[reservaHoteis];

        Voo v = new Voo(0, 0, 0, origem, destino, null);

        for (int i = 0; i < reservaVoos; i++) {
            res[i] = refVoos[i];
        }
        reservaVoos++;

        refVoos = new Reserva[reservaVoos];

        for (int i = 0; i < reservaVoos - 1; i++) {
            refVoos[i] = res[i];
        }

        int id = countVoos++;
        countVoos++;

        ref_Cli.ReservarPacote(id);

        refVoos[reservaVoos - 1] = new Reserva(id, null, v, null, ref_Cli);

        String str = "A Reserva foi realizada com sucesso e possui id " + id;

        ref_Cli.echo(str);
    }
    
    /**
     * Cria uma entrada de reserva para pacotes a ser notificada
     * 
     * @param ref_Cli referência cliente
     * @param origem local de origem
     * @param destino local de destino
     * @param preco preço máximo a pagar pelo pacote
     * @throws RemoteException 
     */
    public synchronized void reservaPacote(InterfaceCliente ref_Cli, String origem, String destino, int preco) throws RemoteException {
        Reserva[] res = new Reserva[reservaHoteis];

        Voo ida = new Voo(0, 0, 0, origem, destino, null);

        Voo volta = new Voo(0, 0, 0, destino, origem, null);

        Hoteis hot = new Hoteis(0, preco, 0, 0, null, destino);

        Pacote pac = new Pacote(0, hot, ida, volta);

        for (int i = 0; i < reservaPacotes; i++) {
            res[i] = refPacotes[i];
        }
        reservaPacotes++;

        refPacotes = new Reserva[reservaPacotes];

        for (int i = 0; i < reservaPacotes - 1; i++) {
            refPacotes[i] = res[i];
        }

        int id = countPacotes;
        countPacotes++;

        ref_Cli.ReservarPacote(id);

        refPacotes[reservaPacotes - 1] = new Reserva(id, null, null, pac, ref_Cli);

        String str = "A Reserva foi realizada com sucesso e possui id " + id;

        ref_Cli.echo(str);
    }
    
    /**
     * Cria uma entrada de no vetor de compras de hotel
     * 
     * @param ref_Cli referência cliente
     * @param opt opção de procura por nome ou localidade
     * @param preco preço máximo a pagar por quarto
     * @param pessoas quantidade de pessoas a ser hospedadas
     * @param quartos quantidade de quartos desejados
     * @param entrada data de entrada
     * @param saida data de saida
     * @param nome nome do hotel
     * @param local localização do hotel
     * @throws RemoteException 
     */
    public synchronized void comprarHoteis(InterfaceCliente ref_Cli, int opt, int preco, int pessoas, int quartos, String entrada, String saida, String nome, String local) throws RemoteException {
        Date chegada = null, partida = null;
        int contP = 0, contQ = 0, idHotel = 0;
        String str;
        int ver1 = 0, ver2 = 0;

        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            chegada = dateformat.parse(entrada);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            partida = dateformat.parse(saida);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (opt == 1) {
            for (int i = 0; i < sizeHoteis; i++) {
                if (hoteis[i].nome.equals(nome)
                        && hoteis[i].preco <= preco) {
                    ver1 = 1;
                    idHotel = i;
                    contP = pessoas;
                    contQ = quartos;
                    for (int j = 0; j < tamCompHoteis; j++) {
                        if (comprasHoteis[j].id == hoteis[i].id
                                && ((comprasHoteis[j].entrada.compareTo(chegada) <= 0
                                && comprasHoteis[j].saida.compareTo(chegada) >= 0)
                                || (comprasHoteis[j].entrada.compareTo(partida) <= 0
                                && comprasHoteis[j].saida.compareTo(partida) >= 0)
                                || (comprasHoteis[j].entrada.compareTo(chegada) >= 0
                                && comprasHoteis[j].saida.compareTo(partida) <= 0))) {
                            contP += comprasHoteis[i].p;
                            contQ += comprasHoteis[i].q;
                        }
                    }
                }
            }
            if (ver1 == 1) {
                if (contP <= hoteis[idHotel].pessoas && contQ <= hoteis[idHotel].pessoas) {
                    Compra[] aux = new Compra[tamCompHoteis];

                    for (int i = 0; i < tamCompHoteis; i++) {
                        aux[i] = comprasHoteis[i];
                    }
                    tamCompHoteis++;
                    comprasHoteis = new Compra[tamCompHoteis];
                    for (int i = 0; i < tamCompHoteis - 1; i++) {
                        comprasHoteis[i] = aux[i];
                    }
                    comprasHoteis[tamCompHoteis - 1] = new Compra(entrada, saida, ref_Cli);

                    str = "Uma compra foi realizada por " + quartos
                            + " quartos para " + pessoas
                            + " no hotel " + hoteis[idHotel].nome
                            + " em " + hoteis[idHotel].local
                            + " com entrada " + entrada
                            + " e saida " + saida;

                    ref_Cli.echo(str);
                } else if (contP > hoteis[idHotel].pessoas && contQ < hoteis[idHotel].pessoas) {
                    str = "A quantidade de pessoas definida não pode ocupar o estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                } else if (contP < hoteis[idHotel].pessoas && contQ > hoteis[idHotel].pessoas) {
                    str = "A quantidade de quartos definida não pode ser ocupada noo estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                }
                if (contP > hoteis[idHotel].pessoas && contQ > hoteis[idHotel].pessoas) {
                    str = "A quantidade de quartos e pessoas definida não podem ocupadar o estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                }
            } else if (ver1 == 0) {
                str = "O nome e precos informados não puderam ser encontrados na base de dados, verifique a grafia e/ou a lista de estabelecimentos mais uma vez";
                ref_Cli.echo(str);
            }
        }

        if (opt == 2) {
            for (int i = 0; i < sizeHoteis; i++) {
                if (hoteis[i].local.equals(local)
                        && hoteis[i].preco <= preco) {
                    idHotel = i;
                    contP = pessoas;
                    contQ = quartos;
                    for (int j = 0; j < tamCompHoteis; j++) {
                        if (comprasHoteis[j].id == hoteis[i].id
                                && ((comprasHoteis[j].entrada.compareTo(chegada) <= 0
                                && comprasHoteis[j].saida.compareTo(chegada) >= 0)
                                || (comprasHoteis[j].entrada.compareTo(partida) <= 0
                                && comprasHoteis[j].saida.compareTo(partida) >= 0)
                                || (comprasHoteis[j].entrada.compareTo(chegada) >= 0
                                && comprasHoteis[j].saida.compareTo(partida) <= 0))) {
                            contP += comprasHoteis[i].p;
                            contQ += comprasHoteis[i].q;
                        }
                    }
                    if (contP <= hoteis[idHotel].pessoas && contQ <= hoteis[idHotel].pessoas) {
                        ver1 = 1;
                        break;
                    }
                }
            }
            if (ver1 == 1) {
                if (contP <= hoteis[idHotel].pessoas && contQ <= hoteis[idHotel].pessoas) {
                    Compra[] aux = new Compra[tamCompHoteis];

                    for (int i = 0; i < tamCompHoteis; i++) {
                        aux[i] = comprasHoteis[i];
                    }
                    tamCompHoteis++;
                    comprasHoteis = new Compra[tamCompHoteis];
                    for (int i = 0; i < tamCompHoteis - 1; i++) {
                        comprasHoteis[i] = aux[i];
                    }
                    comprasHoteis[tamCompHoteis - 1] = new Compra(entrada, saida, ref_Cli);

                    str = "Uma compra foi realizada por " + quartos
                            + " quartos para " + pessoas
                            + " no hotel " + hoteis[idHotel].nome
                            + " em " + hoteis[idHotel].local
                            + " com entrada " + entrada
                            + " e saida " + saida;

                    ref_Cli.echo(str);
                } else if (contP > hoteis[idHotel].pessoas && contQ < hoteis[idHotel].pessoas) {
                    str = "A quantidade de pessoas definida não pode ocupar o estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                } else if (contP < hoteis[idHotel].pessoas && contQ > hoteis[idHotel].pessoas) {
                    str = "A quantidade de quartos definida não pode ser ocupada noo estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                }
                if (contP > hoteis[idHotel].pessoas && contQ > hoteis[idHotel].pessoas) {
                    str = "A quantidade de quartos e pessoas definida não podem ocupadar o estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                }
            } else if (ver1 == 0) {
                str = "O nome informado não pode ser encontrado na base de dados, verifique a grafia e/ou a lista de estabelecimentos mais uma vez";
                ref_Cli.echo(str);
            }
        }
    }
    
    /**
     * Realiza uma compra de passagen(s) aérea(s) decrementando a qauntidade de assentos no voo encontrado
     * 
     * @param ref_Cli referência cliente
     * @param opt opção de compra de ida ou ida e volta
     * @param qtde quantidade de passagens
     * @param preco preço máximo a pagar por passagem
     * @param destino local de destino
     * @param origem local de origem
     * @param part data de partida
     * @param cheg data de retorno
     * @throws RemoteException 
     */
    public synchronized void comprarVoos(InterfaceCliente ref_Cli, int opt, int qtde, int preco, String destino, String origem, String part, String cheg) throws RemoteException {
        Date partida = null, chegada = null;
        int idIda = 0, idVolta = 0;
        String str;
        int ver1 = 0, ver2 = 0;

        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            partida = dateformat.parse(part);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (opt == 1) {
            for (int i = 0; i < sizeVoos; i++) {
                if (voos[i].assentos >= qtde
                        && voos[i].origem.equals(origem)
                        && voos[i].destino.equals(destino)
                        && voos[i].partida.after(partida)
                        && voos[i].preco < preco) {
                    ver1 = 1;
                    voos[i].compraAssentos(qtde);
                    str = "\nForam comprados " + qtde
                            + " pasagens no voo de id " + voos[i].id
                            + " com destino " + voos[i].destino
                            + " e origem " + voos[i].origem
                            + "\n";
                    ref_Cli.echo(str);
                    break;
                }
            }
            if (ver1 == 0) {
                str = "Não foi encontrado um voo segundo as especificações descritas, favor consultar os voos disponiveis e tentar novamente";
                ref_Cli.echo(str);
            }
        }

        if (opt == 2) {
            for (int i = 0; i < sizeVoos; i++) {
                if (voos[i].assentos >= qtde
                        && voos[i].origem.equals(origem)
                        && voos[i].destino.equals(destino)
                        && voos[i].partida.after(partida)
                        && voos[i].preco < preco) {
                    ver1 = 1;
                    idIda = i;
                    break;
                }
            }

            try {
                chegada = dateformat.parse(cheg);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < sizeVoos; i++) {
                if (voos[i].assentos >= qtde
                        && voos[i].origem.equals(destino)
                        && voos[i].destino.equals(origem)
                        && voos[i].partida.after(chegada)
                        && voos[i].preco < preco) {
                    ver2 = 1;
                    idVolta = i;
                    break;
                }
            }

            if (ver1 == 0 && ver2 == 0) {
                str = "Não foram encontrados voos segundo as especificações descritas, favor consultar os voos disponiveis e tentar novamente";
                ref_Cli.echo(str);
            }

            if (ver1 == 1 && ver2 == 0) {
                str = "Um voo de volta não foi encontrado um voo de volta segundo as especificações descritas, favor consultar os voos disponiveis e tentar novamente";
                ref_Cli.echo(str);
            }

            if (ver1 == 0 && ver2 == 1) {
                str = "Um voo de ida não foi encontrado um voo de volta segundo as especificações descritas, favor consultar os voos disponiveis e tentar novamente";
                ref_Cli.echo(str);
            }

            if (ver1 == 1 && ver2 == 1) {
                voos[idIda].compraAssentos(qtde);
                voos[idVolta].compraAssentos(qtde);
                str = "\nForam comprados " + qtde
                        + " pasagens no voo de ida de id " + voos[idIda].id
                        + " com destino " + voos[idIda].destino
                        + " e origem " + voos[idIda].origem
                        + " assim como " + qtde
                        + " pasagens no voo de volta id " + voos[idVolta].id
                        + " com destino " + voos[idVolta].origem
                        + " e origem " + voos[idVolta].destino
                        + "\n";
                ref_Cli.echo(str);
            }
        }
    }
    
    /**
     * Realiza os processos de compras de passagens e de estadia nos voos e hoteis indicados no pacote encontrado
     * 
     * @param ref_Cli referência cliente
     * @param opt opção por busca com nome ou sem
     * @param preco preço máximo a pagar pelo pacote
     * @param pessoas quantidade de pessoas que iram necessitar do pacote
     * @param quartos quantidade de quartos desejado
     * @param destino local de destino
     * @param origem local de origem
     * @param part data de partida
     * @param cheg data de retorno
     * @param nome nome do hotel
     * @throws RemoteException 
     */
    public synchronized void comprarPacotes(InterfaceCliente ref_Cli, int opt, int preco, int pessoas, int quartos, String destino, String origem, String part, String cheg, String nome) throws RemoteException {
        Date partida = null, chegada = null;
        int idPacote = 0;
        int contP = 0, contQ = 0;
        String str;
        int ver1 = 0, ver2 = 0, ver3 = 0;

        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            partida = dateformat.parse(part);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            chegada = dateformat.parse(cheg);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (opt == 1) {
            for (int i = 0; i < sizePacotes; i++) {
                if (pacotes[i].preco <= preco
                        && pacotes[i].hotel.nome.equals(nome)
                        && pacotes[i].hotel.local.equals(destino)
                        && pacotes[i].ida.assentos - pessoas >= 0
                        && pacotes[i].volta.assentos - pessoas >= 0
                        && pacotes[i].ida.origem.equals(origem)
                        && pacotes[i].ida.destino.equals(destino)
                        && pacotes[i].volta.origem.equals(destino)
                        && pacotes[i].volta.destino.equals(origem)
                        && pacotes[i].ida.partida.compareTo(partida) >= 0
                        && pacotes[i].volta.partida.compareTo(chegada) >= 0) {
                    idPacote = i;
                    contP = pessoas;
                    contQ = quartos;
                    for (int j = 0; j < tamCompHoteis; j++) {
                        if (comprasHoteis[j].id == pacotes[i].hotel.id
                                && ((comprasHoteis[j].entrada.compareTo(chegada) <= 0
                                && comprasHoteis[j].saida.compareTo(chegada) >= 0)
                                || (comprasHoteis[j].entrada.compareTo(partida) <= 0
                                && comprasHoteis[j].saida.compareTo(partida) >= 0)
                                || (comprasHoteis[j].entrada.compareTo(chegada) >= 0
                                && comprasHoteis[j].saida.compareTo(partida) <= 0))) {
                            contP += comprasHoteis[i].p;
                            contQ += comprasHoteis[i].q;
                        }
                    }
                    if (contP <= pacotes[idPacote].hotel.pessoas && contQ <= pacotes[idPacote].hotel.pessoas) {
                        ver1 = 1;
                        break;
                    }
                }
            }
            if (ver1 == 1) {
                if (contP <= pacotes[idPacote].hotel.pessoas && contQ <= pacotes[idPacote].hotel.pessoas) {
                    pacotes[idPacote].ida.compraAssentos(pessoas);
                    pacotes[idPacote].volta.compraAssentos(pessoas);
                    Compra[] aux = new Compra[tamCompHoteis];

                    for (int i = 0; i < tamCompHoteis; i++) {
                        aux[i] = comprasHoteis[i];
                    }
                    tamCompHoteis++;
                    comprasHoteis = new Compra[tamCompHoteis];
                    for (int i = 0; i < tamCompHoteis - 1; i++) {
                        comprasHoteis[i] = aux[i];
                    }
                    comprasHoteis[tamCompHoteis - 1] = new Compra(part, cheg, ref_Cli);

                    str = "Uma compra foi realizada por " + pessoas
                            + " assentos nos voos " + pacotes[idPacote].ida.id
                            + " com origem " + pacotes[idPacote].ida.origem
                            + " e destino " + pacotes[idPacote].ida.destino
                            + ", e " + pacotes[idPacote].volta.id
                            + " com origem " + pacotes[idPacote].volta.origem
                            + " e destino " + pacotes[idPacote].volta.destino
                            + ", assim como " + quartos
                            + " quartos para " + pessoas
                            + " no hotel " + pacotes[idPacote].hotel.nome
                            + " em " + pacotes[idPacote].hotel.local
                            + " com entrada " + part
                            + " e saida " + cheg;

                    ref_Cli.echo(str);
                }
                if (contP > pacotes[idPacote].hotel.pessoas && contQ < pacotes[idPacote].hotel.pessoas) {
                    str = "A quantidade de pessoas definida não pode ocupar o estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                }
                if (contP < pacotes[idPacote].hotel.pessoas && contQ > pacotes[idPacote].hotel.pessoas) {
                    str = "A quantidade de quartos definida não pode ser ocupada noo estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                }
                if (contP > pacotes[idPacote].hotel.pessoas && contQ > pacotes[idPacote].hotel.pessoas) {
                    str = "A quantidade de quartos e pessoas definida não podem ocupadar o estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                }
            } else if (ver1 == 2) {
                str = "Um pacote nas especificações descritas não pode ser achado";
                ref_Cli.echo(str);
            }
        }

        if (opt == 2) {
            for (int i = 0; i < sizePacotes; i++) {
                if (pacotes[i].hotel.local.equals(destino)
                        && pacotes[i].ida.assentos - pessoas >= 0
                        && pacotes[i].volta.assentos - pessoas >= 0
                        && pacotes[i].ida.origem.equals(origem)
                        && pacotes[i].ida.destino.equals(destino)
                        && pacotes[i].volta.origem.equals(destino)
                        && pacotes[i].volta.destino.equals(origem)
                        && pacotes[i].ida.partida.compareTo(partida) >= 0
                        && pacotes[i].volta.partida.compareTo(chegada) >= 0) {
                    idPacote = i;
                    contP = pessoas;
                    contQ = quartos;
                    for (int j = 0; j < tamCompHoteis; j++) {
                        if (comprasHoteis[j].id == pacotes[i].hotel.id
                                && ((comprasHoteis[j].entrada.compareTo(chegada) <= 0
                                && comprasHoteis[j].saida.compareTo(chegada) >= 0)
                                || (comprasHoteis[j].entrada.compareTo(partida) <= 0
                                && comprasHoteis[j].saida.compareTo(partida) >= 0)
                                || (comprasHoteis[j].entrada.compareTo(chegada) >= 0
                                && comprasHoteis[j].saida.compareTo(partida) <= 0))) {
                            contP += comprasHoteis[i].p;
                            contQ += comprasHoteis[i].q;
                        }
                    }
                    if (contP <= pacotes[idPacote].hotel.pessoas && contQ <= pacotes[idPacote].hotel.pessoas) {
                        ver1 = 1;
                        break;
                    }
                }
            }
            if (ver1 == 1) {
                if (contP <= pacotes[idPacote].hotel.pessoas && contQ <= pacotes[idPacote].hotel.pessoas) {
                    pacotes[idPacote].ida.compraAssentos(pessoas);
                    pacotes[idPacote].volta.compraAssentos(pessoas);
                    Compra[] aux = new Compra[tamCompHoteis];

                    for (int i = 0; i < tamCompHoteis; i++) {
                        aux[i] = comprasHoteis[i];
                    }
                    tamCompHoteis++;
                    comprasHoteis = new Compra[tamCompHoteis];
                    for (int i = 0; i < tamCompHoteis - 1; i++) {
                        comprasHoteis[i] = aux[i];
                    }
                    comprasHoteis[tamCompHoteis - 1] = new Compra(part, cheg, ref_Cli);

                    str = "Uma compra foi realizada por " + pessoas
                            + " assentos nos voos " + pacotes[idPacote].ida.id
                            + " com origem " + pacotes[idPacote].ida.origem
                            + " e destino " + pacotes[idPacote].ida.destino
                            + ", e " + pacotes[idPacote].volta.id
                            + " com origem " + pacotes[idPacote].volta.origem
                            + " e destino " + pacotes[idPacote].volta.destino
                            + ", assim como " + quartos
                            + " quartos para " + pessoas
                            + " no hotel " + pacotes[idPacote].hotel.nome
                            + " em " + pacotes[idPacote].hotel.local
                            + " com entrada " + part
                            + " e saida " + cheg;

                    ref_Cli.echo(str);
                }
                if (contP > pacotes[idPacote].hotel.pessoas && contQ < pacotes[idPacote].hotel.pessoas) {
                    str = "A quantidade de pessoas definida não pode ocupar o estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                }
                if (contP < pacotes[idPacote].hotel.pessoas && contQ > pacotes[idPacote].hotel.pessoas) {
                    str = "A quantidade de quartos definida não pode ser ocupada noo estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                }
                if (contP > pacotes[idPacote].hotel.pessoas && contQ > pacotes[idPacote].hotel.pessoas) {
                    str = "A quantidade de quartos e pessoas definida não podem ocupadar o estabelecimento no periodo especificado";
                    ref_Cli.echo(str);
                }
            } else if (ver1 == 2) {
                str = "Um pacote nas especificações descritas não pode ser achado";
                ref_Cli.echo(str);
            }
        }
    }
}
