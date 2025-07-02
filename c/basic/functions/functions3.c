#include<stdio.h>
//functions with no arguments but with return value
int add(){
    int a ,b;
    printf("enter two numbers:\n");
    scanf("%d %d",&a,&b);
    return a +b ;
}
int main(){
    int result=add();
    printf("sum:%d\n",result);
    return 0;
}