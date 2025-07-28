#include<iostream>
using namespace std;
class Multiply{
    private:
    int num1,num2;
    public:
    int product;
    void setValues(int n1,int n2){
        num1=n1;
        num2=n2;
    }
    void findproduct(){
        product =num1*num2;
        cout << " the product of the two numbers "<< num1 << " and "<< num2 << " is "<< product << endl;
    }
    Multiply(){
        num1=1;
        num2=1;
        cout << " the default constructor is called "<< endl;
    }
};
int main(){
    int a,b;
    Multiply m1;
    cout  << " enter any two numbers :"<< endl;
    cin >> a >> b;
    m1.setValues(a,b);
    m1.findproduct();
  
}