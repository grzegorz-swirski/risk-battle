package ui;

import battle.Battle;
import battle.BattleResult;
import participants.Attacker;
import participants.Defender;

import javax.swing.*;
import java.awt.*;

public class RiskBattleFrame extends JFrame {

    private Container contentPane;
    private JTextField attackerArmySizeTextField;
    private JTextField defenderArmySizeTextField;
    private JTextArea battleResultTextArea;
    private JButton executeBattleButton;

    public RiskBattleFrame() {
        setProperties();
        contentPane = getContentPane();
        createAndAddComponents(contentPane);
        pack();
    }

    private void setProperties() {
        setPreferredSize(new Dimension(300, 150));
        setTitle("Risk battle");
        setLayout(new FlowLayout());
        setLocationRelativeTo(null); // sets frame location to the center of the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createAndAddComponents(Container contentPane) {
        attackerArmySizeTextField = new JTextField(20);
        contentPane.add(attackerArmySizeTextField);

        defenderArmySizeTextField = new JTextField(20);
        contentPane.add(defenderArmySizeTextField);

        battleResultTextArea = new JTextArea(2, 20);
        contentPane.add(battleResultTextArea);


        executeBattleButton = new JButton("Execute battle");
        executeBattleButton.addActionListener(event -> {
            Attacker attacker = new Attacker(Integer.parseInt(attackerArmySizeTextField.getText()));
            Defender defender = new Defender(Integer.parseInt(defenderArmySizeTextField.getText()));
            Battle battle = new Battle(attacker, defender);
            BattleResult result = battle.execute();
            battleResultTextArea.setText(result.toString());
        });
        contentPane.add(executeBattleButton);
    }
}
