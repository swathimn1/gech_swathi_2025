#include <stdio.h>
#include<string.h>

struct Internship {
    char name[50];
    float fees;
    int duration;
    int reg_id;
    char domain[50];
} I1;

int main() {
    printf("Enter the internship details:\n");

    printf("Registration ID: ");
    scanf("%d", &I1.reg_id);
    getchar(); 

    printf("Name: ");
    fgets(I1.name, sizeof(I1.name), stdin);

    printf("Fees: ");
    scanf("%f", &I1.fees);

    printf("Duration (in months): ");
    scanf("%d", &I1.duration);
    getchar();  // Consume newline

    printf("Domain: ");
    fgets(I1.domain, sizeof(I1.domain), stdin);

    // Remove trailing newline characters from strings
    I1.name[strcspn(I1.name, "\n")] = '\0';
    I1.domain[strcspn(I1.domain, "\n")] = '\0';

    printf("\nThe details are:\n");
    printf("Registration ID: %d\n", I1.reg_id);
    printf("Name: %s\n", I1.name);
    printf("Fees: %.2f\n", I1.fees);
    printf("Duration: %d months\n", I1.duration);
    printf("Domain: %s\n", I1.domain);

    return 0;
}
