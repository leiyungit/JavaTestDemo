import com.msb.cglib.Calculator;
import com.msb.cglib.MyCglib;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class CglibTest {

    @Test
    public void CalculatorTest(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Calculator.class);
        enhancer.setCallback(new MyCglib());

        Calculator o = (Calculator)enhancer.create();
        System.out.println(o.add(1, 2));
        System.out.println(o.getClass());


    }
}
