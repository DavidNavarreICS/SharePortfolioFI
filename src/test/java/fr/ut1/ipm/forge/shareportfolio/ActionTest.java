/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ut1.ipm.forge.shareportfolio;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author David Navarre <David.Navarre at irit.fr>
 */
public class ActionTest {

    private static final String NAME_CORRECT1 = "TOTO";
    private static final String NAME_CORRECT2 = "TITI";
    private static final String NAME_NULL = null;
    private static final String NAME_EMPTY = "";

    public ActionTest() {
    }

    @Test
    public void testBuildActionGetNomSame() {
        final String name = NAME_CORRECT1;
        final Action action = new ActionForTest(name);

        final String result = action.getNom();
        Assertions.assertSame(name, result,
                "The String used to build the object Action should be the same as the result of getNom");
    }

    @Test
    public void testBuildActionWithNullNomShouldFail() {
        final String name = null;
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> new ActionForTest(name),
                "Should not accept null name");
    }

    @Test
    public void testBuildActionWithEmptyNomShouldFail() {
        final String name = "";
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> new ActionForTest(name),
                "Should not accept null name");
    }

    @Test
    public void testEqualsWithSameObject() {
        final String name = NAME_CORRECT1;
        final Action action = new ActionForTest(name);

        Assertions.
                assertTrue(action.equals(action), "Should be equal to itself");
    }

    @Test
    public void testEqualsWithSameName() {
        final String name = NAME_CORRECT1;
        final Action action1 = new ActionForTest(name);
        final Action action2 = new ActionForTest(name);

        Assertions.assertTrue(action1.equals(action2),
                "Should be equal to an action with the same name");
        Assertions.assertTrue(action2.equals(action1),
                "Should be equal to an action with the same name");
    }

    @Test
    public void testHashcodeExists() {
        final String name = NAME_CORRECT1;
        final Action action = new ActionForTest(name);

        Assertions.
                assertTrue(Objects.nonNull(action.hashCode()),
                        "Should provide a value");
    }

    @Test
    public void testToStringExists() {
        final String name = NAME_CORRECT1;
        final Action action = new ActionForTest(name);
        final String toString = action.toString();

        Assertions.
                assertTrue(Objects.nonNull(toString) && !toString.isEmpty(),
                        "Should provide a non null and non empty string");
    }

    private class ActionForTest extends Action {

        public ActionForTest(String aNom) {
            super(aNom);
        }

        @Override
        public float valeur(Jour aJ) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
