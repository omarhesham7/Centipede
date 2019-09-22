import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class Mushroom extends Creature implements Drawable, Temporal, Relocatable {
	private String name;
	private int destruction;
	private boolean isPostioned;
	private BufferedImage image;
	private Level level;
	// public int collideNum;

	public Mushroom(GameWorld world, Point2D centerPoint,Level lel) {
		super(world, centerPoint);
		this.name = "Mushroom";
		this.diameter = 30;
		this.destruction = 0;
		this.isPostioned = false;
		this.level = lel;
		collideNum = 0;
	}

	public boolean isPostioned() {
		return this.isPostioned;
	}

	public void setPostioned(boolean isPostioned) {
		this.isPostioned = isPostioned;
	}

	@Override
	public Color getColor() {
		return Color.CYAN;
	}

	@Override
	public void updatePosition() {

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
		return this.name;
	}

	@Override
	public Shape getShape() {
		double x = getCenterPoint().getX();
		double y = getCenterPoint().getY();
		double size = getDiameter();
		return new Rectangle2D.Double(x - size / 2, y - size / 2, size, size * this.destruction);
	}

	@Override
	public void collide(Creature m) {
		m.collideWithMushroom(this);

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
	 public void collideWithBullet(Bullet m) {
	 	if (!m.getClassName().equals("APBeam")){
	 		this.destruction++;
			if (this.destruction != 6){
				collideNum++;
			}
			this.getWorld().getCurrentPlayer().addScore(0.5);

	 	}
	 	if (this.destruction == 6) {
	 		this.getWorld().getCurrentPlayer().addScore(5);
	 		this.die();
	 	}
	 }


	@Override
	public void collideWithSpider(Spider m) {
		this.die();
	}


	@Override
	public BufferedImage getImage() {
		int currentDiff=this.getWorld().getlevel().getlevel();
		if (this.isPostioned) {
			this.image = FileHandler.getImageFile(File.separator + "poisonmushroomL"+Integer.toString(currentDiff)+Integer.toString(this.destruction));
		} else {
			this.image = FileHandler.getImageFile(File.separator + "mushroomL"+Integer.toString(currentDiff)+Integer.toString(this.destruction));
		}
		return this.image;
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
