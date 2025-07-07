//write a program to check age of a person.
#include<stdio.h>
int main(){
    int age=19;
    if( age>=0 && age<=12){
        printf("child\n");
    }
    else if(age>=13 && age<=19){
        printf("Teenager\n");
    }
    else if(age>=20 && age<=59){
        printf("adult\n");
    }
    else if(age>=60){
        printf("Senior\n");
    }
    else{
        printf("Invalid Age\n");
    }
}