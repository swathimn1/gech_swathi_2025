#include<stdio.h>
int main(){
    int arr[5],temp;
    printf("enter the elements:\n");
    for(int i=0;i<5;i++){
        scanf("%d",&arr[i]);
    }
    
    for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
    printf("sorted array is :\n");
    for(int i=0;i<5;i++){
        printf("%d\n",arr[i]);
    }

return 0;
}