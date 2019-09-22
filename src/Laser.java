import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Laser extends Bullet {

	public Laser(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.speedx = 0;
		this.speedy = 9;
		this.color = Color.LIGHT_GRAY;
		this.direction = 1;

		this.getWorld().getMusicBox().bulletSound("Laser");
	}

	@Override
	public Shape getShape() {
		return new Rectangle2D.Double(this.getCenterPoint().getX(), this.getCenterPoint().getY(),
				this.getDiameter() / 3, this.getDiameter());
	}

	@Override
	public void collide(Creature m) {
		m.collideWithBullet(this);

	}

	@Override
	public void collideWithMushroom(Mushroom m) {
		this.die();

	}

	@Override
	public void collideWithCentipede(Centipede m) {
		this.die();

	}

	@Override
	public void collideWithHero(Hero m) {

	}

	@Override
	public void collideWithBullet(Bullet m) {

	}


	@Override
	public void collideWithSpider(Spider m) {
		this.die();
	}


	@Override
	public BufferedImage getImage() {
		return null;
	}

	@Override
	public double getX() {
		return 0;
	}

	@Override
	public double getY() {
		return 0;
	}

	@Override
	public int getType() {
		return 0;
	}

}
