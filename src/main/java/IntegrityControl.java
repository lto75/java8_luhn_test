import org.apache.commons.lang3.StringUtils;

/**
 * Created by lionel on 20/09/2015.
 */
public class IntegrityControl {


    public void prepareString(String entry) throws ArgumentException {
        if(StringUtils.isBlank(entry)){
            throw new ArgumentException("argument should be a non blank character sequence like '1121323232323'");
        }



    }
}
