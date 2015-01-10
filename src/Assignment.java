/*Malyar Baron, this program asks the user through a GUI for the password and
username. Once entered and pressed "OK", the GUI will close and the program will
then look for that user in the Database. Once found, then on the console
the output will be the required documents needed for that user to print.
*/

import java.sql.*;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label; 
import javafx.scene.control.TextField;



public class Assignment extends Application{
 	//Strings get values from the textfields
	static String users;
	static String passwords;
	
	@Override
 	public void start(Stage primaryStage) {
		TextField usern = new TextField();
		TextField passw = new TextField();
		
		
		Button ok = new Button("OK");
		ok.setOnAction(e -> {  			//when pressed the button will close the window and
			users = usern.getText();    //and get values from the textfield
			passwords = passw.getText();
			primaryStage.close();
			
		});
		
		
		
		//Layout of the fields, labels and button
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setHgap(5);
		pane.setVgap(5);
		
		
		
		
		pane.add(new Label("Username: "), 0, 0);
		pane.add(usern, 1, 0);
		pane.add(new Label("Password: "), 0, 1);
		pane.add(passw, 1, 1);
		pane.add(ok,1,3);
		
		
		
		
		
		Scene scene = new Scene(pane, 300,100);
		primaryStage.setTitle("Enter username and password");
		primaryStage.setScene(scene);
		
		primaryStage.show();
	
		
		
	}
  
	public static void main(String[] args) throws SQLException {
 
 		launch(args);
 		
        Connection connect = null;
        ResultSet result = null;
        PreparedStatement state = null;
        String documents = null, first = null, last = null;
       
        //username in order to use SQL
        String admin = "root";
        //password in order to use SQL
        String pas = "skull1";
        //the database on a localhost called test12
        String address = "jdbc:mysql://localhost/test12";
        
        try {
         
            connect = DriverManager.getConnection(address, admin , pas);
 
            
            state = connect.prepareStatement("select * from users" +
            								" where username = ? and passwords = ?");
            								
            state.setString(1, users);
            state.setString(2, passwords);

            result = state.executeQuery();
           
            /*Gets the right document needed to be print for the user depending 
             * on the password and username entered.
             */
             while(result.next()){
            	 documents = result.getString("documents");
            	 first = result.getString("first_name");
            	 last = result.getString("last_name");
            }
  
            if (documents == null){
            	System.err.println("Wrong user or password");
            	
            }
            else{
            
            	System.out.println(last+", "+ first+ "  please print document(s): " + documents);
            }
            
        }
        
        
        //Just in case if there an exceptions
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (result != null) {
                result.close();
            }
 
            if (state != null) {
                state.close();
            }
 
            if (connect != null) {
                connect.close();
            }
        }
    }


}