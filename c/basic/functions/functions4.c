#include<stdio.h>
//functions with arguments with return value
int add(int a, int b){
    return a + b;
}
int main(){
    int x,y;
    printf("enter two numbers:\n");
    scanf("%d %d ",&x,&y);
    int result=add(x,y);
    printf("Sum:%d\n",result);
    return 0;
}