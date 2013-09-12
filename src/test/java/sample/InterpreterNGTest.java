/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import com.sun.org.apache.bcel.internal.generic.DADD;
import org.joda.time.DateTime;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Rajith
 */
public class InterpreterNGTest {

    public InterpreterNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of interpret method, of class Interpreter.
     */
    @Test
    public void testInterpret() {
        System.out.println("interpret");
        NICProp nicProp = new NICProp("911732270V");
        Interpreter instance = new Interpreter();
        instance.interpret(nicProp);
        DateTime expResult = new DateTime(1991, 6, 21, 0, 0);
        DateTime result = instance.getBirthday();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of createNICProp method, of class Interpreter.
     */
    @Test(expectedExceptions = InvalidNICPropException.class)
    public void testCreateNICProp() {
        System.out.println("createNICProp");
        String id = "9117322";
        Interpreter instance = new Interpreter();
        NICProp expResult = new NICProp(id);
        NICProp result = instance.createNICProp(id);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of validate method, of class Interpreter.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        NICProp nicProp = new NICProp("9117322");
        Interpreter instance = new Interpreter();
        boolean expResult = false;
        boolean result = instance.validate(nicProp);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getBirthday method, of class Interpreter.
     */
    @Test
    public void testGetBirthday() {
        System.out.println("getBirthday");
        Interpreter instance = new Interpreter();
        NICProp nicProp = new NICProp("911732270V");
        instance.interpret(nicProp);
        DateTime expResult = new DateTime(1991, 6, 21, 0, 0);
        DateTime result = instance.getBirthday();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isVoter method, of class Interpreter.
     */
    @Test
    public void testIsVoter() {
        System.out.println("isVoter");
        Interpreter instance = new Interpreter();
        NICProp nicProp = new NICProp("911732270V");
        instance.interpret(nicProp);
        boolean expResult = true;
        boolean result = instance.isVoter();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getGender method, of class Interpreter.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Interpreter instance = new Interpreter();
        NICProp nicProp = new NICProp("911732270V");
        instance.interpret(nicProp);
        String expResult = "Male";
        String result = instance.getGender();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.

    }
}
