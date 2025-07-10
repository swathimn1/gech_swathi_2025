#include<stdio.h>
int main(){
    //while loop in c is used when we dont know the number of iterations
    int num,i=0,sum=0;
    printf("enter a number:\n");
    scanf("%d",&num);
    while(i<=num){
        sum=sum+i;
        i++;
    }
    printf("sum of %d natural  numbers are :%d",num,sum);
}