import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


public abstract class Creature implements Drawable, Temporal, Relocatable {
	private Point2D centerPoint;
	private GameWorld world;
	protected double speedx, speedy;
	protected Color color;
	protected double diameter;
	public int collideNum;


	public Creature(GameWorld world) {
		this(world, new Point2D.Double());
	}


	public Creature(GameWorld world, Point2D centerPoint) {
		this.world = world;
		this.centerPoint = centerPoint;
	}

	protected void setCenterPoint(Point2D centerPoint) {
		this.centerPoint = centerPoint;
	}

	protected GameWorld getWorld() {
		return this.world;
	}

	protected boolean isInsideWorldX() {
		return this.getCenterPoint().getX() >= 0
				&& this.getCenterPoint().getX() <= this.getWorld().getSize().getWidth();
	}

	protected boolean isInsideWorldY() {
		return this.getCenterPoint().getY() >= 0
				&& this.getCenterPoint().getY() <= this.getWorld().getSize().getHeight();
	}

	protected boolean isInsideWorld() {
		return isInsideWorldX() && isInsideWorldY();
	}


	protected boolean isInsideWorldCX() {
		return this.getCenterPoint().getX() >= 0
				&& this.getCenterPoint().getX() <= this.getWorld().getSize().getWidth();
	}

	protected boolean isInsideWorldCY() {
		return this.getCenterPoint().getY() >= 0
				&& this.getCenterPoint().getY() <= 645;
	}

	protected boolean isInsideWorldC() {
		return isInsideWorldCX() && isInsideWorldCY();
	}

	@Override
	public void timePassed() {
		updateColor();
		updateSize();
		updatePosition();
	}

	@Override
	public void die() {
		this.world.removeCreature(this);
	}

	@Override
	public boolean getIsPaused() {
		return false;
	}

	@Override
	public void setIsPaused(boolean isPaused) {
	}


	@Override
	public Shape getShape() {
		double x = getCenterPoint().getX();
		double y = getCenterPoint().getY();
		double size = getDiameter();
		return new Ellipse2D.Double(x - size / 2, y - size / 2, size, size);
	}

	@Override
	public Point2D getCenterPoint() {
		return this.centerPoint;
	}

	@Override
	public Point2D moveBy(Point2D point, double dx, double dy) {
		double newX = point.getX() + dx;
		double newY = point.getY() + dy;
		return new Point2D.Double(newX, newY);
	}


	public Point2D moveBy(double dx, double dy) {
		double newX = this.getCenterPoint().getX() + dx;
		double newY = this.getCenterPoint().getY() + dy;
		return new Point2D.Double(newX, newY);
	}


	public abstract void collide(Creature m);

	public abstract void collideWithMushroom(Mushroom m);

	public abstract void collideWithCentipede(Centipede m);

	public abstract void collideWithHero(Hero m);

	public abstract void collideWithSpider(Spider m);

	public abstract void collideWithBullet(Bullet m);

	public abstract void updatePosition();

	public abstract void updateSize();

	public abstract void updateColor();

	public abstract double getDiameter();

	public String getClassName() {
		return null;
	}
}
