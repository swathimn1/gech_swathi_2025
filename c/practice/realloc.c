#include<stdio.h>
#include<stdlib.h>
int main(){
    int *arr;
    int i;
    arr=(int *)malloc(3*sizeof(int));
    if(arr==NULL){
        printf("memory not allocated\n");
        return 1;
    }
    for(int i=0;i<3;i++){
        scanf("%d\n",&arr[i]);
    }
    // for(int  i=0;i<3;i++){
    //     printf("%d\n",arr[i]);
    // }
    arr=(int *)realloc( arr,5*sizeof(int));
    if(arr==NULL){
        printf("memory not allocated\n");
        return 1;

    }
    for(int i=3;i<5;i++){
        scanf("%d\n",&arr[i]);
    }
    for(int i=0;i<5;i++){
        printf("%d\n",arr[i]);
    }
    free(arr);
    return 0;

}