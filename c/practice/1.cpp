#include<iostream>
using namespace std;
class Student{
    public:
    int age;
    string name;
    void print(){
        cout << "my name is "<< name << " and my age is "<< age << endl;

    }
};
int main(){
    Student s1;
    s1.name="Swathi";
    s1.age=21;
    s1.print();
}