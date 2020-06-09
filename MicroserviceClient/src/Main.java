import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main {

	private static HttpURLConnection connection;
	private static StringBuffer svar= new StringBuffer();
	public static void main(String[] args) {
		try {
			Gson gson = new Gson();
			URL url= new URL("https://jsonplaceholder.typicode.com/albums");
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
			
			TypeToken<List<Album>> token = new TypeToken<List<Album>>() {};
			List<Album> albums = gson.fromJson(svar.toString(), token.getType());
			
			albums.forEach((a) -> {
				System.out.println(a.userId +" - " +  a.title);
			});
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}

}
