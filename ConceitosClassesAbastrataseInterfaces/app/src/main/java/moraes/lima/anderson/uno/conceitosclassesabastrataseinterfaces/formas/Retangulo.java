package moraes.lima.anderson.uno.conceitosclassesabastrataseinterfaces.formas;
/*Java - Guia do Programador - 3ª Edição https://github.com/pjandl/jgp3*/

	public class Retangulo extends Forma {
		public Retangulo(double altura, double largura) {
			super(2); // uso obrigatório do construtor da superclasse
			setMedida(0, altura); // ajuste da medida da altura
			setMedida(1, largura); // ajuste da medida da largura
		}

		// implementação do método abstrato area()
		@Override
		public double area() {
			return getMedida(0) * getMedida(1);
		}

		// implementação de operação específica extra
		public double perimetro() {
			return 2 * (getMedida(0) + getMedida(1));
		}
	}