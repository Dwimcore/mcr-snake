package manager;

import handler.snakeHandler.Head;
import handler.snakeHandler.Tail;
import manager.edible.Food;
import request.DisplayRequest;


import java.util.*;


/**
 * this class manage the snake
 */
public class SnakeManager {

    private static SnakeManager instance = null;

    //TODO: linkedList pour avoir getLast?
    private LinkedList<Coordinate> snake = new LinkedList<>();
    private Map<Food, Coordinate> food = new HashMap<>();
    private Head head;
    private DisplayRequest displayRequest;

    //TODO: edit les tailles
    private static final int MAXBOARDWIDTH = 100;
    private static final int MAXBOARDLEGHT = 100;
    private Direction direction;
    private int speedMultiplicator;

    private int score;
    private boolean alive;

    public static SnakeManager getInstance() {
        if(instance == null) {
            instance = new SnakeManager();
        }
        return instance;
    }

    /**
     * Default constructor
     */
    public SnakeManager() {
        //TODO: de base apparait au millieu
        // TODO : ajouter la coord de la queue ???
        snake.add(new Coordinate(MAXBOARDLEGHT / 2, MAXBOARDWIDTH / 2));
        //ajoute une tête
        head = new Head(new Tail(head));
        //TODO: de base se déplace vers la gauche
        direction = Direction.LEFT;

        displayRequest = new DisplayRequest();

        score = 0;
        speedMultiplicator = 1;
        alive = true;
    }

    private void addSnakeCoordinate() {
        //TODO: nouvelle élement toujours a droite
        snake.addFirst(new Coordinate(snake.getFirst().getX() + direction.toCoordinate().getX(),
                snake.getFirst().getY() + direction.toCoordinate().getY()));
    }

    private void move() {
        head.handle(displayRequest);
        addSnakeCoordinate();

        while (displayRequest.getColors().size() < snake.size() - 2)
            snake.remove(snake.getLast());
    }

    private void generateFood() {
        // TODO : add food to food list
        // TODO : need Fabrics
    }

    public void nextTurn() {
        //TODO: utilser avec direction
    }

    public DisplayRequest getDisplayRequest() {
        return displayRequest;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSpeedMultiplicator() {
        return speedMultiplicator;
    }

    public void setSpeedMultiplicator(int speed) {
        speedMultiplicator = speed;
    }

    public void addPoints(int points) {
        score += points;

        if(score < 0) {
            alive = false;
        }
    }
}