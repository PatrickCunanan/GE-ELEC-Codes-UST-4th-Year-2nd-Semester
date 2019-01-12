import java.util.Arrays;

public class Polynomial {
	private double[] coefficient;
	
	public Polynomial(double[] coefficient){
		this.coefficient = coefficient;
	}
	
	public Polynomial multiply(Polynomial poly){

		int max_length = coefficient.length + poly.coefficient.length - 1;
		double[] prod = new double[max_length]; 
		
		for (int i=0; i<coefficient.length; i++)
		   {
		     // Multiply the current term of first polynomial
		     // with every term of second polynomial.
		     for (int j=0; j<poly.coefficient.length; j++)
		         prod[i+j]+= coefficient[i]*poly.coefficient[j];
		   }
		 
		   return new Polynomial(prod);
		}
	
	@Override
    public String toString() {
        return Arrays.toString(getCoefficient());
    }

	public void setCoefficient(double[] coefficient){
		this.coefficient = coefficient;
	}
	
	public double[] getCoefficient(){
		return coefficient;
	}
	
	/*public static void main(String... args) {
        Polynomial p1 = new Polynomial(new double[]{1, 2, 3});
        System.out.println(p1 + "^2 =" + p1.multiply(p1));
        Polynomial p2 = new Polynomial(new double[]{3, -1, -1});
        System.out.println(p1 + "*" + p2 + "=" + p1.multiply(p2));
    }*/
}
