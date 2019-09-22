import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class Hero extends Creature {

	private double diameter;
	private boolean isAlive;

	public Hero(GameWorld world, Point2D center) {
		super(world, center);
		this.diameter = 30*this.getWorld().getScreenIndex();
		this.color = Color.YELLOW;
		this.speedx = 0;
		this.speedy = 0;
		this.isAlive = true;
		this.setCenterPoint(center);
	}

	public void setSpeedx(double speed) {
		this.speedx = speed;
	}

	public void setSpeedy(double speed) {
		this.speedy = speed;
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public void setMovingLimit() {

		Point2D newPoint = this.moveBy(this.speedx, this.speedy);
		if (this.diameter/2 > newPoint.getX() || newPoint.getX() > this.getWorld().getWidth()-this.diameter/2) {
			newPoint = this.moveBy(newPoint, -speedx, 0);
		}
		if (2*this.getWorld().getHeight()/3 > newPoint.getY() || newPoint.getY() > this.getWorld().getHeight()-this.diameter/2) {
			newPoint = this.moveBy(newPoint, 0, -speedy);
		}
		this.setCenterPoint(newPoint);
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void updatePosition() {
		this.setMovingLimit();
		this.setCenterPoint(this.getCenterPoint());
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
		return "Hero";
	}

	@Override
	public void collide(Creature m) {
		m.collideWithHero(this);
	}

	@Override
	public void collideWithMushroom(Mushroom m) {
	}

	@Override
	public void collideWithCentipede(Centipede m) {
		this.isAlive = false;
	}

	@Override
	public void collideWithHero(Hero m) {

	}

	@Override
	public void collideWithBullet(Bullet m) {
		if (m.getDirection() < 0) {
			this.isAlive = false;
		}
	}


	@Override
	public void collideWithSpider(Spider m) {
		this.isAlive = false;
	}


	@Override
	public BufferedImage getImage() {
		return FileHandler.getImageFile(File.separator+"Centipede_blaster");
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
