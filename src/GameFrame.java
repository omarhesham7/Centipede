import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

	private static final int GAP = 10;
	final protected GameWorld world;
	protected HelpFrame helpframe;

	public GameFrame(GameWorld gameworld) {
		this.world = gameworld;
		this.helpframe = new HelpFrame();
		MouseState movingHero = new MouseState(this.world);
		addMouseMotionListener(movingHero);
		addMouseListener(movingHero);
		setFocusable(true);

		setTitle("Centipede");

		add(buttonComponent(), BorderLayout.PAGE_END);
		setResizable(false);

		pack();

	}

	private JComponent buttonComponent() {
		Box panel = Box.createHorizontalBox();
		panel.setBorder(BorderFactory.createEmptyBorder(0, GAP, GAP, GAP));
		panel.add(Box.createHorizontalGlue());
		JButton quitButton = new JButton("Quit");

		ActionListener quitter = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		};

		quitButton.addActionListener(quitter);

		JButton newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				world.newGame();
				requestFocusInWindow();
			}
		});

		JButton helpButton = new JButton("Help");

		ActionListener helper = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JButton quit = new JButton("Quit");
				quit.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						helpframe.setVisible(false);
						requestFocusInWindow();
						helpframe.dispose();
					}
				});

				helpframe.add(quit, BorderLayout.SOUTH);
				helpframe.setSize(200, 300);
				helpframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				helpframe.setVisible(true);
			}
		};

		JButton musicButton = new JButton("Music");

		ActionListener music = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				requestFocusInWindow();
			}
		};

		musicButton.addActionListener(music);

		helpButton.addActionListener(helper);

		panel.add(musicButton);
		panel.add(helpButton);
		panel.add(quitButton);
		panel.add(newGameButton);
		return panel;
	}
}
