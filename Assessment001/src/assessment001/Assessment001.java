/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assessment001;

import assessment001.UI.Options;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author manos
 */
public class Assessment001 {
    static UIController c = new UIController();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        c.Start();
    }
    
    public static void DataOptions(){
        c.DataOptions();
    }
    public static void ViewData(){
        c.ViewData();
    }
}
