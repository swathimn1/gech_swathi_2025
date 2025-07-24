#include<iostream>
using namespace std;
class Student {
    public:
    string name;
    void showStudent (){
        cout << "the student's name is : "<<name<<endl;
    }

}; 
class Employee{
    public:
    string company;
    void showcompany(){
        cout << " the employee's company is :" <<company << endl;
    }
};
class Developer:public Student,public Employee{
public:
string skills[5];
void showDeveloperSkills(){
    for(int i=0;i<=5;i++){
        cout << i+1<<"."<<skills[i]<< endl;
    }
}

};
int main(){
    string tech[5],name_of_person,name_of_company;
    // Student S1;
    // Employee E1;
    Developer D1;
    cout << " Enter the Person Name & his Company Name :";
    cin >> name_of_person >> name_of_company;
    // S1.name=name_of_person;
    // S1.showStudent(); 
    // E1.company=name_of_company;
    // E1.showcompany();
    cout << " enter the Skillset of the developer:"<< endl;
for(int i=0;i<5;i++){
    cin >> tech[i];
}
for(int i=0;i<5;i++){
    D1.skills[i]=tech[i];
}
D1.name=name_of_person;
D1.company=name_of_company;
D1.showStudent();
D1.showcompany();
D1.showDeveloperSkills();


}
