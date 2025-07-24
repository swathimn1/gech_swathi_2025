// Access Specifier
#include <iostream>
using namespace std;
class TrainBooking
{
private:
    // private data member
    string aadhar, phone;

public:
    // public data member
    string name, address, source, destination, date, time;
    int age, train_no;
    // member function setter
    void setDetails(string a_no, string p_no)
    {
        aadhar = a_no;
        phone = p_no;
    }
    void getDetails()
    {
        cout << " The booking details are  as  follows" << "\n";
        cout << "Name is :" << name << "\n";
        cout << "Age is :" << age << "\n";
        cout << "Address is :" << address << "\n";
        cout << "Train no is :" << train_no << "\n";
        cout << "Source is :" << source << "\n";
        cout << "Destination is :" << destination << "\n";
        cout << "Date of depature is :" << date << "\n";
        cout << "Time is :" << time << "\n";
        cout << "Aadhar no is :" << aadhar << "\n";
        cout << "Phone no is :" << phone << "\n";
    }
};
int main()
{
    TrainBooking T1;
    string aadhar, phone;
    cout << " booking details are as follows" << "\n";
    cout << "Name :";
    cin >> T1.name;
    cout << "Age :";
    cin >> T1.age;
    cout << "Address :";
    cin >> T1.address;
    cout << "Train no :";
    cin >> T1.train_no;
    cout << "Source is :";
    cin >> T1.source;
    cout << "Destination :";
    cin >> T1.destination;
    cout << "Date Of Departure :";
    cin >> T1.date;
    cout << "Time :";
    cin >> T1.time;
    cout << "Aadhar no :";
    cin >> aadhar;
    cout << "Phone no :";
    cin >> phone;

    T1.setDetails(aadhar, phone);
    T1.getDetails();
    return 0;
}