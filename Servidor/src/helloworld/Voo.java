package helloworld;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe para representar os voos
 * 
 * @author João Pedro Passos
 * @version 1.0
 */
public class Voo {
    /**
     * Id do voo
     */
    int id;
    /**
     * Quantidade de assentos disponiveis no voo
     */
    int assentos;
    /**
     * Preço por passagem
     */
    int preco;
    /**
     * local de origem do voo
     */
    String origem;
    /**
     * local de destino do voo
     */
    String destino;
    /**
     * data de partida do voo
     */
    Date partida;
    /**
     * simple date format para poder setar as datas a partir de strings
     */
    private SimpleDateFormat dateformat;
    
    /**
     * Método construtor da classe voo
     * 
     * @param i id do voo
     * @param ass Quantidade de assentos
     * @param p preço por passagem
     * @param ori local de origem do voo
     * @param dest local de destino do voo
     * @param strPart data de partida do voo
     */
    public Voo(int i, int ass, int p, String ori, String dest, String strPart) {
        id = i;
        assentos = ass;
        preco = p;
        origem = ori;
        destino = dest;
        dateformat = new SimpleDateFormat("dd/MM/yyyy");
        if(strPart!=null) {
            try {
                partida = dateformat.parse(strPart);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * método para alteração da quantidade de assentos em função da compra de passagen(s)
     * @param ass quantidade de assentos comprados
     */
    public void compraAssentos(int ass) {
        assentos -= ass;
    }
}
