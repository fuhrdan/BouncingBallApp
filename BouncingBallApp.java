import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingBallApp {
    public static void main(String[] args) {
        // Create and set up the window (JFrame)
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Window size 800x600

        // Create the ball panel
        BallPanel panel = new BallPanel();
        frame.add(panel);

        // Display the window
        frame.setVisible(true);

        // Start the animation
        panel.startAnimation();
    }
}

class BallPanel extends JPanel {
    private int ballX = 400, ballY = 300; // Ball starting position in the center
    private int ballRadius = 20; // Ball radius
    private int ballDX = 2, ballDY = 2; // Ball speed (movement per frame)

    public BallPanel() {
        // Set up the background color of the panel
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the ball as a filled circle
        g.setColor(Color.RED); // Set ball color to red
        g.fillOval(ballX - ballRadius, ballY - ballRadius, ballRadius * 2, ballRadius * 2);
    }

    public void startAnimation() {
        // Set up a timer for animation (every 10 milliseconds)
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move the ball
                ballX += ballDX;
                ballY += ballDY;

                // Check for collisions with the window edges
                if (ballX <= ballRadius || ballX >= getWidth() - ballRadius) {
                    ballDX = -ballDX; // Reverse horizontal direction
                }
                if (ballY <= ballRadius || ballY >= getHeight() - ballRadius) {
                    ballDY = -ballDY; // Reverse vertical direction
                }

                // Redraw the panel
                repaint();
            }
        });

        // Start the timer (animation loop)
        timer.start();
    }
}
