#include<stdio.h>
int main(){
    int a;
    printf("enter a number:\n");
    scanf("%d",&a);
    int isPrime=1;
    if(a<=1){
        isPrime=0;
        printf("%d is not a prime number\n",a);
    }else{
    for(int i=2;i<a;i++){
        if(a%i==0){
            isPrime=0;
            printf("%d is not a prime number\n",a);
            break;
        }
    }
        if(isPrime==1){
            printf("%d is a prime number\n",a);
        }
        else{
            printf("%d is not a prime number\n",a);
        }
    }
}