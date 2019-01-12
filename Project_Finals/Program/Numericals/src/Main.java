import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("How many pairs?: ");
		int num;
		int xVar;
		ArrayList<Pair> pairs = new ArrayList<>();

		try {
			num = Integer.parseInt(reader.readLine());
			for (int i = 0; i < num; i++) {
				System.out.print("Enter pair (x,y): ");
				String input = reader.readLine();
				String[] p = input.replaceAll("[()]", "").split(",");
				pairs.add(new Pair(Double.parseDouble(p[0]), Double.parseDouble(p[1])));

			}
			System.out.print("Value of x in P(x)?: ");
			xVar = Integer.parseInt(reader.readLine());
			Lagrange l = new Lagrange(pairs, xVar);
			System.out.println("P(" + xVar + ") = " + l.solve());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// pairs.add(new Pair(-1, 3));
		// pairs.add(new Pair(0, 2));
		// pairs.add(new Pair(2, 0));
		// pairs.add(new Pair(4, -1));
	}
}
