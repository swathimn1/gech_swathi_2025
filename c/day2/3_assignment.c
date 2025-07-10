#include <stdio.h>
int main()
{
    int n, sum = 0;

    printf("Enter a positive integer:\n");
    scanf("%d", &n);

    for (int i = 1; i <= n; i++)
    {
        sum += i;
    }

    printf("Sum of first %d natural numbers = %d\n", n, sum);
    printf("through the formula:\n");
    printf("Sum of %d natural  numbers are %d\n", n, n * (n + 1) / 2);
    return 0;
}
