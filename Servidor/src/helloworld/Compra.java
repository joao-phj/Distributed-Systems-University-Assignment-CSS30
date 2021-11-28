package helloworld;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe utilizada paraa registrar a compra de uma estadia em um hotel
 *
 * @version 1.0
 * @author juaum
 */
public class Compra {

    /**
     * Data de entrada no hotel
     */
    Date entrada;
    /**
     * Data de saida do hotel
     */
    Date saida;
    /**
     * id do hotel
     */
    int id;
    /**
     * Quantidade de pessoas hospedadas
     */
    int p;
    /**
     * Quantidade de quartos ocupados
     */
    int q;
    /**
     * Cliente que realizou a compra
     */
    InterfaceCliente ic;

    /**
     * Construtora da compra
     *
     * @param ent data de entrada
     * @param sai data de saida
     * @param i id do hotel
     */
    public Compra(String ent, String sai, InterfaceCliente i) {
        SimpleDateFormat df;
        df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            entrada = df.parse(ent);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            saida = df.parse(sai);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ic = i;
    }
}
