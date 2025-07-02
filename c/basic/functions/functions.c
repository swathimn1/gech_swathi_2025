
/**
 * functions in c:
 * ==============
 * 1.function prototype/declaration
 * -->it is used by the compiler to know some where else there is function in the code
 * return_type function_name(parameters);
 *
 * int add(int a,int b);
 *
 * 2.function definition:
 * =====================
 * return_type function_name(parameters){
 *   code
 * }
 * void add(int a,int b){
 * printf("the sum is %d",a+b);
 * }
 *
 * 3.function call:
 * ================
 * function_name(arguments);
 * add(2,3);
 *
 */
#include <stdio.h>
int add(int num1, int num2);
int main()
{
    int a, b;
    printf("enter two numbers:\n");
    scanf("%d %d ", &a, &b);
    int res = add(a, b);
    printf("the sum of %d and %d is: %d\n", a, b, res);
    return 0;
}
int add(int num1, int num2)
{
    return num1 + num2;
}