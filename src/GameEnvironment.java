import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.List;

public interface GameEnvironment {

	void addCreature(Creature ball);

	void removeCreature(Creature ball);

	boolean isInsideWorldX(Point2D point);

	boolean isInsideWorldY(Point2D point);

	boolean isInsideWorld(Point2D point);

	Dimension getSize();

	public List<Drawable> getDrawableParts();

	Point2D getCenterPoint();

 boolean isInsideWorldC(Point2D point);
 boolean isInsideWorldCX(Point2D point);
 boolean isInsideWorldCY(Point2D point);

}
