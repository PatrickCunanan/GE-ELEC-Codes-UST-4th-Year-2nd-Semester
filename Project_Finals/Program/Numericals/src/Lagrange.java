import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class Lagrange {

	private ArrayList<Pair> pairs = new ArrayList<>();
	private double x = 0;

	public Lagrange(ArrayList<Pair> pairs, double x) {
		this.pairs = pairs;
		this.x = x;
	}

	public double solve() {
		double answer = 0;

		Polynomial prod;
		ArrayList<double[]> terms = new ArrayList<>();
		double[] coeff;

		// Iterate each pair
		for (Pair p : pairs) {
			double numerator = 1;
			double denominator = 1;
			prod = new Polynomial(new double[]{1.0});

			// Compute for each term
			for (Pair q : pairs) {
				if (!p.same(q)) {
					numerator *= (x - q.getX());
					denominator *= (p.getX() - q.getX());
					Polynomial poly = new Polynomial(new double[]{1.0, -q.getX()});
					prod = prod.multiply(poly);
				}
			}
			coeff = prod.getCoefficient();
			for(int i=0; i<coeff.length; i++){
				coeff[i] *= p.getY()/denominator;
			}
			terms.add(coeff);

			// Multiply the term with Y value
			System.out.print(numerator + " / " + denominator + " * " + p.getY() + " = ");
			System.out.println((numerator / denominator) * p.getY());
			answer += (numerator * p.getY() / denominator);
		}

		// Print polynomial equation
		System.out.println("Equation = " +strEquation(addCoefficients(terms)));
		return answer;
	}
	
	public String strEquation(double[] coeff){
		String equation = "";
		
		//Concatenate each term
		for (int i=0; i<coeff.length; i++){
			DecimalFormat format = new DecimalFormat("##.0000000000");
			if(format.format(coeff[i]).equals(".0000000000") || format.format(coeff[i]).equals("-.0000000000")){
				continue;
			}
			if (i==coeff.length-1){
				//equation = equation + coeff[i]+"x^";
				equation = String.format("%s %.15f", equation, coeff[i]);
				break;
			}
			//equation = equation + coeff[i]+"x^"+ (coeff.length-i-1)+" + ";
			equation = String.format("%s %.15fx^%d +", equation, coeff[i], (coeff.length-i-1));
		}
		
		return equation;
	}
	
	public double[] addCoefficients(ArrayList<double[]> coefficients){
		Iterator<double[]> it = coefficients.iterator();
		double[] sum = it.next();
		double[] iterate;
		
		// Add similar terms
		while(it.hasNext()){
			iterate = it.next();
			for (int i=0; i<sum.length;i++){
				sum[i]+= iterate[i];
				
			}
		}
		return sum;
	}
}
	

