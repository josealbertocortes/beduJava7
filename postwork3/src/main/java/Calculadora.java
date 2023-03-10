/**
 * Creación de la clase Calculadora para el ejercicio a resolver
 */
public class Calculadora {
    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplica(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0 ) throw new IllegalArgumentException("Float divide by zero");
        return a / b;
    }
    }
}
