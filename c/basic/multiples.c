#include <stdio.h>

int main() {
    int num, limit, i;

    // Input the number and the limit
    printf("Enter a number to print its multiples: ");
    scanf("%d", &num);

    printf("Enter how many multiples to print: ");
    scanf("%d", &limit);

    // Print multiples using for loop
    printf("Multiples of %d:\n", num);
    for (i = 1; i <= limit; i++) {
        printf("%d\n", num * i);
    }

    return 0;
}