import java.util.ArrayList;

public class MaxDistance {
    public static void main(String[] args) {
        int[] nums = {9, 9, 9, 9, 9};
        int value = 9;
        int distance = maxDistance(nums, value);
        System.out.println("Max Distance: " + distance);
    }

    public static int maxDistance(int[] nums, int value) {
        ArrayList<Integer> positions = new ArrayList<>();
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                positions.add(i);
            }
        }
        while (positions.size() != 0) {
            for (int j = 0; j < positions.size() - 1; j++) {
                if (positions.get(j) + 1 == positions.get(j + 1)) {
                    distance = distance + 2;
                }
                if (positions.get(positions.size() - 1) == value) {
                    distance = distance + 1;
                }
                else {
                    int x = positions.get(j + 1) - positions.get(j);
                    distance = distance + x;
                }
            }
            return distance;
        }
        return distance;
    }
}