public class Main {
    public static void main(String[] args) throws ListException{
        AList<Object> list = new AList<>(1);
        list.add("veggie");
        list.add("carton");
        list.add("bread");
        list.add("cookie");
        list.add("milk");
        System.out.println(list.toString());

        AList<Object> list2 = new AList<>(1);
        list2.add("veggie");
        /*
        list2.add("carton");
        list2.add("bread");
        list2.add("cookie");
         */
        list2.add(0);
        System.out.println(list2.toString());
        System.out.println(list2.equals(list));
       // list.remove(3);
        //System.out.println(list.toString());
    }
}
