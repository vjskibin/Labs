package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Permutation {

    private int n;
    private int[] nums;
    private boolean[] arrows;
    private long count, cur;

    private Permutation(int n) {
        this.n = n;
        nums = new int[n];
        arrows = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            arrows[i] = false;
        }

        count = 1;
        for (int i = 1; i <= n; i++) {
            count *= i;
        }
        cur = 0;
    }

    private boolean hasNext() {
        return cur < count;
    }

    private int[] next() {
        int[] res = Arrays.copyOf(nums, nums.length);
        step();
        return res;
    }

    private void step() {
        int biggest = 0, pos = -1;

        cur++;

        for (int i = 1; i < n; i++) {
            if (!arrows[i]) {
                if (nums[i] > nums[i - 1] && nums[i] > biggest) {
                    pos = i;
                    biggest = nums[pos];
                }
            }
            if (arrows[i - 1]) {
                if (nums[i] < nums[i - 1] && nums[i - 1] > biggest) {
                    pos = i - 1;
                    biggest = nums[pos];
                }
            }
        }

        if (pos < 0) {
            return;
        }

        int nei = pos + (arrows[pos] ? 1 : -1);
        nums[pos] = nums[nei];
        nums[nei] = biggest;
        boolean t = arrows[pos];
        arrows[pos] = arrows[nei];
        arrows[nei] = t;

        for (int i = 0; i < n; i++) {
            if (nums[i] > biggest) {
                arrows[i] = !arrows[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Permutation pr = new Permutation(n);
        while (pr.hasNext()) {
            System.out.println(Arrays.toString(pr.next()).replaceAll("[\\[\\],]", ""));
        }
    }

}