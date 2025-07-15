#include<stdio.h>
int main(){
    int num[10],size,value,key,low=0,mid;
    printf("enter the number of elements:\n");
    scanf("%d",&size);
      int high=size-1;
    printf("enter the elements:\n");
     
    for(int i=0;i<size;i++){
       scanf("%d",&value);
        num[i]=value;
    }
printf("\n original array:");
for(int i=0;i<size;i++){
    printf(" Index %d:%d\t",i,num[i]);
}
printf("enter the key element to be searched\n");

scanf("%d",&key);
while(low<=high){
    mid=(low+high)/2;
    if(num[mid]==key){
        printf("key element is found at index %d  and position %d\n",mid,mid+1);
        return 0;
    }
    else if(num[mid]<key){
        low=mid+1;
    }
    else{
        high=mid-1;
    }
}
printf("key element is not found at %d position\n");
return 0;
}