package VCC.triangleprinter;

import java.util.Scanner;

public class TrianglePrinter
{
    public static void main(String[] args)
    {
        var scanner = new Scanner(System.in);

        System.out.println("Enter the character you want the triangles to consist of (e.g. \"*\"):");
        String character = scanner.nextLine();
        if (character.length() != 1) {
            System.out.println("Supplied value can't be longer than one character");
            scanner.close();
            System.exit(1);
        }

        System.out.println("Enter what size you want the triangle to be (e.g. 4):");
        int size = scanner.nextInt();
        scanner.close();

        if (size <= 0) {
            System.out.println("The size of the triangle has to larger than 0");
            System.exit(1);
        }

        System.out.println("Triangle One:");
        System.out.println(TriangleFactory.createShapeOne(character, size));
        System.out.println("");

        System.out.println("Triangle Two:");
        System.out.println(TriangleFactory.createShapeTwo(character, size));
        System.out.println("");

        System.out.println("Triangle Three:");
        System.out.println(TriangleFactory.createShapeThree(character, size));
        System.out.println("");

        System.out.println("Triangle Four:");
        System.out.println(TriangleFactory.createShapeFour(character, size));
    }
}
