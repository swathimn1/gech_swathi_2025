#include<stdio.h>
int main(){
    int num;
    printf("enter  a number:\n");
    scanf("%d",&num);
    printf("the multiples of %d are:\n",num);
    for(int i=1;i<=10;i++){
        printf("%d x %d =%d\n",num,i,num*i);
    }
     return 0;
}