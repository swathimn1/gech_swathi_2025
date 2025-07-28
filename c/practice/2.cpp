#include<iostream>
using namespace std;
class Aadhar{
    private:
    float age ;
    int houseNum,pincode;
    string phone;
    public:
    string name,fathername,address;
    void setaadharRegister(int h_num, int pin_code,string Phone,float person_age ){
        h_num=houseNum;
        pin_code=pincode;
        age=person_age;
        phone=Phone;
    }
    void showRegistrationDetails(){
        cout<<"the details of the user are as follows "<< endl;
        cout << "Name :"<< name << endl;
        cout << "father name : " << fathername << endl;
        cout << " age :"<< age <<endl;
        cout << " address : "<< houseNum<< " ,"<< address  <<" "<< pincode <<endl;   
         }

};
int main(){
    Aadhar A1;
    int housenum,pinCode;
    string Phone_no;
    float Age;
    cout << " enter the name ,age ,father name,address,house num,pin code ,phone"<< endl;
    cin>> A1.name >> Age >> A1.fathername>> A1.address >> housenum>> pinCode >> Phone_no;
    A1.setaadharRegister(housenum,pinCode,Phone_no,Age);
    A1.showRegistrationDetails();
    A1.name="Swathi";
    A1.fathername="Nagaraja";
    A1.address="Mokali";
    A1.setaadharRegister(55,573102,"8548876720",21);
    A1.showRegistrationDetails();
    return 0;


}
