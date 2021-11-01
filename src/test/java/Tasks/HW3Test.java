package Tasks;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static Tasks.HW3.ToDecrypt;
import static Tasks.HW3.ToEncrypt;

public class HW3Test extends TestCase {

    @Test
    public void testCheckDecryption() {

        String expectedText = "aYZz";
        Assert.assertEquals(expectedText, ToDecrypt("BzaA"));
    }

    @Test
    public void testCheckEncryption() {

        String expectedText = "BzaA";
        Assert.assertEquals(expectedText, ToEncrypt("aYZz"));
    }
}