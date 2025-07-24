/**
 * Inheritance is a inherit the properties from parent class to child class.
 * 5 types
 * 1.single level -one child class inherit the properties from one parent class ->one base class and one derived class.
 * 2.multiple -one child class inherit the properties from 2 parent classes-> 1 derived and 2 base classes
 * 3. multi-level->one base class inherit the properties from 1 derived classes->another derived class
 *4. heirarchical->single base class  and multiple derived classes.
 *5. hybrid->multiple base classes and multiple derived classes
 * 
 */
#include<iostream>
using namespace std;

//Base  class
class Parent{
    public:
    string name;
    void showParentDetails(){
        cout << "Parent's name: "<< name<< endl;
    }
};
//Derived class
//syntax:
//class DerivedClass:visibility_mode BaseClass
//visibility mode:public,private,protected
class Child :public Parent{
    public:
    string child_name;
    void showChildDetails(){
        cout << "Child's name: "<<  child_name<<endl;
    }
};

int main(){
    Parent p1;//Object of Parent class
    Child c1;//Object of Child Class
    p1.name="Nagaraja";
    c1.child_name="Swathi";
    c1.name="Nagaraj";
    p1.showParentDetails();
    c1.showChildDetails();//derived class can access both the child and parent class methods
    c1.showParentDetails();

    return 0;
}