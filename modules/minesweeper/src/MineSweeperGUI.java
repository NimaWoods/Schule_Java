

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MineSweeperGUI {

	private static final int MINSIZE = 10;
	private MineSweeperLogic logicBoard;
	private int size;
	private JFrame f = new JFrame("MineSweeper");
	private ArrayList<JButton> guiBoard = new ArrayList<>();

	public MineSweeperGUI(MineSweeperLogic board) {
		this.logicBoard = board;
		this.setSize(board.getSize());
		init();
	}

	private void setSize(int size) {
		if (size >= MINSIZE)
			this.size = size;
		else {
			this.size = MINSIZE;
			JOptionPane.showMessageDialog(f, "Die Groesse wurde auf das Mindestmass angehoben.");
		}

	}

	private void init() {
		guiBoard.clear();
		JPanel p = new JPanel(new GridLayout(size, size));
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				JButton btn = new JButton();
				guiBoard.add(btn);
				p.add(btn);
				btn.addActionListener(e -> {
					JButton b = (JButton) e.getSource();
					int pos = guiBoard.indexOf(b);
					int row = pos / size;
					int col = pos % size;
					int content = logicBoard.getField(row, col);
					b.setText("" + content);
					f.revalidate();
					f.repaint();
					if (content == 9) {
						JOptionPane.showMessageDialog(b, "GAME OVER");
						f.dispose();
					}
				});
				btn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (SwingUtilities.isRightMouseButton(e)) {
							JButton b = (JButton) e.getSource();
							if (b.isEnabled()) {

								b.setText("B");
								b.setEnabled(false);
							} else {
								b.setText(null);
								b.setEnabled(true);
							}
						}
					}
				});
			}
		}
		f.add(p);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(size * 50, size * 50);
		f.setVisible(true);
	}

}
