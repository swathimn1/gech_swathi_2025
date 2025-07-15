#include<stdio.h>
int main(){
    int num[10],size,value,min,max;
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
min=max=num[0];
for(int i=0;i<size;i++){
    if(num[i]<min){
        min=num[i];
    
    }
    if(num[i]>max){
        max=num[i];
    }
}
printf("the minimum element is %d\n",min);
printf("the maximum element is %d\n",max);

}