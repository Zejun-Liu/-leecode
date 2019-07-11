import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: LIU ZEJUN
 * Date: 2019-04-10 18:18:00
 * Comment:
 */


public class Main {

    public static void main(String[] args) {

        List<A> list = new ArrayList<>();
        list.add(new A(1, 2));
        list.add(new A(2, 3));
        list.add(new A(3, 2));
        list.add(new A(3, 3));
        list.add(new A(4, 1));
        list.add(new A(5, 3));
        list.add(new A(6, 7));

        List<A> collect = list.stream().sorted(Comparator.comparing(A::getA).thenComparing(A::getB)).collect(Collectors.toList());
        System.out.println(collect);
    }


    private static class A {
        private int a;
        private int b;


        public A(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "A{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

}
