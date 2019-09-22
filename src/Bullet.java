import java.awt.Color;
import java.awt.geom.Point2D;



public abstract class Bullet extends Creature {

	protected Color color;
	protected int direction;

	public Bullet(GameWorld world, Point2D centerPoint) {
		super(world, centerPoint);
		this.diameter = 22.5;
		this.color = Color.YELLOW;
		this.setCenterPoint(centerPoint);
	}

	public int getDirection() {
		return this.direction;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void updatePosition() {
		this.setCenterPoint(this.moveBy(getCenterPoint(), this.speedx, -this.speedy));
		if (!this.isInsideWorld()) {
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
		return "Bullet";
	}

}
