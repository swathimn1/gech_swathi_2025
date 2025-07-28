#include<iostream>
using namespace std;
class Adhar{
    private:
    string phone;
    int houseNum,pincode;
    float age;
    public:
    string name,fathername,address;

    void aadharRegister(int h_num,int pin_code,int person_age, string phone_no){
       h_num=houseNum;
       pincode=pin_code;
       age=person_age;
       phone=phone_no;
    }
    void showRegistrationDetails(){
        cout << " Name is : " << name << endl;
        cout << " Father Name is : " << fathername << endl;
        cout << "age is : "<< age << endl;
        cout << " address is :" << houseNum << " ,"<<" "<< pincode  << endl;
    }
};

int main(){
    Adhar Reg1;
    int houseNumber,pinCode,AGE;
    string Phone;
    cout << " enter the Name ,age ,father name ,address ,houseNumber,pincode and phone number "<< endl;

    cin>> Reg1.name >> AGE>> Reg1.fathername>> Reg1.address >>houseNumber>> pinCode >> Phone;
    Reg1.aadharRegister(houseNumber,pinCode,AGE,Phone);
    Reg1.showRegistrationDetails();
    return 0;
}