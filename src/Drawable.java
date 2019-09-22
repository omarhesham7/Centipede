import java.awt.Color;
import java.awt.Shape;
import java.awt.image.BufferedImage;

public interface Drawable {

	Color getColor();

	Shape getShape();

	BufferedImage getImage();

	double getX();

	double getY();

	int getType();

}
