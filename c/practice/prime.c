#include<stdio.h>
int main(){
    int num,i,isPrime=1;
    printf("enter a number:\n");
    scanf("%d",&num);
    if(num<=1){
        isPrime=0;
        printf("%d is not a prime number\n",num);
    }
    else{
        for(int i=2;i<num;i++){
            if(num%i==0){
                isPrime=0;
                printf("%d is not a prime number\n",num);
                break;
            }
        }
    }
    if(isPrime==1){
        printf("%d is a prime number\n",num);
    }
    else{
        printf("%d is not a prime number\n");
    }
}