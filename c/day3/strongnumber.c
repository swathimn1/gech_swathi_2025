#include<stdio.h>
int factorial(int n){
    int fact=1;
    while(n>0){
        fact*=n;
        n--;
    }
    return fact;
}
int main(){
    int num,remainder,originalNum,sum=0;
    printf("enter a number:\n");
    scanf("%d",&num);;
    originalNum=num;
    while(originalNum!=0){
        remainder=originalNum%10;
        sum+=factorial(remainder);
        originalNum/=10;
    }
    if(sum==num){
        printf("%d is a strong number.\n",num);
    }
    else{
        printf("%d is not a strong number.\n",num);
    }
    return 0;
}