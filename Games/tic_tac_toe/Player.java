package tic_tac_toe;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
class Player
{
	DataTypes dataT=new DataTypes();
	ConditionalOprtr1 cndtnlop1=new ConditionalOprtr1();
	ConditionalOprtr2 cndtnloprt2=new ConditionalOprtr2();
	
	Player(String p1,String p2)
	{
		dataT.player1=p1;
		dataT.player2=p2;
		fx();
	}
	Player(String player1,String player2,Integer a)
	{
		dataT.player1=player1;
		dataT.player2=player2;
		resetConditionalOprtr1();
		resetConditionalOprtr2();
		fx();
	}
	Scene scene;
	int k=0;
	void fx()
	{
		GridPane grid=new GridPane();
		grid.setAlignment(Pos.BASELINE_CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		
		for(int i=0;i<9;i++)
		{
			dataT.boxes[i]=new Button();
			dataT.boxes[i].setPrefSize(145, 145);
			dataT.boxes[i].setFont(dataT.font);
		}
		grid.add(dataT.upperPlayer, 1, 0);
		for(int i=5;i<8;i++)
		for(int j=0;j<3;j++)
		{
			grid.add(dataT.boxes[k++], j,i);
		}
		scene=new Scene(grid);
		StartWindow.stage.setScene(scene);
		player1Action();
	}
	
	void player1Action()
	{
		dataT.upperPlayer.setText(dataT.player1);
		for(int i=0;i<9;i++)
		{
			dataT.boxes[i].setOnAction(this::buttonActionForPlayer1);
		}
	}
	void player2Action()
	{
		dataT.upperPlayer.setText(dataT.player2);
		for(int j=0;j<9;j++)
		{
			dataT.boxes[j].setOnAction(this::buttonActionForPlayer2);
		}
	}
	
	void buttonActionForPlayer1(ActionEvent event)
	{
		for(int i=0;i<9;i++)
		{
			if(event.getSource()==dataT.boxes[i])
			{
				if(!dataT.clicked[i])
				{
					dataT.boxes[i].setText("0");
					dataT.clicked[i]=true;
					cndtnlop1.diagonal[i]=true;
					cndtnlop1.horizontal[i]=true;
					cndtnlop1.vertical[i]=true;
					if(player1Check())
					{
						Alert msg=new Alert(AlertType.CONFIRMATION);
						msg.setContentText("Congratulations "+dataT.player1+" You Are Winner");
						msg.show();
						msg.setOnHidden(y->{
							new Player(dataT.player1,dataT.player2,null);
						});
					}
				else
					player2Action();
				}
			}
		}
	}
	
	void buttonActionForPlayer2(ActionEvent event)
	{
		for(int i=0;i<9;i++)
		{
			if(event.getSource()==dataT.boxes[i])
			{
				if(!dataT.clicked[i])
				{
					dataT.boxes[i].setText("X");
					dataT.clicked[i]=true;
					cndtnloprt2.horizontal[i]=true;
					cndtnloprt2.vertical[i]=true;
					cndtnloprt2.diagonal[i]=true;
					if(player2Check())
					{
						Alert msg=new Alert(AlertType.CONFIRMATION);
						msg.setContentText("Congratulations "+dataT.player2+" You Are Winner");
						msg.show();
						msg.setOnHidden(y->{
							new Player(dataT.player1,dataT.player2);
						});
					}
				else
					player1Action();
				}
			}
		}
	}
	
	boolean player1Check()
	{
		if(cndtnlop1.horizontal[0]&&cndtnlop1.horizontal[1]&&cndtnlop1.horizontal[2]||
				cndtnlop1.horizontal[3]&&cndtnlop1.horizontal[4]&&cndtnlop1.horizontal[5]
				||cndtnlop1.horizontal[6]&&cndtnlop1.horizontal[7]&&cndtnlop1.horizontal[8])
			return true;
		else if(cndtnlop1.vertical[0]&&cndtnlop1.vertical[3]&&cndtnlop1.vertical[6]||
				cndtnlop1.vertical[1]&&cndtnlop1.vertical[4]&&cndtnlop1.vertical[7]||
				cndtnlop1.vertical[2]&&cndtnlop1.vertical[5]&&cndtnlop1.vertical[8])
			return true;
		else if(cndtnlop1.diagonal[0]&&cndtnlop1.diagonal[4]&&cndtnlop1.diagonal[8]||
				cndtnlop1.diagonal[2]&&cndtnlop1.diagonal[4]&&cndtnlop1.diagonal[6])
			return true;
		else
		return false;
	}
	
	boolean player2Check()
	{
		if(cndtnloprt2.horizontal[0]&&cndtnloprt2.horizontal[1]&&cndtnloprt2.horizontal[2]||
				cndtnloprt2.horizontal[3]&&cndtnloprt2.horizontal[4]&&cndtnloprt2.horizontal[5]
				||cndtnloprt2.horizontal[6]&&cndtnloprt2.horizontal[7]&&cndtnloprt2.horizontal[8])
			return true;
		else if(cndtnloprt2.vertical[0]&&cndtnloprt2.vertical[3]&&cndtnloprt2.vertical[6]||
				cndtnloprt2.vertical[1]&&cndtnloprt2.vertical[4]&&cndtnloprt2.vertical[7]||
				cndtnloprt2.vertical[2]&&cndtnloprt2.vertical[5]&&cndtnloprt2.vertical[8])
			return true;
		else if(cndtnloprt2.diagonal[0]&&cndtnloprt2.diagonal[4]&&cndtnloprt2.diagonal[8]||
				cndtnloprt2.diagonal[2]&&cndtnloprt2.diagonal[4]&&cndtnloprt2.diagonal[6])
			return true;
		else
		return false;
	}
	void resetConditionalOprtr1()
	{
		for(int i=0;i<9;i++)
		{
			cndtnlop1.vertical[i]=false;
			cndtnlop1.horizontal[i]=false;
			cndtnlop1.diagonal[i]=false;
			dataT.clicked[i]=false;
		}
	}
	void resetConditionalOprtr2()
	{
		for(int i=0;i<9;i++)
		{
			cndtnloprt2.vertical[i]=false;
			cndtnloprt2.horizontal[i]=false;
			cndtnloprt2.diagonal[i]=false;
		}
	}
}