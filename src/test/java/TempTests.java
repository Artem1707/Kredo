import Api.DogApi;
import Models.DogImage;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


@Disabled
public class TempTests {
    @Test
    public void sampleApiTest() {
        DogApi obj = new DogApi();
        DogImage dog = obj.getDogs();

        System.out.println("DogImage: " + dog.Status + "   " + dog.Message);
        Assert.check(dog.Status.equals("success"));
    }
}
