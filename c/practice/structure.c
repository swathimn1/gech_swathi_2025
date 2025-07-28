#include<stdio.h>
#include<string.h>
struct Student{
    int id;
    char name[20];
    int age ;
};
int main(){
    struct Student s1;
     s1.id=54;
     strcpy(s1.name,"swathi");
     s1.age=21;
     printf("id:%d\n",s1.id);
     printf("name:%s\n",s1.name);
     printf("age:%d\n",s1.age);
     return 0;
     /**passing structure values to a function of normal variables
      * void display(struct Student s1){
      * printf("%s\n",s1.name);
      * }
      * 
      * passing structure values to a function of reference(pointer) variables
      * void display(struct Student *s){
      * printf("%s\n",s1->name);
      * }
      */
}