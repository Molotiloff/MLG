package main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Game {

    public static void main(String[] args) throws Exception {

        JFrame window = new JFrame("Magic Labirinth Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}