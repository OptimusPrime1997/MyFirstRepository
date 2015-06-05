package relationShip;

public class Human {
	public void breath() {
		Air freshAir = new Air();
		freshAir.releasePower();

	}

	public static void main(String[] args) {
		Human me = new Human();
		while (true) {
			me.breath();
		}
	}
}
