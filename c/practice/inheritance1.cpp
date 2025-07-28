#include<iostream>
using namespace std;
class Animal{
    public:
    string foodType,animalType;
    void setAnimalDetails(string food,string type){
        foodType=food;
        animalType=type;
    }
    void  showAnimalDetails(){
        cout << " the animal is "<< animalType << " and it is a "<< foodType << endl;
    }
};
class Dog:public Animal{
    public:
    string dog_food;
    void feeddog(string d_food){
        dog_food=d_food;
    }
    void showDogDetails(){
        cout << "As  the animal is "<< animalType << " ,it eats "<< dog_food<< endl;
    }
};
class Cow:public Animal{
    public:
    string cow_food;
    void feedcow(string c_food){
        cow_food=c_food;
    }
    void showCowDetails(){
        cout << "As  the animal is "<< animalType << " ,it eats "<< cow_food<< endl;
    }
};
int main(){
    string a_food,a_type,d_food,c_food;
    Animal A1;
    Dog d1;
    Cow c1;
    cout << " enter the animal's details as follows "<< endl;
    cout << " 1.FoodType(Herbivore,Carnivore & omnivore):"<<endl;
    cin >> a_food;
    cout << " 2.AnimalTYpe(Wild/Pet Animal): "<<endl;
    cin>>a_type;
    cout << " 3.Type of food(Ex:Pedigree) :"<< endl;
    cin>>d_food;
    cout << " 4.Type of food(Ex:Grass) :"<<endl;
    cin >> c_food;
    A1.setAnimalDetails(a_food,a_type);
    A1.showAnimalDetails();
    d1.setAnimalDetails(a_food,a_type);
    d1.showAnimalDetails();
    d1.feeddog(d_food);
    d1.showDogDetails();
    c1.setAnimalDetails(a_food,a_type);
    c1.showAnimalDetails();
    c1.feedcow(c_food);
    c1.showCowDetails();
    return 0;

}

