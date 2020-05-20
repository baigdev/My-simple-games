package tic_tac_toe;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class DataTypes {
	
	Button boxes[]=new Button[9];
	String player1,player2;
	GridPane upperGrid=new GridPane();
	Text upperPlayer=new Text();
	boolean clicked[]=new boolean[9];
	Font font=new Font(40);
}
