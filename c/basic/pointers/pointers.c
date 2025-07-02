#include <stdio.h>
/**
 * pointers in c:
 * ==============
 * pointer is a variable which stores the address of the another variable.
 * data_type *pointer_name;
 * *-used to declare and deference  a pointer.
 * &-used t get the address of a variable.
 * address-of operator(gets memory address)
 *
 */
int main()
{
    // variable
    int a = 20;
    // pointer
    int *ptr;
    ptr = &a;
    printf("the value of a :%d\n", a);
    printf("the address of a :%p\n", &a);
    printf("the value of ptr is %p\n", ptr);
    printf("the address of ptr is %p\n", &ptr);
    printf("the value of a using pointer is %d\n", *ptr); // 20
    printf("the value of a using pointer is %d\n", *(&a));
    printf("the value of a using pointer is %d\n", *(*(&ptr)));
    *ptr=50;
    printf("the value of a using pointer is %d\n", *ptr); 
    
    return 0;
}