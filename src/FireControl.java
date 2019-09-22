import java.awt.geom.Point2D;

public class FireControl {
	private GameWorld world;
	private StopWatch timer;
	private Point2D firePoint;
	private boolean firstshoot;
	private double error;

	public FireControl(GameWorld world, StopWatch timer) {
		this.world = (GameWorld) world;
		this.timer = new StopWatch();
		this.error = 0.5 * this.world.getHero().getDiameter();
		this.firstshoot = true;
	}

	public void resetFirstShoot() {
	}


	public void fire(String weaponType) {
		this.firePoint = new Point2D.Double(this.world.getHero().getCenterPoint().getX(),
				this.world.getHero().getCenterPoint().getY() - this.error);
		this.timer.start();
		if (weaponType.equals("Laser")) {
			if (this.timer.getElapsedTime() > 100 || this.firstshoot) {
				this.world.addCreature(new Laser(this.world, firePoint));
				this.timer.reset();
			}
		}
		this.firstshoot = false;
	}
}
