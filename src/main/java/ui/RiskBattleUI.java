package ui;

import sun.awt.X11.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

public class RiskBattleUI {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            RiskBattleFrame frame = new RiskBattleFrame(600, 500);
            frame.setVisible(true);
        });
    }
}

class RiskBattleFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private final int width;
    private final int height;

    public RiskBattleFrame() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public RiskBattleFrame(final int width, final int height) {
        this.width = width;
        this.height = height;
        setSize(width, height);
        setLocationInCenter();
    }

    private void setLocationInCenter() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Point screenCenter = new Point(dim.width / 2, dim.height / 2);
        setLocation(screenCenter.x - width / 2, screenCenter.y - height / 2);
    }
}
