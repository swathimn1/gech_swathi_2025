#include<iostream>
using namespace std;

class Addition {
    int a, b; // private data members
public:
    int result;

    void setNumbers(int num1, int num2) {
        a = num1;
        b = num2;
    }

    void getResult() {
        result = a + b;
        cout << "Addition of " << a << " and " << b << " is: " << result << "\n";
    }
};

class Namakarana {
private:
    string firstName, lastName;
public:
    string fathername, mothername;

    void setName(string fname, string lname);
    void getInfo() {
        cout << "The name of the child is: " << firstName << " " << lastName << "\n";
        cout << "The child's parent's details are as follows:\n";
        cout << "Father's name: " << fathername << "\n";
        cout << "Mother's name: " << mothername << "\n";
    }
};

// Scope resolution for method definition
void Namakarana::setName(string fname, string lname) {
    firstName = fname;
    lastName = lname;
}

int main() {
    Addition a1, a2;
    int n1, n2, n3, n4;

    cout << "Enter any two numbers: ";
    cin >> n1 >> n2;
    a1.setNumbers(n1, n2);
    a1.getResult();

    cout << "Enter another two numbers: ";
    cin >> n3 >> n4;
    a2.setNumbers(n3, n4);
    a2.getResult();

    a2.setNumbers(20, 30);
    a2.getResult(); // Added to show result

    Namakarana Child1, Child2;
    string fName, lName;

    cout << "Enter the first name and last name of the child:\n";
    cin >> fName >> lName;
    Child1.setName(fName, lName);

    cout << "Enter the father's name and mother's name of the child:\n";
    cin >> Child1.fathername >> Child1.mothername;
    Child1.getInfo();

    Child2.fathername = "Nagaraja";
    Child2.mothername = "Shantha";
    Child2.setName("Swathi", "M N");
    Child2.getInfo();

    return 0;
}
