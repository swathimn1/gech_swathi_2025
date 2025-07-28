#include<iostream>
using namespace std;
class Employee{
    private:
    int empId;
    string dept;
    public:
    string name,designation;
    Employee(int empId,string name,string designation,string dept){
        this->empId=empId;
        this->name=name;
        this->designation=designation;
        this->dept=dept;
    }
    Employee(){
        
    }
    void showEmployeeDetails(){
        cout << " employee name :"<<name <<endl;
        cout << " employee id :"<< empId << endl;
        cout << " employee designation :"<< designation << endl;
        cout << " employee department :"<< dept << endl;
    
    }
};
int main(){
    Employee emp1;
    int empID;
    string depart,Name,Designation;
    cout << " enter employee name,employee id ,designation,department "<< endl;
    cin>>Name >> empID >> Designation>> depart;
    emp1=Employee(empID,Name,Designation,depart);
    emp1.showEmployeeDetails();

}