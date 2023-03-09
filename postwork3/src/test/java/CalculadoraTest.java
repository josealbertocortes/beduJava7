import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CalculadoraTest {
    @TestFactory
    Stream<DynamicTest> pruebasDinamicas() {
        Calculadora calc = new Calculadora();
        List<Integer> operandos = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        List<Integer> resultados = IntStream.range(0, 1000).map(n -> n * 2).boxed().collect(Collectors.toList());

        return operandos.stream().map(numero -> DynamicTest.dynamicTest("Multiplicacion: " + numero, () -> { assertEquals(calc.multiplica(numero, 2), resultados.get(numero));}));
    }
}
