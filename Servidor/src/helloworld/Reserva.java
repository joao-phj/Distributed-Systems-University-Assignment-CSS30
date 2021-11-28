package helloworld;

/**
 * Classe utilizada para representar interesse na adição de hoteis, voos ou pacotes que correspondem a um determinado pré-requisito
 * 
 * @author João Pedro Passos
 * @version 1.0
 */
public class Reserva {
    /**
     * id da Reserva
     */
    int id;
    /**
     * Objeto do tipo hotel para caso a reserva seja do tipo hotel
     */
    Hoteis hotel;
    /**
     * Objeto do tipo voo para caso a reserva seja do tipo voo
     */
    Voo voo;
    /**
     * Objeto do tipo pacote para caso a reserva seja do tipo pacote
     */
    Pacote pac;
    /**
     * Referência ao cliente que realizou a reserva
     */
    InterfaceCliente ic;
    
    /**
     * Método construtor da reserva
     * 
     * @param idAux id da reserva
     * @param h objeto hotel com pré-requisitos
     * @param v objeto voo com pré-requisitos
     * @param p objeto pacote com pré-requisitos
     * @param i referência cliente
     */
    public Reserva(int idAux, Hoteis h, Voo v, Pacote p, InterfaceCliente i) {
        id = idAux;
        hotel = h;
        voo = v;
        pac = p;
        ic = i;
    }
}
