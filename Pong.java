import java.awt.Dimension;
import java.util.ArrayList;
import csta.ibm.pong.Game;

public class Pong extends Game{
	
	/**
	 * Creates Ball objects.
	 * Creates Paddle objects.
	 * New ArrayList<Ball> for convenience
	 * 
	 */
	Ball b = new Ball(10, 10);
	Ball b2 = new Ball(20, 20);
	Ball b3 = new Ball(30, 30);
	Ball b4 = new Ball(40, 40);
	ArrayList<Ball> bal = new ArrayList<Ball>();
	Paddle pa = new Paddle(20);
	Paddle pa2 = new Paddle(962);

	/** Called during initial setup
	 * 	Adds paddles and balls to the game.
	 * 	Adds balls to ArrayList
	 * @see csta.ibm.pong.Game#setup()
	 */
	public void setup(){
		add(pa);
		add(pa2);
		bal.add(b);
		bal.add(b2);
		bal.add(b3);
		bal.add(b4);
		for(Ball ball : bal){
			add(ball);
		}
	}
	
	/** Called every millisecond.
	 *  Checks if keys (Z, X, N, M) are pressed. If so, moves paddle. 
	 *  Checks if balls collide into paddles.
	 * @see csta.ibm.pong.Game#act()
	 */
	public void act(){
		if(ZKeyPressed())
			pa.up();
		if(XKeyPressed())
			pa.down();
		if(NKeyPressed())
			pa2.up();
		if(MKeyPressed())
			pa2.down();
		for(Ball ball : bal){
			if(ball.collides(pa))
				ball.left();
			if(ball.collides(pa2))
				ball.right();
		}
	}

	public static void main(String[] args){
		Pong p = new Pong();
		p.setVisible(true);
		p.initComponents();
		p.setSize(new Dimension(1000, 500));
		p.setLocationRelativeTo(null);
		p.setResizable(false);
	}
}
