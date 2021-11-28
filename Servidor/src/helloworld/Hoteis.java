package helloworld;

/**
 * Classe para representar os hoteis
 *
 * @author João Pedro Passos
 * @version 1.0
 */
public class Hoteis {

    /**
     * id do hotel
     */
    int id;
    /**
     * preço por quarto
     */
    int preco;
    /**
     * capacidade máxima de pessoas
     */
    int pessoas;
    /**
     * Quantidade de quartos
     */
    int quartos;
    /**
     * nome do hotel
     */
    String nome;
    /**
     * localização do hotel
     */
    String local;

    /**
     * Metodo construtor da classe hoteis
     *
     * @param i id do hotel
     * @param p preço por quarto
     * @param pes capacidade maxima de pessoas
     * @param q quantidade de quartos
     * @param n nome do hotel
     * @param l localização do hotel
     */
    public Hoteis(int i, int p, int pes, int q, String n, String l) {
        id = i;
        preco = p;
        pessoas = pes;
        quartos = q;
        nome = n;
        local = l;
    }
}
