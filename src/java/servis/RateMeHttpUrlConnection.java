package servis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import model.Film;
import model.Ocena;
import org.json.*;


public class RateMeHttpUrlConnection {

    private static RateMeHttpUrlConnection urlConnection;

    public static RateMeHttpUrlConnection getInstance() {
        if (urlConnection == null) {
            urlConnection = new RateMeHttpUrlConnection();
        }
        return urlConnection;
    }
    private String getURL = "http://www.omdbapi.com/?apikey=44e44903&t=";

    public List<Film> sendGET(List<Film> lista) throws IOException {

        for (Film film : lista) {

            String[] nizz = film.getNaziv().split(" ");

            String a = new String();
            for (int i = 0; i < nizz.length; i++) {
                a = a + nizz[i] + "+";
            }
            String b = a.substring(0, a.lastIndexOf("+"));
            String newUrl = getURL + "" + b;

            URL obj = new URL(newUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String test = new String(response);

                JSONObject json = new JSONObject(test);
                if (json.getString("Response").equals("True")) {
                    String opis = json.getString("Plot");
                    film.setOpis(opis);
                    String poster = json.getString("Poster");
                    film.setPoster(poster);
                } else {
                    film.setPoster("no-pic");
                    film.setOpis("no plot");
                }

            } else {
                System.out.println("GET request not worked");
                return null;
            }

        }
        return lista;
    }

    public List<Ocena> sendGETOcena(List<Ocena> lista) throws IOException {

        for (Ocena ocena : lista) {

            String[] nizz = ocena.getFilm().getNaziv().split(" ");

            String a = new String();
            for (int i = 0; i < nizz.length; i++) {
                a = a + nizz[i] + "+";
            }
            String b = a.substring(0, a.lastIndexOf("+"));
            String newUrl = getURL + "" + b;
            URL obj = new URL(newUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String test = new String(response);

                JSONObject json = new JSONObject(test);
                if (json.getString("Response").equals("True")) {
                    String opis = json.getString("Plot");
                    ocena.getFilm().setOpis(opis);
                    String poster = json.getString("Poster");
                    ocena.getFilm().setPoster(poster);
                } else {
                    ocena.getFilm().setPoster("no-pic");
                    ocena.getFilm().setOpis("no plot");
                }

            } else {
                System.out.println("GET request not worked");
                return null;
            }

        }
        return lista;
    }

    public Ocena sendGETOcena(Ocena o) throws MalformedURLException, IOException {

        String[] nizz = o.getFilm().getNaziv().split(" ");

        String a = new String();
        for (int i = 0; i < nizz.length; i++) {
            a = a + nizz[i] + "+";
        }
        String b = a.substring(0, a.lastIndexOf("+"));
        String newUrl = getURL + "" + b;

        URL obj = new URL(newUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String test = new String(response);
//            if (test.contains("Plot\":\"")) {
//                    String[] niz = test.split("Plot\":\"");
//                    String[] niz2 = niz[1].split("\",\"Language");
//                    o.getFilm().setOpis(niz2[0]);
//                    
//                    
//                } else {
//                    o.getFilm().setOpis("no plot");
//                }

            JSONObject json = new JSONObject(test);
            if (json.getString("Response").equals("True")) {
                String opis = json.getString("Plot");
                o.getFilm().setOpis(opis);
                String poster = json.getString("Poster");
                o.getFilm().setPoster(poster);
            } else {
                o.getFilm().setPoster("no-pic");
                o.getFilm().setOpis("no plot");
            }

//            if (test.contains("Poster")) {
//                String[] niz = test.split("Poster\":\"");
//                String[] niz2 = niz[1].split("\",\"Ratings\"");
//                o.getFilm().setPoster(niz2[0]);
//            } else {
//                o.getFilm().setPoster("no-pic");
//            }
        } else {
            System.out.println("GET request not worked");
            return null;
        }

        return o;
    }
}
