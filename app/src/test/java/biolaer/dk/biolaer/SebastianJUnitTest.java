package biolaer.dk.biolaer;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * I denne klasse er Sebastians JUnit Test placeret. Et krav fra faget Programmering.
 */

public class SebastianJUnitTest {
        @Test
        public void DoesTheObjectExist1() {
            try {
                Class.forName("");
            } catch (ClassNotFoundException e) {
                Assert.fail("object was not found");
            }

        }}

