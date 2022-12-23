package exercicios.lambdas;

@FunctionalInterface
public interface Calculo {
	
	//INTERFACES FUNCIONAIS SÓ RECEBEM UM MÉTODO;
	double executar(double a, double b);
	
	//MAS RECEBE UM MÉTODO DEFAULT - ESTÁ RELACIONADO ÀS INSTÂNCIAS;
	default String legal() {
		return "legal";
	}
	
	//E TAMBÉM RECEBE UM MÉTODO STATIC - ESTÁ RELACIONADO À INTERFACE
	static String muioLegal() {
		return "muito legal";
	}
	
	
}
