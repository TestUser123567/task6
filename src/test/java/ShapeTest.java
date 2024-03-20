import org.example.Colors;
import org.example.Form;
import org.example.ShapeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class ShapeTest {
    @Test
    void ShapeByNumberTest(){
        ShapeFactory shape1 = new ShapeFactory(Colors.Red, Form.Star);
        Assertions.assertEquals(Color.RED,shape1.paint);
    }
}
