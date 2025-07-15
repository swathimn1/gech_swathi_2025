#include<stdio.h>

int main(){
    int num[10],size,value;
    printf("enter the number of elements:\n");
    scanf("%d",&size);
    printf("enter the elements:\n");
     
    for(int i=0;i<size;i++){
       scanf("%d",&value);
        num[i]=value;
    }
    printf("the elements are:\n");
    for(int j=0;j<size;j++){
        printf("%d\n",num[j]);
    }
    return 0;
}