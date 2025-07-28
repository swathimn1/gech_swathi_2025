#include<stdio.h>
#include<stdlib.h>
struct book{
    char title[20];
    char author[20];
    float price;
};
int main(){
    struct book books[3];
    for(int i=0;i<3;i++){
        printf("enter title:\n");
        scanf("%[^\n]%*c",books[i].title);
        printf("enter author:\n");
        scanf("%[^\n]%*c",books[i].author);
        printf("enter price:\n");
        scanf("%f\n",books[i].price);
    }
    for(int i=0;i<3;i++){
        printf("Book %d\n",i+1);
        printf("title:%s\n ",books[i].title);
        printf("author:%s\n",books[i].author);
        printf("price:%.2f\n",books[i].price);
    }
    return 0;
}