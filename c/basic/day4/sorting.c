//[0,5,3,6,2]
//sort in ascending order
//sort in descending order
//bubble sort technique
#include<stdio.h>
int main(){
    int num[10],size,value,temp;
    printf("enter the number of elements:\n");
    scanf("%d",&size);
    printf("enter the elements:\n");

    for(int i=0;i<size;i++){
        scanf("%d",&value);
         num[i]=value;
    }
    printf("\n original array:");
    for(int i=0;i<size;i++){
        printf("Index %d :%d\n",i,num[i]);
    }
    for(int i=0;i<size;i++){
        for(int j=0;j<size;j++){
            if(num[j]>num[j+1]){
                int temp=num[j];
                num[j]=num[j+1];
                num[j+1]=temp;
            }
           
    }
    }
     printf("\n sorted array:");
            for(int i=0;i<size;i++){
                printf("Index %d :%d\n",i,num[i]);
            }
            return 0;
        }
   
