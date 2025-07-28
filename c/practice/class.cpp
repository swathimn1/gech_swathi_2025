#include <iostream>
using namespace std;
 class Student
    {
    public:
        int age, sem;
        string name, college, branch;
        char section;
        void print()
        {
            cout << "My name is :" << name << "I completed my engineering in the stream of " << branch << "at college " << college << " my age is " << age << " and i am in section " << section << endl;
        }
    };
int main()
{
  Student s1;
  s1.name="Swathi";
  s1.age=21;
  s1.sem=8;
  s1.college="GECH";
  s1.branch="CSE";
  s1.section='A';
  s1.print(); 
}