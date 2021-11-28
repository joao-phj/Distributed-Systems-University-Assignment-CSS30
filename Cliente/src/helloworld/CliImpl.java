package helloworld;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Classe responsável por implementar os métodos declarados na InterfaceCliente
 * 
 * @author João Pedro Passos
 * @version 1.0
 */
public class CliImpl extends UnicastRemoteObject implements InterfaceCliente {

    /**
     * Vetor contendo os ids das reservas de hoteis feitas pelo cliente
     */
    int[] reservasHoteis;
    /**
     * Quantidade de reservas de hoteis feitas pelo cliente
     */
    int sizeHoteis = 0;

    /**
     * Vetor contendo os ids das reservas de voos feitas pelo cliente
     */
    int[] reservasVoos;
    /**
     * Quantidade de reservas de voos feitas pelo cliente
     */
    int sizeVoos = 0;

    /**
     * Vetor contendo os ids das reservas de pacotes feitas pelo cliente
     */
    int[] reservasPacotes;
    /**
     * Quantidade de reservas de pacotes feitas pelo cliente
     */
    int sizePacotes = 0;

    /**
     * Construtora da implementadora do cliente
     *
     * @param serv referência servidor
     * @throws RemoteException
     */
    CliImpl(InterfaceServidor serv) throws RemoteException {

    }

    /**
     * Adiciona o id da reserva de hotel ao vetor
     *
     * @param id
     * @throws RemoteException
     */
    public void ReservarHotel(int id) throws RemoteException {
        int[] aux = new int[sizeHoteis];

        for (int i = 0; i < sizeHoteis; i++) {
            aux[i] = reservasHoteis[i];
        }
        sizeHoteis++;
        reservasHoteis = new int[sizeHoteis];

        for (int i = 0; i < sizeHoteis - 1; i++) {
            reservasHoteis[i] = aux[i];
        }

        reservasHoteis[sizeHoteis - 1] = id;
    }

    /**
     * Adiciona o id da reserva de voo ao vetor
     *
     * @param id
     * @throws RemoteException
     */
    public void ReservarVoo(int id) throws RemoteException {
        int[] aux = new int[sizeVoos];

        for (int i = 0; i < sizeVoos; i++) {
            aux[i] = reservasVoos[i];
        }
        sizeVoos++;
        reservasVoos = new int[sizeVoos];

        for (int i = 0; i < sizeVoos - 1; i++) {
            reservasVoos[i] = aux[i];
        }

        reservasVoos[sizeVoos - 1] = id;
    }

    /**
     * Adiciona o id da reserva de pacote ao vetor
     *
     * @param id
     * @throws RemoteException
     */
    public void ReservarPacote(int id) throws RemoteException {
        int[] aux = new int[sizePacotes];

        for (int i = 0; i < sizePacotes; i++) {
            aux[i] = reservasPacotes[i];
        }
        sizePacotes++;
        reservasPacotes = new int[sizePacotes];

        for (int i = 0; i < sizePacotes - 1; i++) {
            reservasPacotes[i] = aux[i];
        }

        reservasPacotes[sizePacotes - 1] = id;
    }

    /**
     * Verifica se o id informado corresponde a alguma reserva de hotel
     *
     * @param id id de reserva a ser procurado
     * @return 1 caso sim 0 caso não
     * @throws RemoteException
     */
    public int verificarReservaHotel(int id) throws RemoteException {
        for (int i = 0; i < sizeHoteis; i++) {
            if (reservasHoteis[i] == id) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Verifica se o id informado corresponde a alguma reserva de voo
     *
     * @param id id de reserva a ser procurado
     * @return 1 caso sim 0 caso não
     * @throws RemoteException
     */
    public int verificarReservaVoo(int id) throws RemoteException {
        for (int i = 0; i < sizeVoos; i++) {
            if (reservasVoos[i] == id) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Verifica se o id informado corresponde a alguma reserva de pacote
     *
     * @param id id de reserva a ser procurado
     * @return 1 caso sim 0 caso não
     * @throws RemoteException
     */
    public int verificarReservaPacote(int id) throws RemoteException {
        for (int i = 0; i < sizePacotes; i++) {
            if (reservasPacotes[i] == id) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Remove o id informado da list de reservas de hotel caso exista
     *
     * @param id
     * @throws RemoteException
     */
    public void cancelarReservaHotel(int id) throws RemoteException {
        int[] aux = new int[sizeHoteis - 1];
        int i2 = 0;
        for (int i = 0; i < sizeHoteis; i++) {
            if (reservasHoteis[i] != id) {
                aux[i2] = reservasHoteis[i];
                i2++;
            }
        }
        sizeHoteis--;

        reservasHoteis = new int[sizeHoteis];

        for (int i = 0; i < sizeHoteis; i++) {
            if (aux[i] != id) {
                reservasHoteis[i] = aux[i];
            }
        }
    }

    /**
     * Remove o id informado da list de reservas de voo caso exista
     *
     * @param id
     * @throws RemoteException
     */
    public void cancelarReservaVoo(int id) throws RemoteException {
        int[] aux = new int[sizeVoos - 1];
        int i2 = 0;
        for (int i = 0; i < sizeVoos; i++) {
            if (reservasVoos[i] != id) {
                aux[i2] = reservasVoos[i];
                i2++;
            }
        }
        sizeVoos--;

        reservasVoos = new int[sizeVoos];

        for (int i = 0; i < sizeVoos; i++) {
            if (aux[i] != id) {
                reservasVoos[i] = aux[i];
            }
        }
    }

    /**
     * Remove o id informado da list de reservas de pacote caso exista
     *
     * @param id
     * @throws RemoteException
     */
    public void cancelarReservaPacote(int id) throws RemoteException {
        int[] aux = new int[sizePacotes - 1];
        int i2 = 0;
        for (int i = 0; i < sizePacotes; i++) {
            if (reservasPacotes[i] != id) {
                aux[i2] = reservasPacotes[i];
                i2++;
            }
        }
        sizePacotes--;

        reservasVoos = new int[sizePacotes];

        for (int i = 0; i < sizePacotes; i++) {
            if (aux[i] != id) {
                reservasPacotes[i] = aux[i];
            }
        }
    }

    /**
     * Imprime a string passada no terminal do cliente
     *
     * @param str string a ser impressa
     * @throws RemoteException
     */
    public void echo(String str) throws RemoteException {
        System.out.println(str);
    }
}
