#include<stdio.h>
/**
 * array:
 * =====
 * --> array is a collection of elements of the same data type elements
 * syntax:
 * ======
 * data_type array_name[size];
 * int arr[10];
 * 
 * accessing:
 * =========
 * arr[index];
 * arr[0];
 * 
 */
// int main(){
   
//     int arr[10];
//     printf("enter numbers:\n");
//     for(int i=0;i<5;i++){
//         scanf("%d",&arr[i]);
//     }
    // printf("the entered array elements are:\n");
    // for(int i=0;i<=5;i++){
    //     printf("%d",arr[i]);
    //
//   
     
//     for(int i=0;i<=5;i++){
//        
//         }
//     }

//    return 0; 

// }
// int main(){

//     int arr[5];
//     int max;
//     printf("enter numbers:\n");
//     for(int i=0;i<5;i++){
//         scanf("%d",&arr[i]);
//     }
//     max=arr[0]; 
//     for(int i=1;i<=5;i++){
//         if(arr[i]>max){
//         max=arr[i];
//         }
//     } printf("The maximum element is :%d\n",max);
// return 0; 

// }

int main(){

    int arr[5];
    int evensum=0,oddsum=0;
    printf("enter numbers:\n");
    for(int i=0;i<5;i++){
        scanf("%d",&arr[i]);
    }
    
    for(int i=0;i<5;i++){
        if(arr[i]%2==0){
             evensum +=arr[i];
        }
        else{
            oddsum +=arr[i];
        }
    } printf("The sum of even numbers :%d\n",evensum);
    printf("The sum of odd numbers :%d\n",oddsum);
return 0; 

}