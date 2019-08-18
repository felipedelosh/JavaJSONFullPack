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
        
        //Se crea un obj que manda a la base de datos
        EnviarABaseDeDatos send = new EnviarABaseDeDatos();
        
        //Este es el json
        int id  = 999;
        String nombre = "Loko";
        String json = "{\"id\":"+Integer.toString(id)+",\"nombre\":\""+nombre+"\"}";
        System.out.println(json);
        System.out.println("================");
        send.POST("http://localhost:8080/SERVERFRUTAS/webresources/base.frutas", json);
        
        //System.out.println(consumidor.getJson("https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json"));
        System.out.println(consumidor.getJson("http://localhost:8080/SERVERFRUTAS/webresources/base.frutas"));
        
        
        
        
    }
    
}
