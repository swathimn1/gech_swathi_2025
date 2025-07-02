#include<stdio.h>
/**
 * pointers to array
 * int * ptr;
 * int arr[10];
 * ptr=&arr;
 * 
 */
int main(){
    int arr[5]={1,2,3,4,5};
    int *ptr;
    ptr=arr;
    printf("the arr value:%p\n",arr);
    printf("The address of 0th ele:%p\n",&arr[0]);
    printf("the value of ptr:%p\n",ptr);
    printf("the value of 1 st element using arr:%d\n",arr[0]);
    printf("the value of 1 st  element using arr:%d\n",0[arr]);
    printf("the value of 2 nd element using arr:%d\n",arr[1]);
    printf("the value of 2 nd element using arr:%d\n",1[arr]);
    printf("the value of 1 st element using arr:%d\n",*arr);

    printf("the value of 1 st element using arr:%d\n",ptr[0]);
    printf("the value of 1 st element using arr:%d\n",0[ptr]);
    printf("the value of 1 st element using arr:%d\n",*ptr);

    ptr++;
    printf("the value using ptr:%d\n",*ptr);
    ptr=ptr+2;

    printf("the value using ptr:%d\n",*ptr);
    *ptr=100;
    for(int i=0;i<5;i++){
        printf("%d",i[arr]);
    }
    return 0;
}