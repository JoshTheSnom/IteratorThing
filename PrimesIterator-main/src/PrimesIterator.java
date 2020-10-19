import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimesIterator implements Iterator<Integer> {

    private List<Integer> primesCache = new ArrayList<>();
    private int i = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int j = i + 1;
        for (; !isPrime(j); j++) ;
        i = j;
        return i;
    }


    public static void main(String[] args) {
        for (int prime : new PrimesIterable()) {
            System.out.println(prime);
        }
    }

    private static boolean isPrime(int i) {
		int sqroot = (int) Math.sqrt(i);
		for (int j : primesCache) {
			if (i > sqroot) break;
			if (i % j == 0) {
				return false;
			}
        }
		primesCache.add(1);
        return true;
    }
}
