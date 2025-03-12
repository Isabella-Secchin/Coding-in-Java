import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener {

    private final int BOARD_SIZE = 300;   // Size of the game board
    private final int SQUARE_SIZE = 10;   // Size of each square
    private final int NUM_SQUARES = BOARD_SIZE / SQUARE_SIZE;
    private final LinkedList<Point> snake = new LinkedList<>();
    private Point food;
    private char direction = 'R';  // Snake's direction (R = Right, L = Left, U = Up, D = Down)
    private boolean gameOver = false;
    private Timer timer;

    public SnakeGame() {
        setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (gameOver) return;

                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP && direction != 'D') direction = 'U';
                if (keyCode == KeyEvent.VK_DOWN && direction != 'U') direction = 'D';
                if (keyCode == KeyEvent.VK_LEFT && direction != 'R') direction = 'L';
                if (keyCode == KeyEvent.VK_RIGHT && direction != 'L') direction = 'R';
            }
        });

        initializeGame();
    }

    private void initializeGame() {
        snake.clear();
        snake.add(new Point(NUM_SQUARES / 2, NUM_SQUARES / 2));  // Start in the center
        spawnFood();
        timer = new Timer(100, this);  // Speed of the game
        timer.start();
    }

    private void spawnFood() {
        Random rand = new Random();
        food = new Point(rand.nextInt(NUM_SQUARES), rand.nextInt(NUM_SQUARES));

        // Ensure the food doesn't spawn on the snake's body
        while (snake.contains(food)) {
            food = new Point(rand.nextInt(NUM_SQUARES), rand.nextInt(NUM_SQUARES));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        Point head = snake.getFirst();
        Point newHead = null;

        switch (direction) {
            case 'U': newHead = new Point(head.x, head.y - 1); break;
            case 'D': newHead = new Point(head.x, head.y + 1); break;
            case 'L': newHead = new Point(head.x - 1, head.y); break;
            case 'R': newHead = new Point(head.x + 1, head.y); break;
        }

        // Check if the snake collides with walls or itself
        if (newHead.x < 0 || newHead.x >= NUM_SQUARES || newHead.y < 0 || newHead.y >= NUM_SQUARES || snake.contains(newHead)) {
            gameOver = true;
            timer.stop();
        }

        // Move the snake
        snake.addFirst(newHead);
        if (newHead.equals(food)) {
            spawnFood();  // Eat the food and spawn new food
        } else {
            snake.removeLast();  // Remove the last part of the snake if no food is eaten
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the snake
        g.setColor(Color.GREEN);
        for (Point p : snake) {
            g.fillRect(p.x * SQUARE_SIZE, p.y * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
        }

        // Draw the food
        g.setColor(Color.RED);
        g.fillRect(food.x * SQUARE_SIZE, food.y * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);

        // Game over message
        if (gameOver) {
            String message = "Game Over! Press R to Restart";
            g.setColor(Color.WHITE);
            g.drawString(message, BOARD_SIZE / 2 - 50, BOARD_SIZE / 2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame game = new SnakeGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // Center the window
        frame.setVisible(true);

        // Restart the game when R is pressed
        game.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    game.initializeGame();
                    game.gameOver = false;
                    game.timer.start();
                    game.repaint();
                }
            }
        });
    }
}

