#include<stdio.h>
int main(){
    // int a=0,b=1,c,count;
    // printf("enter the number:\n");
    // scanf("%d",&count);
    // printf("Fibonacci sequence is:\n");
    // while(count>0){
    //    printf("%d\n",a);
    //     c=a+b;
    //     a=b;
    //     b=c;
    //     count --;
    
      
    // }
    int a=0,b=1,c,count;
    printf("enter the number:\n");
    scanf("%d",&count);
    printf("Fibonacci sequence is:\n");
    while(count>0){
        printf("%d\n",a);
        c=a+b;
        a=b;
        b=c;
        count --;
    }
}