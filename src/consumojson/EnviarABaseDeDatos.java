/*
 8/17/2019

Se creo en java un tabla frutas(id numerica, nombre string)

Se creo una aplicacion java web conectada a este servidor con glassfish

aqui se hace post de un json
 */
package consumojson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


/**
 *
 * @author docto
 */
public class EnviarABaseDeDatos {

    public EnviarABaseDeDatos() {
    }
    
    public void POST(String surl,String json){
        
        
       //Por si los errores
        try {
            
             //url del servidor
             URL url = new URL(surl);
             HttpURLConnection con = (HttpURLConnection)url.openConnection();
             
             con.setConnectTimeout(5000);
             con.setRequestMethod("POST");
             con.setRequestProperty("Content-Type", "application/json");
             con.setDoInput(true);
             con.setDoOutput(true);
             OutputStream os = con.getOutputStream();
             os.write(json.getBytes("UTF-8"));
             os.flush();
             os.close();
              
             
             
                 int responseCode = con.getResponseCode();

                 System.out.println("POST Response Code :  " + responseCode);

                  System.out.println("POST Response Message : " + con.getResponseMessage());

                 if (responseCode == HttpURLConnection.HTTP_CREATED) { //success

        BufferedReader in = new BufferedReader(new InputStreamReader(
            con.getInputStream()));

        String inputLine;

        StringBuilder response = new StringBuilder();

        while ((inputLine = in .readLine()) != null) {
            response.append(inputLine);
        } in .close();
        // print result
        System.out.println(response.toString());
         } else {
          System.out.println("POST NOT WORKED");
         }
	          
        } catch (Exception e) {
            System.out.println("Error Eviando a la base de datos");
        }
    }
    
    
}
