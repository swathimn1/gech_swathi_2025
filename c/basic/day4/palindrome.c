#include<stdio.h>
int main(){
    int num[10],size,value,isPalindrome=1;
    printf("enter the number of elements:\n");
    scanf("%d",&size);
    printf("enter the elements:\n");
     
    for(int i=0;i<size;i++){
       scanf("%d",&value);
        num[i]=value;
    }
printf("\n original array:");
for(int i=0;i<size;i++){
    printf(" Index %d:%d\t",i,num[i]);
}
for(int i=0;i<size/2;i++){
    if(num[i]!=num[size-i-1]){
      isPalindrome=0;
      break;
    }
    
}
if(isPalindrome==1){
    printf("the array is a palindrome");

}
else{
    print("the array is not a palindrome");
}


}