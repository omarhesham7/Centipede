import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;



public class MouseState implements MouseMotionListener, MouseListener {

	private GameWorld world;
	private int weaponType;
	private FireControl fireControl;
  private int mx;
  private int my;

	public MouseState(GameWorld world) {
		this.world = world;
		this.weaponType = 1;
		this.fireControl = new FireControl(world, new StopWatch());
                this.mx = 0;
                this.my = 0;

	}

	@Override
	public void mouseMoved(MouseEvent e) {
            mx = e.getX() + 10;
            my = e.getY() + 10;
            Point2D newPoint = new Point2D.Double(mx, my);
            // this.world.getHero().setCenterPoint(e.getLocationOnScreen());
            this.world.getHero().setCenterPoint(newPoint);
            // System.out.println("x: " + e.getX());
            // System.out.println("y: " + e.getY());
  }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
          if (this.world.getHero().isAlive()) {
  				if (this.weaponType == 1) {
  					this.fireControl.fire("Laser");
  				}
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
