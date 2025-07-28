#include<iostream>
using namespace std;
class Parent{
    public:
    string name;
    void  showParentDetails(){
        cout << " Parent's name :"<< name << endl;
    }

};
class Child:public Parent {
    public:
    string child_name;
    void showChildDetails(){
        cout << " Child's name: "<< child_name << endl;
    }
};
int main(){
    Parent p1;
    Child c1;
    p1.name ="Nagaraja";
    c1.child_name="Swathi";
    c1.name="nagaraja";
    p1.showParentDetails();
    c1.showChildDetails();
    c1.showParentDetails();
    return 0;
}