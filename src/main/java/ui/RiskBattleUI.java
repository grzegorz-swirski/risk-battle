package ui;

import battle.Battle;
import participants.Attacker;
import participants.Defender;

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


