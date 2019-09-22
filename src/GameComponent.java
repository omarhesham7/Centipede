import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JComponent;


public class GameComponent extends JComponent {

	private static final int FRAMES_PER_SECOND = 30;
	private static final long REPAINT_INTERVAL_MS = 1000 / FRAMES_PER_SECOND;

	private GameWorld world;

	public GameComponent(GameWorld world) {
		this.world = world;
		Runnable repainter = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(REPAINT_INTERVAL_MS);
						repaint();
					}
				} catch (InterruptedException exception) {
				}
			}
		};
		new Thread(repainter).start();
	}

        @Override
	protected void paintComponent(Graphics g) {
		int px = 15;
		int py = 30;
		int ly = 60;
		int liy = 90;
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.scale(this.world.getScreenIndex(), this.world.getScreenIndex());

		drawDrawable(g2, this.world, this.world.getType());

		List<Drawable> drawableParts = this.world.getDrawableParts();
		for (Drawable d : drawableParts) {
			if (d.getType() == 0) {
				drawDrawable(g2, d, 0);
			}
			if (d.getType() == 1) {
				drawDrawable(g2, d, 1);
			}
			if (d.getType() == 2) {
				drawDrawable(g2, d, 2);
			}
		}

		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.setColor(Color.PINK);
		if (!this.world.hasCentipede() && !this.world.isFail()){
			g.drawString("Score: " + Integer.toString((int) this.world.getCurrentPlayer().getScore() + 600), px, ly);
		}
		else{
			g.drawString("Score: " + Integer.toString((int) this.world.getCurrentPlayer().getScore()), px, ly);
		}

		g.setFont(new Font("Serif", Font.BOLD, 30));

		if (this.world.getCurrentPlayer().getLives() != -1){
			g.drawString("Lives: " + Integer.toString(this.world.getCurrentPlayer().getLives()), px, liy);
		}

		int font1 = 75;
		int font2 = 45;
		int n1y = 450;
		int p1x = 210;
		int p1y = 520;
		int p2y = 565;
    if (!this.world.hasCentipede() && !this.world.isFail()){
    	g.setFont(new Font("Serif", Font.BOLD, font1));
		 	g.drawString("VICTORY", (int) (188), n1y);
			g.setFont(new Font("Serif", Font.BOLD, font2));
		 	this.world.setIsPaused(true);

    }
		if (this.world.isFail()) {
			g.drawString("Lives: " + Integer.toString(0), px, liy);
			g.setFont(new Font("Serif", Font.BOLD, font1));
			g.drawString("GAME OVER", (int) (128), n1y);
			g.setFont(new Font("Serif", Font.BOLD, font2));
			this.world.setIsPaused(true);
		}
	}

	private void drawDrawable(Graphics2D g2, Drawable d, int i) {
		if (i == 0) {
			Color color = d.getColor();
			Shape shape = d.getShape();
			g2.setColor(color);
			g2.fill(shape);
		}
		if (i == 1) {
			int widthOne = 30;
			BufferedImage img = d.getImage();
			g2.drawImage(img, (int) d.getX(), (int) d.getY(), widthOne, widthOne, null);
		}
		if (i == 2) {
			int widthTwo = 150;
			BufferedImage img = d.getImage();
			g2.drawImage(img, (int) d.getX(), (int) d.getY(), widthTwo, widthTwo, null);

			Color color = d.getColor();
			Shape shape = d.getShape();
			g2.setColor(color);
			g2.fill(shape);
		}
		if (i == 3) {
			int widthThree = 720;
			int heightThree = 960;
			BufferedImage img = d.getImage();
			g2.drawImage(img, 0, 0, widthThree, heightThree, null);
		}

	}

}
