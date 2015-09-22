import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * Created by lionel on 20/09/2015.
 */
public class IntegrityControlTest{


    @Test(expected = ArgumentException.class)
    public void emptyOrNullStringShouldReturnAnError() throws ArgumentException {

        IntegrityControl testControl = new IntegrityControl();
        testControl.calculateLuhn(null);

    }

    @Test
    public void testThatTHeGeneratorGetAValue(){
        IntegrityControl testControl = new IntegrityControl();
        //We have a list with 8 elements inside
        final IntStream intStreamResult = testControl.generateEvenIndexSequence(8);

        //The result shoud be a list with 0 2 4 6
        Assertions.assertThat(intStreamResult.toArray()).isEqualTo(Arrays.asList(0, 2, 4, 6).toArray());

    }


    @Test
    public void testThatTHeOddGeneratorGetAValue(){
        IntegrityControl testControl = new IntegrityControl();
        //We have a list with 8 elements inside
        final IntStream intStreamResult = testControl.generateOddIndexSequence(8);

        //The result shoud be a list with 1 3 5 7
        Assertions.assertThat(intStreamResult.toArray()).isEqualTo(Arrays.asList(1, 3, 5, 7).toArray());

    }

    @Test
    public void testThatTHeOddGeneratorGetAValueFromSize11(){
        IntegrityControl testControl = new IntegrityControl();
        //We have a list with 8 elements inside
        final IntStream intStreamResult = testControl.generateOddIndexSequence(11);

        //The result shoud be a list with 1 3 5 7
        Assertions.assertThat(intStreamResult.toArray()).isEqualTo(Arrays.asList(1, 3, 5, 7,9).toArray());

    }

    @Test
    public void testParseString(){
        String stringOfInt = "123456";
        IntegrityControl testControl = new IntegrityControl();
        List<Integer> listOfInteger = testControl.parseStringToNumber(stringOfInt);
        Assertions.assertThat(listOfInteger).isEqualTo(Lists.newArrayList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void shouldAZeroIntegerReturnASumOfZero(){
        IntegrityControl testControl = new IntegrityControl();
        int somme = testControl.getsum(0);

        Assertions.assertThat(somme).isEqualTo(0);
    }

    @Test
    public void should280ReturnASumOf10(){
        IntegrityControl testControl = new IntegrityControl();
        int somme = testControl.getsum(280);

        Assertions.assertThat(somme).isEqualTo(10);
    }

    @Test
    public void shouldSequence123456return9(){
        IntegrityControl testControl = new IntegrityControl();
        ImmutableList testList = new ImmutableList.Builder<Integer>().add(1,2,3,4,5,6).build();
        int somme  = testControl.calculateSumOfEvenDigitsOfSequence(testList);

        Assertions.assertThat(somme).isEqualTo(9);
    }

    @Test
    public void shouldSequence123456return15(){
        IntegrityControl testControl = new IntegrityControl();
        ImmutableList testList = new ImmutableList.Builder<Integer>().add(1,2,3,4,5,6).build();
        int somme  = testControl.calculateSumOfOddDigitsOfSequence(testList);

        Assertions.assertThat(somme).isEqualTo(15);
    }

    @Test
    public void should49927398716isvalid() throws ArgumentException {


        IntegrityControl testControl = new IntegrityControl();
        boolean result = testControl.calculateLuhn("49927398716");

        Assertions.assertThat(result).isTrue();

    }

}