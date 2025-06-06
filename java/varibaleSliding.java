public class varibaleSliding {
    static void siliding(int arr[], int k) { //k=8
        int ans = 0, curr = 0, i = 0, j = 0;
        int start = 0, end = 0;
        while (j < arr.length) {
            curr += arr[j];
            while (curr > k) {//for shrinking
                curr -= arr[i];
                i++;
            }
            if (ans < j - i + 1) { // Update the maximum subarray length and its boundaries
                ans = j - i + 1;
                start = i;
                end = j;
            }
            j++;
        }
        System.out.println("Maximum length of subarray: " + ans);
        System.out.print("Subarray: ");
        for (int x = start; x <= end; x++) {
            System.out.print(arr[x] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 3, 2, 1, 5, 2, 1, 1, 4};
        siliding(arr, 8);
    }
}