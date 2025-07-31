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
    int num,originalNum,remainder,sum=0;
    printf("enter a nnumber:\n");
    scanf("%d",&num);;
    originalNum=num;
    while(originalNum!=0){

        remainder=num %10;
        sum+=factorial(remainder);

        originalNum/=10;
    }
    if(sum==num){
        printf("%d is a strong number:\n",num);
    }
    else{
        printf("%d is not a strong number:\n",num);
    }


}