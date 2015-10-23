package component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class ToolTip {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TopLevelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar greenMenuBar = new JMenuBar();

        JLabel yellowLabel = new JLabel();
        JToolTip jToolTip = new JToolTip();
        yellowLabel.setOpaque(true);		// true 불투명, false 투명
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        frame.setJMenuBar(greenMenuBar);
        frame.getContentPane().add(yellowLabel, BorderLayout.CENTER);
        frame.pack();			// 컴포넌트들을 묶음
        frame.setVisible(true);	// 보여주기
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
