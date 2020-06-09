package client;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

    private static HttpURLConnection connection;
    private static StringBuffer svar= new StringBuffer();
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            URL url= new URL("http://localhost:8080/spelplan");
            connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                svar.append(inputLine);

            in.close();
            char[][] spelPlan= gson.fromJson(svar.toString(), char[][].class);

            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    System.out.print(spelPlan[x][y]+ " ");
                }
                System.out.println();

            }



        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }
    }

}
