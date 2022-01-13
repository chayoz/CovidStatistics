/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment001.UI;

import assessment001.Coviddata;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author manos
 */
public class Chart extends ApplicationFrame {
    List<Coviddata> deaths;
    List<Coviddata> confirmed;
    List<Coviddata> recovered;
    String date1;
    String date2;
            
    public Chart(String title,List<Coviddata> deaths, List<Coviddata> confirmed, List<Coviddata> recovered, String date1, String date2) throws ParseException{
        super(title);
        this.deaths = deaths;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.date1 = date1;
        this.date2 = date2;
    }
    private void SetChart(String chartTitle, int type) throws ParseException{
        JFreeChart chart = ChartFactory.createLineChart(chartTitle, "Date", "Quantity", createDataset(type));
        
        ChartPanel chartPanel = new ChartPanel (chart);
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }
    private DefaultCategoryDataset createDataset(int type) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        Date fromdate = sdf.parse(date1);
        Date todate = sdf.parse(date2);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        if (type==1 || type == 2){
            for (Coviddata c :confirmed){
            if (c.getTrndate().compareTo(fromdate) >= 0 && c.getTrndate().compareTo(todate) <= 0){
                dataset.addValue(c.getQty(), "Confirmed", c.getTrndate());
            }
            }
        }
        if (type==1 || type == 3){
            for (Coviddata c :deaths){
            if (c.getTrndate().compareTo(fromdate) >= 0 && c.getTrndate().compareTo(todate) <= 0){
                dataset.addValue(c.getQty(), "Deaths", c.getTrndate());
            }
            }
        }
        if (type==1 || type == 4){
            for (Coviddata c :recovered){
            if (c.getTrndate().compareTo(fromdate) >= 0 && c.getTrndate().compareTo(todate) <= 0){
                dataset.addValue(c.getQty(), "Recovered", c.getTrndate());
            }
            }
        }
        return dataset;
    }
    
    public static void start(String type, List<Coviddata> deaths, List<Coviddata> confirmed, List<Coviddata> recovered, String date1, String date2) throws ParseException{
        Chart chart = new Chart("Codvid-19",deaths,confirmed,recovered,date1,date2);
        System.out.println(type);
        switch (type){
            case "Complete Chart":
                chart.SetChart("Confirmed vs Deaths vs Recovered",1);
                break;
            case "Confirmed":
                chart.SetChart("Confirmed",2);
                break;
            case "Deaths":
                chart.SetChart("Deaths",3);
                break;
            case "Recovered":
                chart.SetChart("Recovered",4);
                break;
            default:
                chart.SetChart("Confirmed vs Deaths vs Recovered",1);
                break;
        }
        
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}
