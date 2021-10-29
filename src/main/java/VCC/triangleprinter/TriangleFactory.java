package VCC.triangleprinter;

public class TriangleFactory {

    public static String createShapeOne(String character, int size)
    {
        var triangle = "";

        for (var floorSize = size; floorSize > 0; floorSize--) {
            triangle += character.repeat(floorSize);
            triangle += floorSize > 1 ? "\n" : "";
        }

        return triangle;
    }

    public static String createShapeTwo(String character, int size)
    {
        var triangle = "";

        for (var floorSize = size; floorSize > 0; floorSize--) {
            triangle += " ".repeat(size - floorSize);
            triangle += character.repeat(floorSize);
            triangle += floorSize > 1 ? "\n" : "";
        }

        return triangle;
    }

    public static String createShapeThree(String character, int size)
    {
        var triangle = "";

        for (var floorSize = 1; floorSize <= size; floorSize++) {
            triangle += " ".repeat(size - floorSize);
            triangle += character.repeat(floorSize);
            triangle += floorSize == size ? "" : "\n";
        }

        return triangle;
    }

    public static String createShapeFour(String character, int size)
    {
        var triangle = "";

        for (var floorSize = 1; floorSize <= size; floorSize++) {
            triangle += character.repeat(floorSize);
            triangle += floorSize == size ? "" : "\n";
        }

        return triangle;
    }
}
