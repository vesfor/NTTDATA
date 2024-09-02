
public class Areas {

	public static void main(String[] args) {
		double areaTriangulo = AreaTriangulo(8.0, 5.1);
		System.out.println("El Area del triangulo es: "+ areaTriangulo);
		double areaCirculo = AreaCirculo(4.8);
		System.out.println("El Area del circulo es: "+ areaCirculo);
	}
	
	
	public static double AreaTriangulo(double base, double altura) {
		return (base * altura)/2;
	}
	
	public static double AreaCirculo(double radio) {
		return Math.PI * Math.pow(radio, 2);
	}

}
