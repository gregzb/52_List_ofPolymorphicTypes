/**
 Test list features.
 */
public class UserOfList {
    public static void main( String[] args ) {
        List_inArraySlots<Integer> list = new List_inArraySlots<>();

        System.out.println( "number of elements: " + list.size() );
        System.out.println( "empty list:" + list);

        /* Populate the list with elements, but with a small enough
           number that we expect no invocation of expand().
        */
        int i = 0;
        for( ; i < 5; i++ ) {
            list.add( -i); // differs from index, but similar
            System.out.println( "number of elements: " + list.size() );
        }
        System.out.println("initial population of " + list.size() + " elements:");
        System.out.println( list);

        // Add enough elements that expansion is expected
        for( ; i < 15; i++ ) {

            if( i == 10) System.out.println( "expansion expected");

            list.add( -i);
            System.out.println( "number of elements: " + list.size() );
        }
        System.out.println("result of second population: " + list.size() + " elements:");
        System.out.println( list);

        // Trust no one.
        for( ; i < 35; i++ )
            list.add( -i);
        System.out.println("after second expansion: " + list.size() + " elements:");
        System.out.println( list);

        list.remove(list.size()-1);
        System.out.println(list);

        System.out.println("NEW LIST");
        System.out.println(new List_inArraySlots<Integer>(list));

        System.out.println("NEW MAP");
        //List_inArraySlots<Integer> thing = new List_inArraySlots<Integer>(list).map( (num) -> ( num % 4) );
        System.out.println(new List_inArraySlots<Integer>(list).map( (num) -> ( num % 4) ).map( (num) -> ( num % 2) ));
        //System.out.println(new List_inArraySlots<Integer>(list).map( (num) -> ( num % 4) ).get(2).getClass());

        System.out.println("NEW FILTER");
        System.out.println(new List_inArraySlots<Integer>(list).filter( (num) -> ( num % 2 == 0) ));

        System.out.println("COOL OP");
        // System.out.println(new List_inArraySlots<Integer>(list).filter( (num) -> ( num % 2 == 0) ).map((num) -> (num % 4)));
//        list.add(3, 3);
//        System.out.println(list);

        List_inArraySlots<Object> list2 = new List_inArraySlots<>();

        list2.add("hello");
        list2.add(2.242);
        list2.add(9);

        System.out.println(list2);
    }
}
