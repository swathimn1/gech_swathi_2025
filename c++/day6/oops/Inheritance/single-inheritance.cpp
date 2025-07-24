#include<iostream>
using namespace std;
//student->Employee
class Student{
    public:
    string name;
    public :
    void setName(string sName){

        name=sName;
    }
    void showMessage(){
        cout << name<<" was a student!"<<endl;
    }
};
//default visibility mode  is private mode
class Employee:public Student{
 public :
 void showDetails(){
   cout << name << " is now working as an employee!"<<endl;
 }
};
int main(){
    string name_of_person;
    Student s1;
    Employee e1;
    cout << "enter the name of the person:";
    cin>> name_of_person;
   s1.setName(name_of_person);
   s1.showMessage();
   e1.setName(name_of_person);
   e1.showDetails();
   return 0;

}