
#include <stdio.h>
#include <string.h>
int main()
{
    // single line comment
    /**
     * multiline comments
     */
    // datatypes in c
    /** primitive data types
     * =====================
     * 1.int ----->%d or %i
     * 2.char ------>%c
     * 3.float ------>%f
     * 4.double ------>%lf
     *
     * derived datatpes
     * ================
     * 1.array
     * 2.string(char array)
     *
     * user defined  datatypes
     * =======================
     * 1.structure
     * 2.unions
     */
    // int
    int age = 21;

    // char
    char grade = 'A';

    // float
    float percentage = 85.5;

    // double
    double pi = 3.1415926535;
    // Structure
    struct Student
    {
        int id;
        char name[20];
        float marks;
    };

    int numbers[3] = {10, 20, 30};

    char greet[] = "Hello, World!";

    struct Student s1 = {101, "swathi", 92.5};

    printf("Integer: %d\n", age);
    printf("Character: %c\n", grade);
    printf("Float: %.2f\n", percentage);
    printf("Double: %.10lf\n", pi);
    printf("Array values: %d %d %d\n", numbers[0], numbers[1], numbers[2]);
    printf("String: %s\n", greet);

    printf("\n-- Structure --\n");
    printf("ID: %d, Name: %s, Marks: %.2f\n", s1.id, s1.name, s1.marks);

    return 0;
}