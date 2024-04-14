package pegasus;

import pegasus.number.Int2;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final JFrame frame = new JFrame("Vortex Engine");
    private static final JPanel panel = new JPanel() {
        @Override
        public void paint(Graphics g) {

        }
    };

    static {
        frame.add(panel);
    }

    public static void main(String[] args) {
        var x = new Int2(1, 2);
        var y = new Int2(5, 6);

        System.out.println(x.add(y));
        System.out.println(x.add(23, 2));
    }
}