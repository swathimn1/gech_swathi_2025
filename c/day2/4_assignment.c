#include<stdio.h>
int main(){
    int num,fact=1;
    printf("enter a number:\n");
    scanf("%d",&num);
    for(int i=1;i<=num;i++){
        fact=fact*i;
    }
    printf("the factorial of %d is %d\n",num,fact);
    printf("through the formula:\n");
    printf("the factorial of %d is %d",num,num*(num-1));
    return 0;

}