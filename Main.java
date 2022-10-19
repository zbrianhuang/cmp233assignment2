public class Main {
    public static void main(String[] args) throws ListException{
        AList<Object> list = new AList<>();
        list.add("veggie");
        list.add("carton");
        list.add("bread");
        list.add("cookie");
        list.add("milk");

        System.out.println(list.toString());
        list.remove(3);
        System.out.println(list.toString());
    }
}
