import csta.ibm.pong.GameObject;

public class Paddle extends GameObject{
	/** Creates a paddle
	 * @param x is x-coordinate of paddle
	 */
	public Paddle(int x){
		setX(getX() + x);
		setSize(10, 125);
	}

	public void act(){}

	/**
	 * Raises paddle
	 */
	public void up(){
		if(getY() > 0)
			setY(getY() - 10);
	}

	/**
	 * Lowers paddle
	 */
	public void down(){
		if(getY() < 320)
			setY(getY() + 10);
	}
}
