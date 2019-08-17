/*
8/17/2019

felipedelosH

Me dispongo a crear una clase que solo consume desde una url
->Esto retorna String del String(json) o "error"

 */
package consumojson;

//Manejo de url
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
//Conectarse por protocolo HTTP
import java.net.HttpURLConnection;
import java.util.Scanner;

/**
 *
 * @author docto
 */
public class ConsumoJsonGET {
    
    public ConsumoJsonGET() {
    }
    
    //Este metodo le entra una url es consumida y retornada como String
    //El string esta sin procesar
    public String getJson(String surl){
        
        //Por si existen errores
        try {
            
            //Asocio con la url
            URL url = new URL(surl);
            //Aqui se guarda el resultado
            String resultado = "";
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            //Se lee el json
            InputStream inStream = connection.getInputStream();
            //Lo prongo en el resultadp
            resultado = new Scanner(inStream, "UTF-8").useDelimiter("\\Z").next();
            return resultado;
            
        } catch (IOException e) {
            return "error";
        }
        
    }
    
    
}
