import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author Niaz Baig
 *
 */

class GameMainClass extends Application
{
	Stage stage;
	Scene scene;
	
	Button start=new Button("Start");
	Text name=new Text("Name");
	TextField txtname=new TextField();
	
	Text mode=new Text("Mode");
	Text operation=new Text("Operation");
	
	RadioButton add=new RadioButton("Add");
	RadioButton sub=new RadioButton("Sub");
	RadioButton mul=new RadioButton("Mul");
	RadioButton div=new RadioButton("Div");
	
	ToggleGroup group=new ToggleGroup();
	ComboBox<String> cmb=new ComboBox<String>();
	
	Image img0=new Image("file:///C:/Users/TIH/workspace/Games/src/mathPic2R.png");
	Image img=new Image("file:///C:/Users/TIH/workspace/Games/src/dieceR.jpg");
	Button viewResult=new Button("View Result");//For innerGrid--
	Button back=new Button("Back");
	
	GridPane upperGrid=new GridPane();
	
	Button close=new Button("Close");
	
	TextField t1=new TextField();
	TextField t2=new TextField();
	
	Label wrong=new Label("Wrong");
	Label correct=new Label("Correct");
	
	Text txtcorrect=new Text();
	Text txtwrong=new Text();//--
	
	static int correctcount,wrongcount;
	static double value1ForResult,Value2ForResult;
	public void start(Stage stage)
	{
		this.stage=stage;
		stage.setTitle("Math's Game");
		stage.setHeight(480);
		stage.setWidth(580);
		stage.setResizable(false);
		mainStageComp();
		stage.show();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void mainStageComp()
	{
		GridPane grid=new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(20);
		grid.setHgap(15);
		grid.setBackground(new Background(new BackgroundImage(img0, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
		txtname.setPromptText("Enter Name");

		start.setPrefSize(80, 35);
		start.setStyle("-fx-color:green");
		close.setPrefSize(80, 35);
		close.setStyle("-fx-color:red");
		
		viewResult.setStyle("-fx-color:lightgreen");
		back.setStyle("-fx-color:red");
		ObservableList list=FXCollections.observableArrayList();
		list.add("Easy");
		list.add("Medium");
		list.add("Hard");
		
		cmb.setPromptText("Select Mode");
		cmb.setMaxWidth(120);
		cmb.setItems(list);
	
		add.setToggleGroup(group);
		sub.setToggleGroup(group);
		mul.setToggleGroup(group);
		div.setToggleGroup(group);
		
		grid.add(name, 0, 0);
		grid.add(txtname, 1, 0);
		grid.add(mode, 0, 1);
		grid.add(cmb, 1, 1);
		grid.add(operation, 0, 2);
		grid.add(add, 1, 2);
		grid.add(sub, 1, 2);
		grid.add(mul, 1, 2);
		grid.add(div, 1, 2);
		GridPane.setMargin(sub, new Insets(0,0,0,50));
		GridPane.setMargin(mul, new Insets(0,0,0,100));
		GridPane.setMargin(div, new Insets(0,0,0,150));
		grid.add(close,1, 3);
		grid.add(start, 1, 3);
		
		GridPane.setMargin(start, new Insets(0,0,0,90));
		scene=new Scene(grid);
		stage.setScene(scene);
		
		wrong.setTextFill(Color.RED);
		wrong.setScaleX(2);
		wrong.setScaleY(2);
		txtwrong.setFill(Color.RED);
		txtwrong.setScaleX(2);
		txtwrong.setScaleY(2);
		
		correct.setTextFill(Color.GREEN);
		correct.setScaleX(2);
		correct.setScaleY(2);
		txtcorrect.setFill(Color.GREEN);
		txtcorrect.setScaleX(2);
		txtcorrect.setScaleY(2);
		
		upperGrid.add(txtcorrect,0, 1);
		GridPane.setMargin(txtcorrect, new Insets(0,0,0,70));
		upperGrid.add(correct, 0, 1);
		upperGrid.add(wrong,20,1);
		upperGrid.add(txtwrong,20 , 1);
		GridPane.setMargin(txtwrong, new Insets(0,0,0,70));
		close.setOnAction(x->{
			stage.hide();
		});
		start.setOnAction(y->{
			startMethod();
	});
	}
	
		public void startMethod()
		{	
			t1.setText("");
			t2.setText("");
			int checkName = 1;
			int c1 = 0,c2=0,c3=0;
			String selectedMode = null;
			String playerName;
			try
			{
					
			playerName=txtname.getText();
			long i=Long.parseLong(txtname.getText());
			}catch(Exception e)
			{
				    checkName=0;
					c1=1;
				}
				try
				{
					
				selectedMode=cmb.getValue().toString();
				c2=2;
				}catch(NullPointerException e)
				{
					Alert msg=new Alert(AlertType.ERROR);
					msg.setContentText("Please Select Mode");
					msg.show();
					
				}
				if(checkName==1)
				{
					Alert msg=new Alert(AlertType.ERROR);
					msg.setContentText("Please Enter Correct Name ");
					msg.show();
				}
				else if(txtname.getText().equalsIgnoreCase(""))
				{
					c1=0;
					Alert msg=new Alert(AlertType.ERROR);
					msg.setContentText("Please Enter Name ");
					msg.show();
				}
				if(c1==1&&c2==2)
				{
				
				upperGrid.setHgap(10);
				upperGrid.setVgap(10);
				upperGrid.setAlignment(Pos.BASELINE_CENTER);
				GridPane innergrid=new GridPane();
				innergrid.setVgap(20);
				innergrid.setHgap(15);
				innergrid.setAlignment(Pos.BASELINE_CENTER);
				
				innergrid.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));				
				
				t1.setEditable(false);
				t1.setPrefSize(200, 70);
				t2.setPrefSize(10,70);
				t2.setPromptText("Enter Your Answer");
				
				viewResult.setPrefSize(200, 50);
				back.setPrefSize(200, 50);
				GridPane.setMargin(viewResult, new Insets(0,0,0,50));
				GridPane.setMargin(back, new Insets(0,0,0,50));
				
				switch(selectedMode)
				{
				case "Easy":
				if(add.isSelected())
				{
					c3=1;
					int value1=(int)(Math.random()*100);
					int value2=(int)(Math.random()*100);
					
					value1ForResult=value1;
					Value2ForResult=value2;
					String getValue1=String.valueOf(value1);
					String getValue2=String.valueOf(value2);
					t1.insertText(0, getValue1+ " + "+ getValue2+"  =  ");
				}
				if(sub.isSelected())
				{
					c3=1;
					int value1=(int)(Math.random()*100);
					int value2=(int)(Math.random()*100);
					
					value1ForResult=value1;
					Value2ForResult=value2;
					String getValue1=String.valueOf(value1);
					String getValue2=String.valueOf(value2);
					t1.insertText(0, getValue1+ " - "+ getValue2+"  =  ");
				}
				else if(mul.isSelected())
				{
					c3=1;
					int value1=(int)(Math.random()*100);
					int value2=(int)(Math.random()*100);
					value1ForResult=value1;
					Value2ForResult=value2;
					String getValue1=String.valueOf(value1);
					String getValue2=String.valueOf(value2);
					t1.insertText(0, getValue1+ " * "+ getValue2+"  =  ");
				}
				else if(div.isSelected())
				{
					c3=1;
					int value1=(int)(Math.random()*100);
					int value2=(int)(Math.random()*100);
					value1ForResult=value1;
					Value2ForResult=value2;
					String getValue1=String.valueOf(value1);
					String getValue2=String.valueOf(value2);
					
					t1.insertText(0, getValue1+ " / "+ getValue2+"  =  ");
				}
				break;
				case "Medium" :
					if(add.isSelected())
					{
						c3=1;
						int value1=(int)(Math.random()*1000);
						int value2=(int)(Math.random()*1000);
						value1ForResult=value1;
						Value2ForResult=value2;
						String getValue1=String.valueOf(value1);
						String getValue2=String.valueOf(value2);
						t1.insertText(0, getValue1+ " + "+ getValue2+"  =  ");
					}
					if(sub.isSelected())
					{
						c3=1;
						int value1=(int)(Math.random()*1000);
						int value2=(int)(Math.random()*1000);
						value1ForResult=value1;
						Value2ForResult=value2;
						String getValue1=String.valueOf(value1);
						String getValue2=String.valueOf(value2);
						t1.insertText(0, getValue1+ " - "+ getValue2+"  =  ");
					}
					else if(mul.isSelected())
					{
						c3=1;
						int value1=(int)(Math.random()*1000);
						int value2=(int)(Math.random()*1000);
						value1ForResult=value1;
						Value2ForResult=value2;
						String getValue1=String.valueOf(value1);
						String getValue2=String.valueOf(value2);
						t1.insertText(0, getValue1+ " * "+ getValue2+"  =  ");
					}
					else if(div.isSelected())
					{
						c3=1;
						int value1=(int)(Math.random()*1000);
						int value2=(int)(Math.random()*1000);
						value1ForResult=value1;
						Value2ForResult=value2;
						String getValue1=String.valueOf(value1);
						String getValue2=String.valueOf(value2);
						t1.insertText(0, getValue1+ " / "+ getValue2+"  =  ");
					}
					break;
				case "Hard" :
					if(add.isSelected())
					{
						c3=1;
						int value1=(int)(Math.random()*10000);
						int value2=(int)(Math.random()*10000);
						value1ForResult=value1;
						Value2ForResult=value2;
						String getValue1=String.valueOf(value1);
						String getValue2=String.valueOf(value2);
						t1.insertText(0, getValue1+ " + "+ getValue2+"  =  ");
					}
					if(sub.isSelected())
					{
						c3=1;
						int value1=(int)(Math.random()*10000);
						int value2=(int)(Math.random()*10000);
						value1ForResult=value1;
						Value2ForResult=value2;
						String getValue1=String.valueOf(value1);
						String getValue2=String.valueOf(value2);
						t1.insertText(0, getValue1+ " - "+ getValue2+"  =  ");
					}
					else if(mul.isSelected())
					{
						c3=1;
						int value1=(int)(Math.random()*10000);
						int value2=(int)(Math.random()*10000);
						
						value1ForResult=value1;
						Value2ForResult=value2;
						String getValue1=String.valueOf(value1);
						String getValue2=String.valueOf(value2);
						t1.insertText(0, getValue1+ " * "+ getValue2+"  =  ");
					}
					else if(div.isSelected())
					{
						c3=1;
						int value1=(int)(Math.random()*10000);
						int value2=(int)(Math.random()*10000);
						value1ForResult=value1;
						Value2ForResult=value2;
						String getValue1=String.valueOf(value1);
						String getValue2=String.valueOf(value2);
						t1.insertText(0, getValue1+ " / "+ getValue2+"  =  ");
					}
					break;
				}
				if(c3==0)
				{
					Alert msg=new Alert(AlertType.ERROR);
					msg.setContentText("Please Select Operation ");
					msg.show();	
				}
				else
				{

				innergrid.add(upperGrid, 0, 0);
				innergrid.add(t1, 0, 5);
				innergrid.add(t2, 0, 5);
				innergrid.add(viewResult, 0, 6);
				innergrid.add(back, 0, 7);
				GridPane.setMargin(t2, new Insets(0,0,0,110));
				scene=new Scene(innergrid);
				stage.setScene(scene);
				stage.show();
				}
	}
			viewResult.setOnAction(x->{
				if(t2.getText().equalsIgnoreCase(""))
				{
					Alert msg=new Alert(AlertType.WARNING);
					msg.setContentText("Please Enter Your Answer");
					msg.show();
				}
				if(add.isSelected())
				{
					
					int answer=Integer.parseInt(t2.getText());
					if(value1ForResult+Value2ForResult==answer)
					correctcount++;
					else
						wrongcount++;
					txtcorrect.setText(String.valueOf(correctcount));
					txtwrong.setText(String.valueOf(wrongcount));
					startMethod();
				}
				if(sub.isSelected())
				{
					int answer=Integer.parseInt(t2.getText());
					if(value1ForResult-Value2ForResult==answer)
					correctcount++;
					else
						wrongcount++;
					txtcorrect.setText(String.valueOf(correctcount));
					txtwrong.setText(String.valueOf(wrongcount));
					startMethod();
				}
				if(div.isSelected())
				{
					int answer=Integer.parseInt(t2.getText());
					if(value1ForResult/Value2ForResult==answer)
						correctcount++;
					else
						wrongcount++;
					txtcorrect.setText(String.valueOf(correctcount));
					txtwrong.setText(String.valueOf(wrongcount));
					startMethod();
				}
				if(mul.isSelected())
				{
					int answer=Integer.parseInt(t2.getText());
					if(value1ForResult*value1ForResult==answer)
						correctcount++;
					else
						wrongcount++;
					txtcorrect.setText(String.valueOf(correctcount));
					txtwrong.setText(String.valueOf(wrongcount));
					startMethod();
				}
			});
			back.setOnAction(z->{
				try{
					start(stage);
				}catch(Exception e){}
			});

			}
}
public class MathsGame extends GameMainClass{

	/**
	 * @param args
	 */
	public static void main(String[] Niaz_Baig) {
		

		launch(Niaz_Baig);
	}

}
