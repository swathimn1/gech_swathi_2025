#include <stdio.h>

int main() {
    int n, i;
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter %d elements:\n", n);
    for(i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int *ptr = arr;  // pointer to the first element
    int max = *ptr;  // assume the first element is max

    for(i = 1; i < n; i++) {
        ptr++;
        if(*ptr > max) {
            max = *ptr;
        }
    }

    printf("The maximum element in the array is: %d\n", max);
    return 0;
}