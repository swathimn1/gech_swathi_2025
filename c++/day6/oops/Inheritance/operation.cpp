#include<iostream>
using namespace std;
class Operation{
    private:
    string type_of_operation;
    public:
    int  a,b;
    //constructor
    Operation(){
        type_of_operation="NA";
       a=0;
       b=0;
    }
    Operation(string type){
        type_of_operation=type;

    }

    void setNumbers(int num1,int num2){

        a=num1;
        b=num2;
    }
    void showoperationType(){
        cout << "we are performing the "<< type_of_operation<<"operation."<<endl;
    }

    class Addition:public Operation{
        public:
        int sum;
    }
    
};
int main(){

    int num1,num2;
    string operationType;
    Operation O1;
    Addition A1;
    cout << "enter the type of Operation:"<<endl;
    cin >>operationType;
    cout << "Enter aany 2 numbers :"<<endl;
    cin >> num1 >> num2;
    O1.showoperationType();
    A1.showOperationType();
    



}