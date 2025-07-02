// #include<stdio.h>
// int main(){
//     int arr[10];
//     int arr[3][3];
//     for(int i=0;i<3;i++){
//         for(int j=0;j<3;j++){
//             printf("%d",arr[i][j]);
//         }
//         printf("\n");
//     }
// }
// #include <stdio.h>

// int main() {
//     int rows = 2, cols = 3;
//     int arr[2][3];

//     // Input elements
//     printf("Enter elements for a 2x3 matrix:\n");
//     for (int i = 0; i < rows; i++) {
//         for (int j = 0; j < cols; j++) {
//             printf("Enter element [%d][%d]: ", i, j);
//             scanf("%d", &arr[i][j]);
//         }
//     }

//     // Display elements
//     printf("\nThe 2x3 matrix is:\n");
//     for (int i = 0; i < rows; i++) {
//         for (int j = 0; j < cols; j++) {
//             printf("%d ", arr[i][j]);
//         }
//         printf("\n");  // New line after each row
//     }

//     return 0;
// }

#include <stdio.h>

int main() {
    int rows = 2, cols = 3;
    int arr[2][3];

    // Input elements
    printf("Enter elements for a 2x3 matrix:\n");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("Enter element [%d][%d]: ", i, j);
            scanf("%d", &arr[i][j]);
        }
    }

    // Assume first element is max
    int max = arr[0][0];

    // Find maximum
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (arr[i][j] > max) {
                max = arr[i][j];
            }
        }
    }

    printf("\nThe maximum element in the matrix is: %d\n", max);

    return 0;
}
