import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		GameWorld myWorld = new GameWorld();
		GameComponent myComponent = new GameComponent(myWorld);
		JFrame frame = new GameFrame(myWorld);

		int resolution_x = (int)(720*myWorld.getScreenIndex());
		int resolution_y = (int)(960*myWorld.getScreenIndex())+80;

		frame.add(myComponent);
		frame.setSize(resolution_x, resolution_y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
