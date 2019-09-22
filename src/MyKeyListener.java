import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyKeyListener implements KeyListener {

	private GameWorld world;
	private int weaponType;
	private FireControl fireControl;

	public MyKeyListener(GameWorld world) {
		this.world = world;
		this.weaponType = 1;
		this.fireControl = new FireControl(world, new StopWatch());
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == 38) {// Up for moving up
			this.world.getHero().setSpeedy(-3);
		} else if (e.getKeyCode() == 40) {// Down for moving down
			this.world.getHero().setSpeedy(3);
		} else if (e.getKeyCode() == 37) {// Left for moving left
			this.world.getHero().setSpeedx(-3);
		} else if (e.getKeyCode() == 39) {// Right for moving right
			this.world.getHero().setSpeedx(3);
		} else if (e.getKeyCode() == 32) {// Space for firing
			if (this.world.getHero().isAlive()) {
				if (this.weaponType == 1) {
					this.fireControl.fire("Laser");
				}
			}

		} else if (e.getKeyCode() == 49) {
			this.weaponType = 1;
			this.fireControl.resetFirstShoot();
		} else if (e.getKeyCode() == 50) {
			this.weaponType = 2;
			this.fireControl.resetFirstShoot();
		} else if (e.getKeyCode() == 51) {
			this.weaponType = 3;
			this.fireControl.resetFirstShoot();
		} else if (e.getKeyCode() == 85) {// "U" for moving to next level
			this.world.getlevel().increaselevel();
			this.world.setBegin(true);
			this.world.renderLevel();
		} else if (e.getKeyCode() == 68) {// "D" for moving to last level
			this.world.getlevel().decreaselevel();
			this.world.setBegin(true);
			this.world.renderLevel();
		} else if (e.getKeyCode() == 80) {// "P" for Pause
			this.world.setIsPaused(!this.world.getIsPaused());
		} else if (e.getKeyCode() == 52 ) {
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 38 || e.getKeyCode() == 40) {// Up&Down
			this.world.getHero().setSpeedy(0);
		} else if (e.getKeyCode() == 37 || e.getKeyCode() == 39) {// Left&Right
			this.world.getHero().setSpeedx(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
