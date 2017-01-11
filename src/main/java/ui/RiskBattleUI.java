package ui;

import javax.swing.*;
import java.awt.*;

public class RiskBattleUI {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new RiskBattleFrame();
            frame.setVisible(true);
        });
    }
}


