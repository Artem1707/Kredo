import Api.DogApi;
import Models.DogImage;
import Common.TestsBase;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Disabled
public class TempTests extends TestsBase {
    @Test
    public void sampleApiTest() throws IOException {
        DogApi obj = new DogApi();
        DogImage dog = obj.getDogs();

        System.out.println("DogImage: " + dog.Status + "   " + dog.Message);
        Assert.check(dog.Status.equals("success"));
    }
}
