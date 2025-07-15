#include<stdio.h>
int main(){
    int num[10],size,value, sum=0;
    printf("enter the number of elements:\n");
    scanf("%d",&size);
      
    printf("enter the elements:\n");
     
    for(int i=0;i<size;i++){
       scanf("%d",&value);
        num[i]=value;
    }
printf("\n original array:");
for(int i=0;i<size;i++){
    printf(" Index %d:%d\t",i,num[i]);
}
for(int i=0;i<size;i++){
    sum+=num[i];
}
printf("the sum of the elements in an array is:%d\n",sum);
}