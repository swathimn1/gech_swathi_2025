#include<iostream>
using namespace std;
class Student{
    public://access specifier
    //data members
    int age,sem;
    string name;
    string college,branch;
    char section;
    //member function
    void print(){
        cout<<" My name is "<< name << ". I am from "<< college << ".I am in "<< branch <<" branch and my section is "<< section <<". I am in sem "<<sem << " and my age is "<<age <<endl;
    }
};
int main(){
    //student object has been created
    //syntax for creating the object
    //class_name object_name;
    Student std1,std2,std3;
    std1.name="Swathi";
    std1.age=21;
    std1.college="GECH";
    std1.branch="CSE";
    std1.sem=8;
    std1.section='A';
    std1.print();

    std2.name="praju";
    std2.age=18;
    std2.college="MCE";
    std2.branch="MECH";
    std2.sem=2;
    std2.section='A';
    std2.print();

   cout << " enter the name :";
   cin >> std3.name;
   cout << " enter the age :";
   cin >> std3.age;
   cout << " enter the college :";
   cin >> std3.college;
   cout << " enter the branch :";
   cin >> std3.branch;
   cout << "enter the sem :";
   cin >> std3.sem;
   cout << " enter the section :";
   cin >> std3.section;
   std3.print();
   




}