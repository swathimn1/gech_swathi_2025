#include<stdio.h>
int main(){
    //looping statements in java include for ,while,do-while
    //for loop is used when we know the number of iterations.
    int a=0, b=50;
    for(int a=1;a<=10;a++){
       printf("%d\n",a);

    }
printf("enter the value:\n");
scanf("%d",&b);
for(int i=1;i<=b;i++){
    if(i%2==0){
     printf("%d\n",i);
    }
}

    return 0;
}