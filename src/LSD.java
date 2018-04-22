
public class LSD {
    private static final int BITS_PER_BYTE = 8;
    
    // do not instantiate
//    private LSD() {}
    
    // fixed-length W strings
    public static void sort(String[] a, int W) {
        // radix R
        int R = 256;
        int N = a.length;
        String[] aux = new String[N];
        
        // do key-indexed counting for each digit from right to left
        for (int d = W - 1; d >= 0; d--) {
            // key-indexed counting
            int[] count = new int[R+1];
            
            // count frequencies of each letter using key as index
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
            
            // compute frequency cumulates which specify destinations
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];
            
            // access cumulates using key as index to move items
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            
            // copy back into original array
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }
    
    // Rearranges the array of 32-bit integers in ascending order.
    // This is about 2-3 faster than Arrays.sort().
    public static void sort(int[] a) {
        final int BITS = 32;    // each int is 32 bits
        final int R = 1 << BITS_PER_BYTE;   // each bytes is between 0 and 255
        final int MASK = R - 1;     // 0xFF
        final int w = BITS / BITS_PER_BYTE;     // each int is 4 bytes
        
        int n = a.length;
        int[] aux = new int[n];
        
        for (int d = 0; d < w; d++) {
            
            // compute frequency counts
            int[] count = new int[R + 1];
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                count[c + 1]++;
            }
            
            // compute cumulates
            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];
            
            // for most significant byte, 0x80-0xFF comes before 0x00-ox7F
            if (d == w - 1) {
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2) {
                    
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
