/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment001.UI;

import assessment001.Country;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 *
 * @author manos
 */
public class GoogleMap {
    public GoogleMap(Country country) throws IOException{
        String urlToCall = "https://covid2019-api.herokuapp.com/v2/country/" + country.getName();
        
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(urlToCall).build();
        
        try (okhttp3.Response response = client.newCall(request).execute()){
            if (response.isSuccessful() && response.body() != null){
                String responseString = response.body().string();
                GsonBuilder builder = new GsonBuilder();
                builder.setPrettyPrinting();
                Gson gson = builder.create();
                
                JsonObject json = gson.fromJson(responseString, JsonObject.class);
                
                JsonObject data = json.getAsJsonObject("data");
                
                JsonElement j1 = data.get("confirmed");
                JsonElement j2 = data.get("deaths");
                JsonElement j3 = data.get("recovered");
                
                int confirmed = j1.getAsInt();
                int deaths = j1.getAsInt();
                int recovered = j1.getAsInt();
                
                FileWriter writer;
                
                writer = new FileWriter("C:\\Users\\manos\\Downloads\\mappage.html");
                writer.write("<!DOCTYPE html>\n"
                        +"<html>\n"
                        +"<head>\n"
                        +" <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\" />\n"
                        +" <title>Google Maps Multiple Markers</title>\n"
                        +" <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyAiqoNpiqUbhG_l4yRFXzX2V85yayh2Lxk&callback=initMap\"\n"
                        +"      type=\"text/javascript\"></script>\n"
                        +"</head>\n"
                        +"<body>\n"
                        +" <div id=\"map\" style=\"width: 500px; height: 400px;\"></div>\n"
                        +"\n"
                        +" <script type=\"text/javascript\">\n"
                        +"      var locations = [\n"
                        +"      [\'"+country.getName()+", confirmed="+confirmed+", deaths="+deaths+", recovered="+recovered+"\', "+country.getLat()+", "+country.getLong1()+", 1]\n"
                        +"      ];\n"
                        +"      var map = new google.maps.Map(document.getElementById(\'map\'), {\n"
                        +"      zoom: 5,\n"
                        +"      center: new google.maps.LatLng("+country.getLat()+","+country.getLong1()+"),\n"
                        +"      mapTypeId: google.maps.MapTypeId.ROADMAP \n"
                        +"      });\n"
                        +"      var infowindow = new google.maps.InfoWindow();\n"
                        +"      var marker, i;\n"
                        +"      for (i = 0; i < locations.length; i++) {\n"
                        +"      marker = new google.maps.Marker({\n"
                        +"      position: new google.maps.LatLng(locations[i][1], locations[i][2]),\n"
                        +"      map: map\n"
                        +"      }); \n"
                        +"      google.maps.event.addListener(marker, \'click\', (function(marker,i) {\n"
                        +"      return function() {\n"
                        +"      infowindow.setContent(locations[i][0]);\n"
                        +"      infowindow.open(map, marker);\n"
                        +"      }\n"
                        +"      }) (marker, i));\n"
                        +"      }\n"
                        +"  </script>\n"
                        +"</body>\n"
                        +"</html>\n"
                );
                writer.close();
            }
        }
    }
    
    public void start() throws IOException {
        String webpage = "C:\\Users\\manos\\Downloads\\mappage.html";

        Runtime.getRuntime().exec("cmd /c start "+webpage);

    }
}
