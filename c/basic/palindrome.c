#include<stdio.h>
int main(){
    int num,r,sum,temp;
    printf("enter an integer:\n");
    scanf("%d",&num);
    temp=num;
    sum=0;
    while(num>0){
        r=num%10;
        sum=sum*10+r;
        num=num/10;

    }
    if(temp==sum){
        printf("the number is a palindrome \n",temp);
    }
    else{
        printf("the number is not  a palindrome\n",temp);
    }
    return 0;
    }
  
