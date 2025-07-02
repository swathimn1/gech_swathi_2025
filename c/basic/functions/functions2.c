#include<stdio.h>
//function with arguments and no return value
void add(int a ,int b){
    printf("Sum:%d\n",a+b);
}
int main(){
    int x,y;
    printf("enter two numbers:\n");
    scanf("%d %d",&x,&y);
    add(x,y);
    return 0;
}