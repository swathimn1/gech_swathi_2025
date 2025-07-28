#include<stdio.h>
int main(){
    int arr[5],low=0,mid,high=4,key,found=0;
    printf("enter the elements:\n");
    for(int i=0;i<5;i++){
        scanf("%d",&arr[i]);
    }
    printf("enter the element to be searched:\n");
    scanf("%d",&key);
    while(low<=high){
        mid=(low+high)/2;
        if(arr[mid]==key){
            printf("key element %d is found at index %d\n",key,mid);
            found=1;
            break;
        }
        else if(arr[mid]<key){
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    

    }
    if(!found){
        printf("key element not found in the array\n");

    }
    return 0;
}