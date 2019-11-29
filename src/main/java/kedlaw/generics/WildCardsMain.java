package kedlaw.generics;

// https://docs.google.com/document/d/17Ii7UpdxqCe-bpQJ9DDL0iEwBueiGo3vViq6HfQ_8T4/edit?usp=sharing

import java.util.*;

public class WildCardsMain {
    public static void main(String[] args) {

        // before Generics
        List myList = new LinkedList();
        myList.add(new Integer(0));
        System.out.println(myList.iterator().next().getClass()); // Whaaaaat ? Expected an Object

        Integer x = (Integer) myList.iterator().next();
        System.out.println(x.getClass());

        // same code using generics ( no explicit cast )
        List<Integer> myGenericList = new LinkedList<>();
        myGenericList.add(new Integer(0));
        Integer y = myGenericList.iterator().next();
        System.out.println(y.getClass());

        System.out.println("----------------------------------------------------------------------");
        // some collections to test things out

        List<Integer> listInt = (Arrays.asList(1, 2, 3));
        List<String> listString = (Arrays.asList("abb", "bcc", "dee"));

        System.out.println("__________________Wildcards____________________________________________");

        System.out.println(listInt.getClass());
        System.out.println(listString.getClass());

        printCollection(listInt);
        printCollection(listString);

        printCollectionWildcard(listInt);
        printCollectionWildcard(listString);

        System.out.println("__________________Bounded Wildcards_____________________________________");

        List<Circle> circleList = new ArrayList<>();
        circleList.add(new Circle(1));
        circleList.add(new Circle(3));
        circleList.add(new Circle(2));

        List<Rectangle> rectangleList = new ArrayList<>();
        rectangleList.add(new Rectangle(4));
        rectangleList.add(new Rectangle(1));
        rectangleList.add(new Rectangle(3));

        Canvas canvas = new Canvas();
        canvas.drawAll(circleList);
        canvas.drawAll(rectangleList);

    }


    // This method will accept a Collection of any type <?> is a symbol for wildcard
    static void printCollectionWildcard(Collection<?> c) {
        System.out.println("printCollectionWildcard(Collection<?> c)");
        for (Object e : c) {
            System.out.print(e.getClass() + " ");
            System.out.println(e);
        }
    }

    // This method will not accept any collection of any type. Just a Collection of Object
    static void printCollectionObjects(Collection<Object> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    static void printCollection(Collection c) {
        Iterator i = c.iterator();
        for (int k = 0; k < c.size(); k++) {
            System.out.println(i.next());
        }
    }
}

class Canvas {
    // <? extends Shape> means unknown type that extends Shape where Shape class is the upper bound and is
    // included
    public void drawAll(List<? extends Shape> shapes) {
        for (Shape s : shapes) {
            System.out.print(s.getClass() + "   ");
            s.draw();
        }
    }
}


abstract class Shape {
    int size;

    public Shape(int size) {
        this.size = size;
    }

    public abstract void draw();
}

class Circle extends Shape {


    public Circle(int size) {
        super(size);
    }

    public void draw() {
        for (int i = 0; i <= size; i++) {
            System.out.print("O");
        }
        System.out.println();
    }
}

class Rectangle extends Shape {
    public Rectangle(int size) {
        super(size);
    }

    public void draw() {
        for (int i = 0; i <= size; i++) {
            System.out.print("[]");
        }
        System.out.println();

    }
}




