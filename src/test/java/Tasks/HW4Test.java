package Tasks;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class HW4Test extends TestCase {

    @Test
    public void testSplit() {

        String [] expected = new String[] {"kiwi", "strawberry", "blueberry"};
        Assert.assertEquals(expected, HW4.split("kiwi strawberry\nblueberry"));
    }
}