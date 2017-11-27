import java.util.Arrays;
public class MyEnam {

    public static final Inner ONE;
    public static final Inner TWO;
    public static final Inner THREE;

    private static final Inner[] inners = new Inner[3];
    private static int counter = 0;

    static {

        ONE = new Inner("ONE");
        TWO = new Inner("TWO");
        THREE = new Inner("THREE");
        inners[0] = ONE;
        inners[1] = TWO;
        inners[2] = THREE;
    }


    public static MyEnam.Inner valueOf(String name) throws IllegalArgumentException{
        for (Inner inner : inners) {
            if (inner.name.equals(name)) {
                return inner;
            }
        }
        throw new IllegalArgumentException();
    }

    public static MyEnam.Inner[] value(){
        return Arrays.copyOf(inners, inners.length);
    }

    public static final class Inner{
        private final int ordinal;
        private final String name;

        private Inner( String name) {
            this.name = name;
            ordinal = counter;
            counter++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Inner inner = (Inner) o;

            return name != null ? name.equals(inner.name) : inner.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            return name ;
        }

        public int ordinal() {
            return ordinal;
        }

        public final int compareTo(Inner other) {
            return this.ordinal - other.ordinal;
        }
    }
}
