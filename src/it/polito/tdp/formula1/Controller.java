package it.polito.tdp.formula1;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.formula1.model.Circuit;
import it.polito.tdp.formula1.model.Driver;
import it.polito.tdp.formula1.model.Model;
import it.polito.tdp.formula1.model.Race;
import it.polito.tdp.formula1.model.Season;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Circuit> boxCircuit;

    @FXML
    private ComboBox<Driver> boxDriver;

    @FXML
    private ComboBox<Season> boxSeason;

    @FXML
    private TextArea txtResult;

	private Model model;
	
    @FXML
    void doFantaGara(ActionEvent event) {

    }

    @FXML
    void doInfoGara(ActionEvent event) {
    	
    	int anno= Integer.parseInt(boxSeason.getValue().getYear().toString());
    	int idCir= boxCircuit.getValue().getCircuitId();
    	Race r= model.getRace(anno, idCir);
    	txtResult.appendText(r.toString()+"\n\n");
    	for(Driver d : model.getPiloti(r.getRaceId())){
    		txtResult.appendText(d.toString()+"\n");
    	}
    	
    }

    @FXML
    void initialize() {
        assert boxCircuit != null : "fx:id=\"boxCircuit\" was not injected: check your FXML file 'Formula1.fxml'.";
        assert boxDriver != null : "fx:id=\"boxDriver\" was not injected: check your FXML file 'Formula1.fxml'.";
        assert boxSeason != null : "fx:id=\"boxSeason\" was not injected: check your FXML file 'Formula1.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Formula1.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model ;
		boxSeason.getItems().addAll(model.getStagioni());
		boxSeason.valueProperty().addListener(new ChangeListener<Season>(){
			@Override
			public void changed(ObservableValue<? extends Season> arg0, Season s1, Season s2) {
				if(s1!=null){
					boxCircuit.getItems().removeAll(model.getCircuiti(Integer.parseInt(s1.getYear().toString())));

				}
				//circuiti.removeAll(circuiti);
				//boxCircuit.getItems().removeAll(model.getCircuiti(Integer.parseInt(s1.getYear().toString())));
				//List<Circuit> circuiti=model.getCircuiti(Integer.parseInt(s2.getYear().toString()));
				//System.out.println(circuiti);
				boxCircuit.getItems().addAll(model.getCircuiti(Integer.parseInt(s2.getYear().toString())));	
				//boxCircuit.getItems().addAll(model.getCircuiti(Integer.parseInt(boxSeason.getValue().getYear().toString())));
				
			}
	     });
		
	}
}
