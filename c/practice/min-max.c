#include<stdio.h>
int main(){
    int arr[5],min,max;
    printf("enter the elements:\n");
    for(int i=0;i<5;i++){
        scanf("%d",&arr[i]);
    }
    min=max=arr[0];
    for(int i=0;i<5;i++){
        if(arr[i]<max){
            min=arr[i];
        }
        if(arr[i]>max){
            max=arr[i];
        }
    }
    printf("the minimum element is %d\n",min);
    printf("the maximum element is %d\n",max);

}