#include<stdio.h>
int main(){
    int x=10;
    int *ptr=&x;
    printf("the value of x:%d\n",x);
    printf("the address of x:%p\n",&x);
    printf("the value of ptr:%p\n",ptr);
    printf("the address of ptr :%p\n",&ptr);
}