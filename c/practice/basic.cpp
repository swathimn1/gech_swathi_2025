#include <iostream>
using namespace std;
int main()
{
    int age;
    float weight;
    string name;
    char grade;
    cout << "enter your age :";
    cin >> age;
    cout << "enter your weight(in kgs):";
    cin >> weight;
    cout << "enter your name:";
    cin >> name;
    cout << "enter your grade ;";
    cin >> grade;

    cout << "My name is: " << name << ", I am years old " << age << " my weight is " << weight << "kgs and i have scored " << grade << " grade " << endl;
}