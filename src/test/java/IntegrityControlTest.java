import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by lionel on 20/09/2015.
 */
public class IntegrityControlTest{


    @Test(expected = ArgumentException.class)
    public void emptyOrNullStringShouldReturnAnError() throws ArgumentException {

        IntegrityControl testControl = new IntegrityControl();
        testControl.prepareString(null);

    }
}