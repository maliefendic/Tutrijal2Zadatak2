package ba.unsa.etf.rs;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {
    public  boolean da_li_dozboljen_unos=false; // unos nije dozboljen na pocetku tako da ne mozemo pristupiti unosu dok se ne p
                                                // promjeni stanje uz tekstFildu
    public TextArea textArea;
    public TextField textField;
    public int sumaCifara(int x){

       int suma=0;
       while (x!=0){
           suma+=(x%10);
           x/=10;
       }
       return suma;
    }
    public void nadjiSumaCifara(ActionEvent actionEvent) {
     if(!da_li_dozboljen_unos){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Pogresan unos");
         alert.setHeaderText(null);
         alert.setContentText("Morate unijeti cijeli broj");
         alert.showAndWait();

     }
        int x= Integer.parseInt(textField.getText());
        int niz[] = new  int[x];
        int j=0;
        for(int i=1;i<=x;i++){
         if(i % sumaCifara(i) == 0){
             niz[j]=i;
             j++;
         }
        }
         String s ="";
         for(int i=0;i<j;i++){  // zasto ovdje nisam mogao deklaristai varijablu int i?????????
             s+=niz[i];
             if(i!=j-1){
                 s+=", ";
             }
         }
         s+=".";
        textArea.setText(s);
    }

    public void provjera(KeyEvent keyEvent) {
       String s= textField.getText();
       int broj; boolean br=true;
       try {
           broj= Integer.parseInt(s);
       }catch (NumberFormatException e){
           br=false;
       }
       if(s.length()==0){
           textField.getStyleClass().removeAll("nijeTacanUnos");
           textField.getStyleClass().removeAll("tacanUnos");
           da_li_dozboljen_unos=false;
       }else if(br){
           da_li_dozboljen_unos=true;
        textField.getStyleClass().removeAll("nijeTacanUnos");
        textField.getStyleClass().add("tacanUnos");
       }else{
           da_li_dozboljen_unos=false;
           textField.getStyleClass().removeAll("tacanUnos");
           textField.getStyleClass().add("nijeTacanUnos");
       }

    }
}
