package inClass;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pong extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private static final int PADDLE_WIDTH = 10;
    private static final int PADDLE_HEIGHT = 80;
    private static final int BALL_RADIUS = 10;

    private double ballXSpeed = 3;
    private double ballYSpeed = 3;

    private Rectangle leftPaddle, rightPaddle;
    private Circle ball;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT, Color.BLACK);

        // Left paddle
        leftPaddle = new Rectangle(PADDLE_WIDTH, PADDLE_HEIGHT, Color.WHITE);
        leftPaddle.setX(20);
        leftPaddle.setY(HEIGHT / 2 - PADDLE_HEIGHT / 2);

        // Right paddle
        rightPaddle = new Rectangle(PADDLE_WIDTH, PADDLE_HEIGHT, Color.WHITE);
        rightPaddle.setX(WIDTH - 30);
        rightPaddle.setY(HEIGHT / 2 - PADDLE_HEIGHT / 2);

        // Ball
        ball = new Circle(BALL_RADIUS, Color.WHITE);
        ball.setCenterX(WIDTH / 2);
        ball.setCenterY(HEIGHT / 2);

        root.getChildren().addAll(leftPaddle, rightPaddle, ball);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pong Game");
        primaryStage.show();

        // Paddle Movement
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.W && leftPaddle.getY() > 0) {
                leftPaddle.setY(leftPaddle.getY() - 20);
            } else if (event.getCode() == KeyCode.S && leftPaddle.getY() < HEIGHT - PADDLE_HEIGHT) {
                leftPaddle.setY(leftPaddle.getY() + 20);
            }
            if (event.getCode() == KeyCode.UP && rightPaddle.getY() > 0) {
                rightPaddle.setY(rightPaddle.getY() - 20);
            } else if (event.getCode() == KeyCode.DOWN && rightPaddle.getY() < HEIGHT - PADDLE_HEIGHT) {
                rightPaddle.setY(rightPaddle.getY() + 20);
            }
        });

        // Game Loop
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), e -> moveBall()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void moveBall() {
        ball.setCenterX(ball.getCenterX() + ballXSpeed);
        ball.setCenterY(ball.getCenterY() + ballYSpeed);

        // Ball Collision with Walls
        if (ball.getCenterY() <= 0 || ball.getCenterY() >= HEIGHT) {
            ballYSpeed *= -1; // Reverse Y direction
        }

        // Ball Collision with Paddles
        if (ball.getBoundsInParent().intersects(leftPaddle.getBoundsInParent()) ||
                ball.getBoundsInParent().intersects(rightPaddle.getBoundsInParent())) {
            ballXSpeed *= -1; // Reverse X direction
        }

        // Ball Out of Bounds (Scoring)
        if (ball.getCenterX() <= 0 || ball.getCenterX() >= WIDTH) {
            resetBall();
        }
    }

    private void resetBall() {
        ball.setCenterX(WIDTH / 2);
        ball.setCenterY(HEIGHT / 2);
        ballXSpeed = 3 * (Math.random() > 0.5 ? 1 : -1); // Random start direction
        ballYSpeed = 3 * (Math.random() > 0.5 ? 1 : -1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}