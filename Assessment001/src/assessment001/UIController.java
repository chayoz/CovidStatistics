/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assessment001;

import assessment001.UI.DataManagement;
import assessment001.UI.Options;
import assessment001.UI.ViewData;

/**
 *
 * @author manos
 */
public class UIController {
    Options op;
    DataManagement dm;
    ViewData vd;
    public UIController() {
        op = new Options();
        dm = new DataManagement();
        vd = new ViewData();
    }
    
    
    public void Start() {
        op.setVisible(true);
    }
    
    public void DataOptions() {
        dm.setVisible(true);
    }
    
    public void ViewData() {
        vd.setVisible(true);
    }
}
