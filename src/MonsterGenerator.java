import java.awt.geom.Point2D;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonsterGenerator implements Runnable {
	private GameWorld world;
	private Lock changeLock;
	private Condition condition;
	private Spider mySpider;
	private Level level;

	public MonsterGenerator(GameWorld world, Level lel) {
		this.world = world;
		this.changeLock = new ReentrantLock();
		this.condition = this.changeLock.newCondition();
		this.level = lel;
	}

	public void generateOtherEnermy(int difficulty) {
		Random random = new Random();
		double dice = random.nextInt(100);

		double startx = 15;
		double diff = 30;

		if (difficulty == 4) {
		} else {
			if (dice < 10 + difficulty * difficulty * difficulty) {// Spider
				if (!this.world.isSpider()) {
					this.mySpider = new Spider(this.world,
							new Point2D.Double(120 + diff * random.nextInt(8), 550 + diff * random.nextInt(11)));
					this.world.addCreature(mySpider);
				}
			}
		}
	}

	@Override
	public void run() {
		this.changeLock.lock();
		try {
			while (!this.world.getIsPaused()) {
				Thread.sleep(1000);
				this.generateOtherEnermy(this.world.getlevel().getlevel());
			}
		} catch (InterruptedException ex) {

		} finally {
			this.changeLock.unlock();
		}

	}

}
