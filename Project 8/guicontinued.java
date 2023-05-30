//The program decides the moves for the computer purely by random. there is no method beind it.
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class square{
	int number,x,y;
	String marking;
	
	public square(int n, String m,int x,int y) {
		number =n;
		marking=m;
		this.x=x;
		this.y=y;
	}
	
	public String getMarking() {return marking;}
	
	public void setMarking(String m) {marking=m;}
	
	public void draw(Graphics g) {
		
		//set color depending on who taken square
		//if neutral square
		if(marking.equals("n")) {
			String label=(number+" ");
			g.setColor(Color.red);
			g.fillRect(x, y, 100, 100);
			
		//if player owns square
		}else if(marking.equals("p")) {
			String label=(number+" ");
			g.setColor(Color.green);
			g.fillRect(x, y, 100, 100);
			
		//if computer owns square
		}else if(marking.equals("c")) {
			String label=(number+" ");
			g.setColor(Color.orange);
			g.fillRect(x, y, 100, 100);
		}
		//putting numbers in the middle of the square
		String label=number+" ";
		Font font=new Font("Arial",Font.PLAIN,40);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString(label, x+40, y+60);
	}
}
class close extends WindowAdapter{
	
	public void windowClosing(WindowEvent e) {
	//end game
		System.out.println("Thanks for playing!");
		System.exit(0);
	}
}

class board extends JPanel{
	//if in game or in setup
	public boolean game=false;
	square [] boardSquares;
	public board() {
		setSize(1400,900);
		boardSquares=new square[9];
		
		boardSquares[0]=new square(1,"n",300,125);
		boardSquares[1]=new square(2,"n",700,125);
		boardSquares[2]=new square(3,"n",1100,125);
		boardSquares[3]=new square(4,"n",375,350);
		boardSquares[4]=new square(5,"n",700,350);
		boardSquares[5]=new square(6,"n",1025,350);
		boardSquares[6]=new square(7,"n",300,575);
		boardSquares[7]=new square(8,"n",700,575);
		boardSquares[8]=new square(9,"n",1100,575);
		
			
	}
	
	//flip the game state
	public void setGame() {
		if(game==false) {
			game=true;
		}else {
			game=false;
		}
	}
	
	public void setUp() {game=false;}
	
	public void paintComponent(Graphics g) {
		if(game==true)
		{
			//squares
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 1400, 900);
			
			for(int i =0;i<9;i++) {
				boardSquares[i].draw(g);
			}
		}
	}
}

class jerryMain extends JFrame implements ActionListener{
	JButton player, computer, reset, place;
	JTextField squareNum;
	JLabel score,turn, turnSet;
	String move="";
	Container screen;
	JPanel board,settings,playControls;
	int pWins=0,cWins=0,tie=0;
	board playBoard;
	
	public void actionPerformed(ActionEvent e){
		//set first player move
		if(e.getSource()==computer) {
			move="computer";
			//remove starting screen
			screen.remove(computer);
			screen.remove(player);
			screen.remove(turnSet);

			//add play screen
			screen.add(settings,"North");
			screen.add(playControls,"South");
			screen.add(playBoard,"Center");
			playBoard.setGame();
			screen.repaint();
			
			compMove();
			
		}
		if(e.getSource()==player) {
			move="player";
			//remove starting screen
			screen.remove(computer);
			screen.remove(player);
			screen.remove(turnSet);
			
			//add play screen
			screen.add(settings,"North");
			screen.add(playControls,"South");
			screen.add(playBoard,"Center");
			playBoard.setGame();
			screen.repaint();
			
		}
		
		if(e.getSource()==reset) {
			System.out.println("reset");
		}
		
		if(e.getSource()==place) {
			int s=Integer.parseInt(squareNum.getText());
			//check to see if square is already marked
			//if neutral 
			if(playBoard.boardSquares[s-1].getMarking().equals("n")) {
				playBoard.boardSquares[s-1].setMarking("p");
				playBoard.repaint();
				victoryCheck();
				move="computer";
				turn.setText("It is the "+move+"'s turn.");
				compMove();
			//do nothing if space already claimed
			}else {}
		}
	}
	
	public void compMove() {
		//loop to ensure move is placed
		boolean moveMade=false;
		while(moveMade==false) {
			int cMove= (int)(9*Math.random()+1);
			//check to see if square is already marked
			//if neutral 
			if(playBoard.boardSquares[cMove-1].getMarking().equals("n")) {
				//set tile to computer square
				playBoard.boardSquares[cMove-1].setMarking("c");
				playBoard.repaint();
				turn.setText("It is the "+move+"'s turn.");
				moveMade=true;
			//do nothing if space already claimed
			}else {}
		}
		victoryCheck();
		move="player";
	}
	
	public void victoryCheck() {
		boolean victory =false;
		
		//check for computer victories
		if(playBoard.boardSquares[0].getMarking().equals("c")&&playBoard.boardSquares[1].getMarking().equals("c")&&playBoard.boardSquares[2].getMarking().equals("c")) {
			victory=true;
			System.out.println(1);
		}else if(playBoard.boardSquares[3].getMarking().equals("c")&&playBoard.boardSquares[4].getMarking().equals("c")&&playBoard.boardSquares[5].getMarking().equals("c")) {
			System.out.println(2);
			victory=true;
		}else if(playBoard.boardSquares[6].getMarking().equals("c")&&playBoard.boardSquares[7].getMarking().equals("c")&&playBoard.boardSquares[8].getMarking().equals("c")) {
			victory=true;
			System.out.println(3);
		}else if(playBoard.boardSquares[0].getMarking().equals("c")&&playBoard.boardSquares[3].getMarking().equals("c")&&playBoard.boardSquares[7].getMarking().equals("c")) {
			victory=true;
			System.out.println(4);
		}else if(playBoard.boardSquares[0].getMarking().equals("c")&&playBoard.boardSquares[4].getMarking().equals("c")&&playBoard.boardSquares[8].getMarking().equals("c")) {
			victory=true;
			System.out.println(5);
		}else if(playBoard.boardSquares[1].getMarking().equals("c")&&playBoard.boardSquares[3].getMarking().equals("c")&&playBoard.boardSquares[6].getMarking().equals("c")) {
			victory=true;
			System.out.println(6);
		}else if(playBoard.boardSquares[1].getMarking().equals("c")&&playBoard.boardSquares[5].getMarking().equals("c")&&playBoard.boardSquares[8].getMarking().equals("c")) {
			victory=true;
			System.out.println(7);
		}else if(playBoard.boardSquares[2].getMarking().equals("c")&&playBoard.boardSquares[4].getMarking().equals("c")&&playBoard.boardSquares[6].getMarking().equals("c")) {
			victory=true;
			System.out.println(8);
		}else if(playBoard.boardSquares[2].getMarking().equals("c")&&playBoard.boardSquares[5].getMarking().equals("c")&&playBoard.boardSquares[7].getMarking().equals("c")) {
			victory=true;	
			System.out.println(9);
		}
		
		//check for player victories
		if(playBoard.boardSquares[0].getMarking().equals("p")&&playBoard.boardSquares[1].getMarking().equals("p")&&playBoard.boardSquares[2].getMarking().equals("p")) {
			victory=true;
			System.out.println(1);
		}else if(playBoard.boardSquares[3].getMarking().equals("p")&&playBoard.boardSquares[4].getMarking().equals("p")&&playBoard.boardSquares[5].getMarking().equals("p")) {
			victory=true;
			System.out.println(2);
		}else if(playBoard.boardSquares[6].getMarking().equals("p")&&playBoard.boardSquares[7].getMarking().equals("p")&&playBoard.boardSquares[8].getMarking().equals("p")) {
			victory=true;
			System.out.println(3);
		}else if(playBoard.boardSquares[0].getMarking().equals("p")&&playBoard.boardSquares[3].getMarking().equals("p")&&playBoard.boardSquares[7].getMarking().equals("p")) {
			victory=true;
			System.out.println(4);
		}else if(playBoard.boardSquares[0].getMarking().equals("p")&&playBoard.boardSquares[4].getMarking().equals("p")&&playBoard.boardSquares[8].getMarking().equals("p")) {
			victory=true;
			System.out.println(5);
		}else if(playBoard.boardSquares[1].getMarking().equals("p")&&playBoard.boardSquares[3].getMarking().equals("p")&&playBoard.boardSquares[6].getMarking().equals("p")) {
			victory=true;
			System.out.println(6);
		}else if(playBoard.boardSquares[1].getMarking().equals("p")&&playBoard.boardSquares[5].getMarking().equals("p")&&playBoard.boardSquares[8].getMarking().equals("p")) {
			victory=true;
			System.out.println(7);
		}else if(playBoard.boardSquares[2].getMarking().equals("p")&&playBoard.boardSquares[4].getMarking().equals("p")&&playBoard.boardSquares[6].getMarking().equals("p")) {
			victory=true;
			System.out.println(8);
		}else if(playBoard.boardSquares[2].getMarking().equals("p")&&playBoard.boardSquares[5].getMarking().equals("p")&&playBoard.boardSquares[7].getMarking().equals("p")) {
			victory=true;	
			System.out.println(9);
		}
		
		//if someone won
		if(victory==true) {
			//C victory
			if(move.equals("computer")) {
				cWins++;
				score.setText("Player wins: "+pWins+"   Computer wins: "+cWins+"   Ties: "+tie);
				System.out.println("The Computer wins");
				System.exit(0);
			//P victory
			}else if (move.equals("player")) {
				pWins++;
				score.setText("Player wins: "+pWins+"   Computer wins: "+cWins+"   Ties: "+tie);
				System.out.println("The Player wins");
				System.exit(0);
			}
		}
		
		//check for a tie
		boolean tieCheck=true;
		for(int i =0;i<9;i++) {
			if(playBoard.boardSquares[i].getMarking().equals("n")) {
				tieCheck=false;
			}
		}
		
		if(tieCheck==true) {
			tie++;
			score.setText("Player wins: "+pWins+"   Computer wins: "+cWins+"   Ties: "+tie);
			System.out.println("Its a tie");
			System.exit(0);
		}
	}
	
	public jerryMain() {
		//setup
		setTitle("Jerry Tac Toe");
		setVisible(true);
		setSize(1400,800);
		addWindowListener(new close());
		
		screen=getContentPane();
		screen.setLayout(new BorderLayout());
		JPanel board=new JPanel();
		board.setLayout(new BorderLayout());
		
		settings=new JPanel();
		settings.setLayout(new BorderLayout());
		
		player=new JButton ("Player");
		player.addActionListener(this);
		computer=new JButton ("Computer");
		computer.addActionListener(this);
		turnSet=new JLabel("Who's turn is first?");
		
		screen.add(computer,("West"));
		screen.add(player,("East"));
		screen.add(turnSet,"Center");
		//choose who plays first
		
		//settings elements
		score =new JLabel("Player wins: "+pWins+"   Computer wins: "+cWins+"   Ties: "+tie);
		reset=new JButton("Reset");
		reset.addActionListener(this);
		
		settings.add(score,"West");
		settings.add(reset,"East");
		
		//playControl setup
		playControls=new JPanel();
		playControls.setLayout(new BorderLayout());
		
		//playControl elements
		squareNum=new JTextField("Square #");
		place=new JButton("Place");
		place.addActionListener(this);
		turn=new JLabel("It is the "+move+"'s turn.");
		
		playControls.add(squareNum,"East");
		playControls.add(place,"West");
		playControls.add(turn,"Center");
		
		//set playing board
		playBoard=new board();
	}
	
	
	public static void main(String []args)throws IOException{
		jerryMain screen=new jerryMain();
		
		
		
	}
}