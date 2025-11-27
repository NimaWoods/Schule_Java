

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MineSweeperGame {
	private static final int MINSIZE = 10;
	private MineSweeperGUI gui;
	private MineSweeperLogic logic;
	private JFrame f = new JFrame("Minesweeper");
	private JTextField inputSize= new JTextField();
	private int size = 10;
	
	public MineSweeperGame(int gridLength) {
		this.setSize(gridLength);
		newGame(size);
	}
	private void setSize(int size) {
		if (size >= MINSIZE)
			this.size = size;
		else {
			this.size = MINSIZE;
			JOptionPane.showMessageDialog(f, "Die Groesse wurde auf das Mindestmass 10 angehoben.");
		}

	}
	public void newGame(int gridLength) {

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,3) );
		f.add(p);
		p.add(new JLabel("Enter the size of the game grid:"));
		p.add(inputSize);
		JButton btn =new JButton("Start Game");
		btn.addActionListener(e->{
			try {
				this.setSize(Integer.parseInt(inputSize.getText()));
				logic = new MineSweeperLogic(size);
				logic.consoleOut();
				gui = new MineSweeperGUI(logic);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(f, "Das ist keine ganze Zahl. Versuche es nochmal.");
			}
		});
		p.add(btn);
		f.pack();
		f.setVisible(true);


	}
}
