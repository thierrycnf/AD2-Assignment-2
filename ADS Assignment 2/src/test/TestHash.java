package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.*;

public class TestHash {
    @Test
    public void hashEqual() {
        int N = 100;
        boolean equal = true;
        int[] values = new int[N];
        String[] strings = Hash.sameHash(N);
        for (int i = 0; i < N; i++) {
            values[i] = Hash.hashCode(strings[i]);
        }

        for (int i = 1; i < N; i++) {
            if (values[i-1] != values [i]) {
                equal = false;
            }
        }

        assertTrue(equal);
    }
}
