#include<stdio.h>
int main(){
    int arr[10],size,value,sum=0;
    printf("enter the number of elements:\n");
    scanf("%d\n",&size);
    printf("enter the elements:\n");
    for(int i=0;i<size;i++){
        scanf("%d\n",&value);
        arr[i]=value;
    }
    printf("the elements are:\n");
    for(int i=0;i<size;i++){
        printf("%d\n",arr[i]);
    }
    for(int i=0;i<size;i++){
        sum+=arr[i];
    }
    printf("the sum of the elements in an array is :%d\n",sum);
    return 0;

}