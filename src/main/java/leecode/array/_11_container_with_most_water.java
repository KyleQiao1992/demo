package leecode.array;

public class _11_container_with_most_water {
    public static int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int length = r - l;
            int h = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, length * h);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(test);
    }
}
