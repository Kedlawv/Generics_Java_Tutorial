// https://docs.oracle.com/javase/tutorial/extra/generics/methods.html

package kedlaw.generics;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethodsMain {
    public static void main(String[] args) {

        Object[] oa = new Object[100];
        oa[0] = new Object();

        Collection<Object> co = new ArrayList<>();

        // the type <T> is inferred from the first argument ? ...NO!
        fromArrayToCollection(oa, co);

        System.out.println("___________Generic Object Collection___________");
        System.out.println(co.iterator().next().getClass());

        String[] sa = new String[10];
        //noinspection StringOperationCanBeSimplified
        sa[0] = new String("new");

        Collection<String> cs = new ArrayList<>();

        //if put an array of strings as the first argument,
        // the second arguments type expected will be a collection of strings
        fromArrayToCollection(sa,cs);

        System.out.println("___________Generic String Collection____________");
        System.out.println(cs.iterator().next().getClass());

        fromArrayToCollectionString(sa, cs);
        System.out.println("__________Non Generic String____________________");
        System.out.println(cs.iterator().next().getClass());

        fromArrayToCollection(sa,co);
        System.out.println("__________Generic 1st String 2nd Object__________");
        System.out.println(co.iterator().next().getClass());
        // if first argument is String and second Object the type inferred is the higher type of the two





    }

    private static <T> void fromArrayToCollection(T[] a, Collection<T> c){
        for(T o : a){
            c.add(o);
        }
    }

    private static void fromArrayToCollectionString (String[] a, Collection<String> c){
        for(String o : a){
            c.add(o);
        }
    }
}
