#include<iostream>
using namespace std;
class Aadhar{
    private:
    string phone;
    int house_number,pincode;
    float age;
    public:
    string fname,address;

};
int main(){
    Aadhar Reg1,Reg2;
    int houseNum,pincode;
    string phoneNum;
    float person_age;
    cout << " enter the Name, age, father Name,Phone Number ,House Number ,Pincode and Address" << endl;
    cin >> Reg1.name >> name >> person_age >> Reg1.fathername>> phoneNum>>houseNum >> pincode >> Reg1.address;
    Reg1.aadharRegister(houseNum,pincode,phoneNum,person_age);
    Reg1.showRegistrationDetails();
    Reg2.name=" Swathi";
    Reg2.fathername="Nagaraja";
    Reg2.address="Mokali";
    Reg2.aadharRegister(55,573102,"988675443445",25);
    Reg2.showRegistrationDetails();
    return 0;
}