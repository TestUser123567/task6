import org.example.ShapeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class ShapeTest {
    @Test
    void ShapeByNumberTest(){
        ShapeFactory shape1 = new ShapeFactory(78);
        Assertions.assertEquals(Color.RED,shape1.paint);
    }
}
