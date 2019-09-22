import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Spider extends Creature {
	private StopWatch timer;
	private Random randomizer;
	private int closeDis;
	private int mediumDis;
	private int damage;

	public Spider(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.timer = new StopWatch();
		timer.start();
		this.randomizer = new Random();
		this.color = Color.RED;
		this.speedx = 2 * (1 - 2 * randomizer.nextDouble()) * this.getWorld().getlevel().getlevel();
		this.speedy = 2 * (1 - 2 * randomizer.nextDouble()) * this.getWorld().getlevel().getlevel();
		this.diameter = 30;
		this.getWorld().setisSpider(true);
		this.setCenterPoint(centerPoint);
		this.closeDis = (int) (30 * this.getWorld().getScreenIndex());
		this.mediumDis = (int) (70 * this.getWorld().getScreenIndex());
		this.damage = 0;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void collide(Creature m) {
		m.collideWithSpider(this);

	}

	@Override
	public void collideWithMushroom(Mushroom m) {

	}

	@Override
	public void collideWithCentipede(Centipede m) {

	}

	@Override
	public void collideWithHero(Hero m) {

	}


	@Override
	public void collideWithSpider(Spider m) {

	}

	@Override
	public void collideWithBullet(Bullet m) {
		this.getWorld().getCurrentPlayer().addScore(50);
		this.damage++;
		if (this.damage == 4){
			this.getWorld().getCurrentPlayer().addScore(500);
			this.getWorld().setisSpider(false);
			this.die();
		}
	}

	@Override
	public void updatePosition() {
		if (timer.getElapsedTime() > 500) {
			this.speedx = 2 * (1 - 2 * randomizer.nextDouble()) * this.getWorld().getlevel().getlevel();
			this.speedy = 2 * (1 - 2 * randomizer.nextDouble()) * this.getWorld().getlevel().getlevel();
			timer.reset();
			timer.start();
		}

		Point2D newPoint = this.moveBy(speedx, speedy);
		if (this.getWorld().getHeight() / 2 > newPoint.getY()
				|| newPoint.getY() > this.getWorld().getHeight() - this.diameter / 2) {
			speedy = -speedy;
		}
		this.setCenterPoint(this.moveBy(speedx, speedy));

		if (!this.isInsideWorld()) {
			this.getWorld().setisSpider(false);
			this.die();
		}
	}

	@Override
	public void updateSize() {

	}

	@Override
	public void updateColor() {

	}

	@Override
	public double getDiameter() {
		return this.diameter;
	}

	@Override
	public String getClassName() {
		return "Spider";
	}

	@Override
	public BufferedImage getImage() {
		try {
			return ImageIO.read(new File("Files" + File.separator + "Spider.png"));
		} catch (IOException exception) {
			System.out.println("eRROR");
		}
		return null;
	}

	@Override
	public double getX() {
		return this.getCenterPoint().getX() - this.diameter / 2;
	}

	@Override
	public double getY() {
		return this.getCenterPoint().getY() - this.diameter / 2;
	}

	@Override
	public int getType() {
		return 1;
	}


}
