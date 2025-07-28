#include<stdio.h>
#include<stdlib.h>
int main(){
    int *arr;
    int n=5;
    arr=(int *)calloc(5,sizeof(int));
    if(arr==NULL){
        printf("Memory not allocated\n");
        return 1;
    }
    for(int i=0;i<n;i++){
        printf("%d\n",arr[i]);
    }
    for(int i=0;i<n;i++){
        scanf("%d\n",&arr[i]);
    }
    for(int i=0;i<n;i++){
        printf("%d\n",arr[i]);
    }
    free(arr);
    return 0;
}