/*

FelipedelosH

9/17/2019

WEB REST JSON
>POST
>GET
>PUSH
>DELETE



*/
package consumojson;

/**
 *
 * @author docto
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Se crea un obj que consume
        ConsumoJsonGET consumidor = new ConsumoJsonGET();
        
        System.out.println(consumidor.getJson("https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json"));
       
        
        
        
    }
    
}
