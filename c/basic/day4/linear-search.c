#include<stdio.h>
int main(){
      int num[10],size,value,key ,found=0;
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
printf("enter the key  element  to be searched\n");
scanf("%d",&key);
for(int i=0;i<size;i++){
    if(num[i]==key){
        found=1;
        printf("%d is found at index %d\n",key,i);
    }
}
if(!found){

    printf("key element is not found in the given array\n");
}
}
//more time consumption
//Time Complexity:O(n)