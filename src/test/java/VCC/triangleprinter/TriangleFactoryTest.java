package VCC.triangleprinter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TriangleFactoryTest
{
    @Test
    public void testShouldCreateShapeOne()
    {
        assertEquals("", TriangleFactory.createShapeOne("*", 0));
        assertEquals("*", TriangleFactory.createShapeOne("*", 1));
        assertEquals("-", TriangleFactory.createShapeTwo("-", 1));
        assertEquals("**\n*", TriangleFactory.createShapeOne("*", 2));
        assertEquals("***\n**\n*", TriangleFactory.createShapeOne("*", 3));
        assertEquals("****\n***\n**\n*", TriangleFactory.createShapeOne("*", 4));
    }

    @Test
    public void testShouldCreateShapeTwo()
    {
        assertEquals("", TriangleFactory.createShapeTwo("*", 0));
        assertEquals("*", TriangleFactory.createShapeTwo("*", 1));
        assertEquals("-", TriangleFactory.createShapeTwo("-", 1));
        assertEquals("**\n *", TriangleFactory.createShapeTwo("*", 2));
        assertEquals("***\n **\n  *", TriangleFactory.createShapeTwo("*", 3));
        assertEquals("****\n ***\n  **\n   *", TriangleFactory.createShapeTwo("*", 4));
    }

    @Test
    public void testShouldCreateShapeThree()
    {
        assertEquals("", TriangleFactory.createShapeThree("*", 0));
        assertEquals("*", TriangleFactory.createShapeThree("*", 1));
        assertEquals("-", TriangleFactory.createShapeTwo("-", 1));
        assertEquals(" *\n**", TriangleFactory.createShapeThree("*", 2));
        assertEquals("  *\n **\n***", TriangleFactory.createShapeThree("*", 3));
        assertEquals("   *\n  **\n ***\n****", TriangleFactory.createShapeThree("*", 4));
    }

    @Test
    public void testShouldCreateShapeFour()
    {
        assertEquals("", TriangleFactory.createShapeFour("*", 0));
        assertEquals("*", TriangleFactory.createShapeFour("*", 1));
        assertEquals("-", TriangleFactory.createShapeTwo("-", 1));
        assertEquals("*\n**", TriangleFactory.createShapeFour("*", 2));
        assertEquals("*\n**\n***", TriangleFactory.createShapeFour("*", 3));
        assertEquals("*\n**\n***\n****", TriangleFactory.createShapeFour("*", 4));
    }
}
