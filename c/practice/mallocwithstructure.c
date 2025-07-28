#include<stdio.h>
#include<stdlib.h>
#include<string.h>
struct Student{
        char name[20];
        int age;
    };
int main(){
    struct Student *ptr;
    ptr=(struct Student*)malloc(5*sizeof(struct Student));
    if(ptr==NULL){
        printf("memory not allocated\n");
        return 1;
    }
    strcpy(ptr->name,"swathi");
    ptr->age=21;
    printf("Name :%s\n,Age:%d\n",ptr->name,ptr->age);
    free(ptr);
    return 0;
}