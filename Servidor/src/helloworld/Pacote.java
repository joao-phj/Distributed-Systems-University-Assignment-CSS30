package helloworld;

/**
 * Classe representando os pacotes com voos de ida e volta e hotel
 * 
 * @author João Pedro Passos
 * @version 1.0
 */
public class Pacote {
    /**
     * Id do Pacote
     */
    int id;
    /**
     * Preço do Pacote
     */
    int preco;
    /**
     * Hotel parte do pacote
     */
    Hoteis hotel;
    /**
     * Voo de ida
     */
    Voo ida;    
    /**
     * Voo de volta
     */
    Voo volta;
    
    /**
     * Método contrutor do pacote
     * 
     * @param idaux id do pacote
     * @param h hotel do pacote
     * @param i voo de ida
     * @param v voo de volta
     */
    public Pacote(int idaux, Hoteis h, Voo i, Voo v) {
        id = idaux;
        hotel = h;
        ida = i;
        volta = v;
        preco = ida.preco + volta.preco + hotel.preco;
    }
}
