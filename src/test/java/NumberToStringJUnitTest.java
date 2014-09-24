/**
 * Created by konst on 13.09.14.
 */

import static org.junit.Assert.*;

import org.junit.Test;
import sharygin.konst.utils.NumberToString;


public class NumberToStringJUnitTest {

    @Test
    public void testNumberToString(){
        String str = NumberToString.convertIntNumberToString(123);
        assertNotNull("Object is null", str);
        assertTrue("сто двадцать три ".equals(str));

        str = NumberToString.convertIntNumberToString(123_012_123);
        assertNotNull("Object is null", str);
        assertTrue("Ожидалось 'сто двадцать три миллиона двенадцать тысяч сто двадцать три '; пришло " + str ,"сто двадцать три миллиона двенадцать тысяч сто двадцать три ".equals(str));

        str = NumberToString.convertIntNumberToString(112_123);
        assertNotNull("Object is null", str);
        assertTrue("Ожидалось 'сто двенадцать тысяч сто двадцать три '; пришло " + str, "сто двенадцать тысяч сто двадцать три ".equals(str));

        str = NumberToString.convertIntNumberToString(12_123_016);
        assertNotNull("Object is null", str);
        assertTrue("Ожидалось 'двенадцать миллионов сто двадцать три тысячи шестнадцать '; пришло " + str, "двенадцать миллионов сто двадцать три тысячи шестнадцать ".equals(str));

        str = NumberToString.convertIntNumberToString(2_123);
        assertNotNull("Object is null", str);
        assertTrue("Ожидалось 'две тысячи сто двадцать три '; пришло " + str, "две тысячи сто двадцать три ".equals(str));
    }
}
