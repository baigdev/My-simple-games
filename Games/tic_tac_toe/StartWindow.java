package tic_tac_toe;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Niaz Baig
 *
 */
class Window extends Application
{
	static Stage stage=new Stage();
	Scene scene;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage=primaryStage;
		stage.setTitle("Tic_Tac_Toe");
		stage.setWidth(500);
		stage.setHeight(520);
		fxComponants();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	void fxComponants()
	{
		GridPane grid=new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(25);
		
		Text p1=new Text("Name ");
		Text p2=new Text("Name ");
		TextField txtp1=new TextField();
		txtp1.setPromptText("Player 1");
		TextField txtp2=new TextField();
		txtp2.setPromptText("Player 2");
		Button start=new Button("Start");
		Button clearAll=new Button("Clear All");
		Button close=new Button("Close");
		
		GridPane.setMargin(close, new Insets(0,0,0,70));
		GridPane.setMargin(start, new Insets(0,0,0,120));
		grid.add(p1,0,0);
		grid.add(txtp1,1,0);
		grid.add(p2, 0,1);
		grid.add(txtp2, 1,1);
		grid.add(clearAll, 1,4);
		grid.add(close, 1, 4);
		grid.add(start, 1,4);

		scene=new Scene(grid);	
		start.setOnAction(x->{
			new Player(txtp1.getText(),txtp2.getText());
		});
	}
}
public class StartWindow extends Window{

	/**
	 * @param args
	 */
	
	public static void main(String[] Niaz_Baig) {
		
		Window.launch(Niaz_Baig);	
	}

}
