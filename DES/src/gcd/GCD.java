package gcd;

public class GCD {

	
	public static int gcd(int a, int b){
		
		if(a<b)
			swap(a, b);
			
		if(a %b ==0)
			return b;
		
		return gcd(b, a%b);
		
	}
	
	private static void swap(int a , int b){
		int temp = a;
		a=b;
		b=temp;
	}
	
	public static void main(String[] args) {
		
		int a=42823;
		int b = 6409;
		
		System.out.println("gcd("+a+", "+b+") = "+gcd(a, b));
	}
	
	
}
