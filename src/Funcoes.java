public class Funcoes {
	private void helloWorld() {
		System.out.println("ola mundo");	
	}
	
	private int soma(int a, int b) {
	 return a+b;
	}
	
	private int hello(String oi) {
		int b = oi.length();
		return b;
	}
	
	private String hello2(String oi) {
		int b= oi.length();
		String c = "A palavra possui "+b +" caracteres";
		return c;	
	}
	
	private double calc(double a, double b, double c) {
		return ((a+b)*a)/c;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Funcoes funcoes = new Funcoes(); // nome da classe para instanciar os objetos

	String str = "Curso de Java";
	String email = " gabrielle@gmail.com ";
	str.charAt(5); //qual posição q eu quero
	System.out.println(str.equals("test")); //verifica se é igual
	System.out.println(str.startsWith("C")); //verifica se é igual
	System.out.println(str.endsWith("C"));
	
	System.out.println(str.substring(3));//pego a string começando do 3 até o final
	System.out.println(str.substring(3,5));//pego a string começando do 3 até o 5 (n inclui o 5)
	
	System.out.println(str.replace("Java", "Android"));// encontra na minha string o Java e substitui por android
	System.out.println(str.toUpperCase());//Transforma toda string em maiusculo
	System.out.println(str.toLowerCase());//Transforma toda string em minusculo
	System.out.println(email.trim());// remove o espaço da string
	System.out.println(str.length());// tamanho da string
	
	
	System.out.println("EXERCICIOS");
	funcoes.helloWorld();
	System.out.println(funcoes.hello("teste"));
	System.out.println(funcoes.hello2("teste"));
	System.out.println(funcoes.soma(3, 4));
	System.out.println(funcoes.calc(10, 10, 10));	
	
	try {
		String str1 = "Teste";
		str1.charAt(200);
		String s = null;
		System.out.println(s.length());
	} catch (StringIndexOutOfBoundsException e) {
		System.out.println("Posição invalida");
		// TODO: handle exception
	}catch (NullPointerException e) {
		System.out.println("Null Pointer");
		// TODO: handle exception
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println("Erro Desconhecido");
	}finally { //sempre executei
		System.out.println("Executei");
	}
	}
}
