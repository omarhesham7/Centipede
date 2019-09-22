
public class Player {
	private double score;
	private int lives;
	private boolean winning;
	private int number;

	public Player(int number) {
		this.score = 0;
		this.lives = 3;
		this.winning = false;
		this.number = number;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getLives() {
		return this.lives;
	}

	public void increaseLives(int lives) {
		this.lives += lives;
	}

	public void decreaseLives(int lives) {
		this.lives -= lives;
	}

	public boolean isWinning() {
		return this.winning;
	}

	public void setWinning(boolean winning) {
		this.winning = winning;
	}

	public void setScore(double score) {
		this.score=score;
	}

	public double getScore() {
		return this.score;
	}

	public void addScore(double score) {
		this.score += score;
	}

}
