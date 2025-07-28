#include<stdio.h>
int main(){
    int arr[5];
    printf("enter the elements :\n");
    for(int i=0;i<5;i++){
        scanf("%d",&arr[i]);
    }
    int key,found=0;
    printf("enter the key element to be searched:\n");
    scanf("%d",&key);
    for(int i=0;i<5;i++){

    
    if(arr[i]==key){
        printf("the key element %d found at %d position :",key,i);
        found=1;
        break;

    }
    }
    if(!found){
        printf("key element is found in the given array\n");
    }
}