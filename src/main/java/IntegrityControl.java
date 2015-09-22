import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by lionel on 20/09/2015.
 */
public class IntegrityControl {


    public boolean calculateLuhn(String entry) throws ArgumentException {
        if (StringUtils.isBlank(entry)) {
            throw new ArgumentException("argument should be a non blank character sequence like '1121323232323'");
        }

        List<Integer> myListOfNumberToTest = parseStringToNumber(entry);


        ImmutableList<Object> listOfValue = ImmutableList.builder().addAll(myListOfNumberToTest).build();

        ImmutableList reverlistOfValue =  listOfValue.reverse();

        IntStream instreamToCalculate = generateEvenIndexSequence(reverlistOfValue.size());

        int sum = calculateSumOfEvenDigitsOfSequence(reverlistOfValue);

        int sumofodddigit  = calculateSumOfOddDigitsOfSequence(reverlistOfValue);

        return isValid(sum,sumofodddigit);

    }

    public boolean isValid(int sum,int sumofodddigit){
        int sommeTotal  = sum + sumofodddigit;

        return sommeTotal%10 == 0 ? true : false;
    }

    public int calculateSumOfEvenDigitsOfSequence(ImmutableList listOfValue){
        return generateEvenIndexSequence(listOfValue.size())
                .mapToObj(indexNumber -> ((Integer) listOfValue.get(indexNumber)))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateSumOfOddDigitsOfSequence(ImmutableList listOfValue){
        return generateOddIndexSequence(listOfValue.size()).boxed()
                .mapToInt(indexNumber -> ((Integer) listOfValue.get(indexNumber)).intValue() * 2)
                .boxed()
                .mapToInt(x -> getsum(x))
                .sum();
    }

    public List<Integer> parseStringToNumber(String entry){
        return IntStream.range(0, entry.length()).mapToObj(index -> new Integer(entry.substring(index, index + 1))).collect(Collectors.toList());
    }

    public IntStream generateEvenIndexSequence(int sizeOfTheList){
        return IntStream.iterate(0,i -> i+2).limit(sizeOfTheList).filter(x -> x < sizeOfTheList);
    }

    public IntStream generateOddIndexSequence(int sizeOfTheList){
        return IntStream.iterate(1,i -> i+2).limit(sizeOfTheList).filter(x -> x < sizeOfTheList);
    }

    public int getsum(int n) {
        return n == 0 ? 0 : n % 10 + getsum(n/10);
    }
}
