
//Find All permutations of an array
import java.util.ArrayList;
import java.util.List;

public class Backtracking2 {
    public static void arrayPermute(int idx, int[] nums, List<List<Integer>> ans) {

        if (idx == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i : nums) {
                ds.add(i);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);
            arrayPermute(idx + 1, nums, ans);
            swap(i, idx, nums);
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> permute(int nums[]) {
        List<List<Integer>> ans = new ArrayList<>();
        arrayPermute(0, nums, ans);
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4 };
        List<List<Integer>> ls = permute(nums);
        System.out.println("All Permutations are");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
