import csta.ibm.pong.GameObject;

public class Ball extends GameObject{
	/**
	 * Speed - Speed of ball
	 * xx - Speed the ball is going on the x-axis
	 * yy - Speed the ball is going on the y-axis
	 * leftPoint - Score for left side
	 * rightPoint - Score for right side
	 * gameInProgress - Whether the game is finished or not.
	 */
	private int speed = 4, xx = speed, yy = speed, leftPoint = 0, rightPoint = 0;
	boolean gameInProgress = true;

	/** Creates a ball
	 * @param x is x-coordinate
	 * @param y is y-coordinate
	 */
	public Ball(int x, int y){
		setX(x);
		setY(y);
		setSize(15, 15);
	}

	/**
	 * Do not call. Moves the ball and sets location of ball.
	 * 
	 * @see csta.ibm.pong.GameObject#act()
	 */
	public void act(){
		if(gameInProgress){
			moveBall();
			bounce();
		}
	}

	/**
	 * Changes the ball's direction.
	 */
	public void bounce(){
		checkWin();
		if(getX() >= 980)
			rightLose();
		if(getY() >= 435)
			down();
		if(getX() <= 0)
			leftLose();
		if(getY() <= 0)
			up();
	}

	/**
	 * Run when right loses.
	 */
	public void rightLose(){
		leftPoint++;
		System.out.println("Left scores point. Total: " + leftPoint);
		right();
	}

	/**
	 * Run when left loses.
	 */
	public void leftLose(){
		rightPoint++;
		System.out.println("Right scores point. Total: " + rightPoint);
		left();
	}

	
	/**
	 * Checks victory
	 */
	public void checkWin(){
		if((leftPoint == 2 || rightPoint == 2) && gameInProgress){
			gameInProgress = false;
			System.out.println("GAME END. WINNER: PLAYER ON THE " + (leftPoint == 2 ? "LEFT" : "RIGHT"));
			Pong pong = new Pong();
			// TO BE ADDED LATER
			if(leftPoint == 2)
				pong.p1Wins();
			else
				pong.p2Wins();
			// System.exit(0);
		}
	}

	/**
	 * Moves the ball right.
	 */
	public void right(){
		xx = -speed;
	}

	/**
	 * Moves the ball left.
	 */
	public void left(){
		xx = speed;
	}

	/**
	 * Moves the ball up.
	 */
	public void up(){
		yy = speed;
	}

	/**
	 * Moves the ball down.
	 */
	public void down(){
		yy = -speed;
	}

	
	/**
	 * Moves ball at constant speed
	 */
	private void moveBall(){
		setX(getX() + xx);
		setY(getY() + yy);
	}
}
