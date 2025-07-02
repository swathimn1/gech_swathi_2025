#include<stdio.h>
int main(){
    int  a,b;
    int choice;
    int result;
    float division;
    while(1){
        printf("enter two numbers:\n");
        scanf("%d %d",&a ,&b);
        printf("enter your operation:\n");
        printf("1.Addition(+)\n");
        printf("2.Subtraction(-)\n");
        printf("3.Multiplication(*)\n");
        printf("4.Division(/)\n");
        printf("5.modulus(%)\n");
        printf("enter your choice:\n");
        scanf("%d",&choice);
        switch(choice){
            case 1:
            result=a +b;
            printf("Result:%d + %d =%d\n",a,b,result);
            break;

            case 2:
            result=a -b;
            printf("%d -%d =%d\n",a,b,result);
            break;

            case 3:
            result=a * b;
            printf("%d * %d = %d \n",a,b,result);
            break;

            case 4:
            if(b >0){
                result =(float)a/b;
                printf("%d / %d = %d\n",a,b, result);
                break;
            }
            else{
                printf("division by zero is not allowed\n");
            }

            case 5:
            if(b>0){
                result =a %b;
                printf("%d %% %d=%d\n",a,b,result);
                break;
            }
            else{
                printf("modulus by zero is not allowed.\n");
            }
            
            default:
            printf("Invalid choice.please try again.\n");


        }
        return 0;
    }

}