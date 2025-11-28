import java.awt.*;
import javax.swing.*;

public class MineSweeperGUI extends JFrame {

    private final MineSweeperLogic logic;
    private JPanel bodyPanel;

    public MineSweeperGUI(MineSweeperLogic logic) {
        this.logic = logic;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        add(getHeaderPanel(), BorderLayout.NORTH);

        bodyPanel = new JPanel();
        add(bodyPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel getHeaderPanel() {
        JTextField gridSelectionInput = new JTextField(10);
        JLabel errorMessage = new JLabel();
        JButton startGameButton = getStartGameButton(gridSelectionInput, errorMessage);

        JButton undoButton = new JButton();
        undoButton.setText("Undo");

        JButton redoButton = new JButton();
        redoButton.setText("Redo");

        JButton resetButton = getResetButton();

        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));

        header.add(gridSelectionInput);
        header.add(startGameButton);
        header.add(resetButton);
        header.add(undoButton);
        header.add(redoButton);
        header.add(errorMessage);

        return header;
    }

    private JButton getResetButton() {
        JButton resetButton = new JButton();
        resetButton.setText("Reset");
        resetButton.addActionListener(event -> {
            bodyPanel.removeAll();
            bodyPanel.setLayout(new GridLayout());
            bodyPanel.revalidate();
            bodyPanel.repaint();
        });
        return resetButton;
    }

    private JButton getStartGameButton(JTextField gridSelectionInput, JLabel errorMessage) {
        JButton startGameButton = new JButton("Start");
        startGameButton.addActionListener(event -> {
            try {
                int size;
                try {
                    size = Integer.parseInt(gridSelectionInput.getText());
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Keine Nummer", e);
                }
                logic.setup(size);
                createBoard();
            } catch (Exception e) {
                errorMessage.setText(e.getMessage());
            }
        });
        return startGameButton;
    }

    private void createBoard() {
        bodyPanel.removeAll();
        int size = logic.getSize();
        bodyPanel.setLayout(new GridLayout(size, size));

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                JButton cellButton = new JButton();

                int finalRow = row;
                int finalCol = col;

                cellButton.addActionListener(e -> {
                    String result = logic.revealCell(finalRow, finalCol);
                    cellButton.setText(result);
                    cellButton.setEnabled(false);

                    logic.addToHistory(finalRow, finalCol);

                    if (logic.isGameOver(finalRow, finalCol)) {
                        JOptionPane.showMessageDialog(this, "Game Over!");
                    }
                });

                cellButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mousePressed(java.awt.event.MouseEvent evt) {
                        if (SwingUtilities.isRightMouseButton(evt)) {
                            logic.toggleFlag(finalRow, finalCol);
                            cellButton.setText(logic.isFlagged(finalRow, finalCol) ? "🚩" : "");
                        }
                    }
                });

                bodyPanel.add(cellButton);
            }
        }

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }
}
