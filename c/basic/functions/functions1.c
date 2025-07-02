#include<stdio.h>
//1.function with no argument and no return value
void add(){
    int a, b;
    printf("enter two numbers:\n");
    scanf("%d %d ",&a,&b);
    printf("Sum:%d\n",a+b);

}
int main(){
    add();
    return 0;
}