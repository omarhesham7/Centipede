import java.awt.geom.Point2D;


public interface Relocatable {

	Point2D getCenterPoint();
	Point2D moveBy(Point2D point,double dx,double dy);

}
