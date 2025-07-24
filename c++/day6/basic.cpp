#include<iostream>//Header file for using input std::cin and output std::cout
#include<string>
int main(){
    int age;
    float weight;
    std ::string name;
    char grade;
    std::cout<<"enter your age:";
    std::cin>>age;
    std::cout<<"enter your weight(in Kgs):";
    std::cin>>weight;
    std::cout<<"enter your name:";
    std::cin>>name;
    std::cout<<"enter your grade:";
    std::cin>>grade;
    std::cout<<" your name is "<< name <<". you're "<< age <<" years old"<<" your weight is "<< weight <<" Kgs. And you have scored "<< grade <<" grade ";
}