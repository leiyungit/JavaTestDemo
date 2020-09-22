import com.msb.proxy.CalculatorProxy;
import com.msb.service.ICalculator;
import com.msb.service.impl.Calculator;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void add(){
        ICalculator calculator = CalculatorProxy.getCalculator(new Calculator());
        System.out.println(calculator.add(1,2));
        System.out.println(calculator.div(1,0));
    }
}
