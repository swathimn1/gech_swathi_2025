#include<stdio.h>
int main(){
    /*
    *there are 3 conditional statements in c ,they are
    if 
    if else
    else if
    if condition is true then if condition will execute ,else then else block will execute else ,if the else block is false,then else if block will execute.
    */
   int a=10;
   if(a%2==0){

    printf("the number is even\n");
   }
   else{
    printf("the number is odd\n");
   }
   int b=15;
   if(b%2==0){
    printf("Divisible by 2\n");
   }
   else if(b%3==0){
    printf("Divisible by 3\n");
   }
   else{
    printf("Not Divisible by 2 & 3\n");
   }
}