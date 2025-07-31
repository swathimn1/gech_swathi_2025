#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main(){
    int  fname_size,lname_size;
    char* fname;
    char* lname;
    printf("enter the size of of first name:\n");
    scanf("%d",&fname_size);
    printf("enter the size of of last name:\n");
    scanf("%d",&lname_size);
 fname=(char*)malloc(fname_size*sizeof(char));
 
 lname=(char*)malloc(lname_size*sizeof(char));

if(fname==NULL|| lname == NULL){
    printf("memory not allocated\n");
    return 1;
 }
 printf("enter your first name:\n");
 scanf("%s",&fname);
 printf("enter your lastname:\n");

 scanf("%s",&lname);
 printf("your name is :%s",strcat(fname,lname));
 free(fname);
 free(lname);
 return 0;
 
}