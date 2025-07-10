#include <stdio.h>

int main() {
    int num, originalNum, remainder, result = 0, n = 0;

    printf("Enter a number:\n");
    scanf("%d", &num);

    originalNum = num;

    // Count the number of digits
    while (originalNum != 0) {
        originalNum /= 10;
        n++;
    }

    originalNum = num;

    // Compute sum of digits raised to power n manually
    while (originalNum != 0) {
        remainder = originalNum % 10;

        // Manual power calculation
        int power = 1;
        for (int i = 0; i < n; i++) {
            power *= remainder;
        }

        result += power;
        originalNum /= 10;
    }

    // Check for Armstrong
    if (result == num) {
        printf("%d is an Armstrong number.\n", num);
    } else {
        printf("%d is not an Armstrong number.\n", num);
    }

    return 0;
}
