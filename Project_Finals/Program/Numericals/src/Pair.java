
public class Pair {

	private double x = 0;
	private double y = 0;

	public Pair(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean same(Pair p2) {
		return this.getX() == p2.getX() && this.getY() == p2.getY();
	}
}
