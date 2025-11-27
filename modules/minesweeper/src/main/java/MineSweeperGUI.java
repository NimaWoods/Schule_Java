

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

public class MineSweeperGUI extends JFrame {

    MineSweeperLogic logic;
    JPanel bodyPanel;

    public MineSweeperGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setLayout(new BorderLayout());

        add(getHeaderPanel(), BorderLayout.NORTH);

        bodyPanel = getBodyPanel();
        add(bodyPanel, BorderLayout.SOUTH);
    }

    private static JPanel getHeaderPanel() {
        JPanel header = new JPanel();

        JTextField gridSelection = new JTextField();
        gridSelection.setSize(100,100);
        header.add(gridSelection);

        JButton startGameButton = new JButton();
        startGameButton.setText("Test");
        header.add(startGameButton);
        return header;
    }

    private static JPanel getBodyPanel() {
        JPanel body = new JPanel(new GridLayout());
        return body;
    }

    public void setLogic(MineSweeperLogic logic) {
        this.logic = logic;
    }
}
