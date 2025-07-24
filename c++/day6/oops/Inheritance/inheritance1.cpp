//Animal->Dog
#include<iostream>
using namespace std;
class Animal{ 
    public:
    string foodType,animalType;
    void setAnimalDetails(string food,string type){
        foodType=food;
        animalType=type;
    }
    void showAnimalDetails(){
        cout << " the animal is "<< animalType<<" and it is a "<<foodType<<endl;
    }

};
class Dog:public Animal{
    public:
    string dog_food;
    void feedDog(string dogfood){

        dog_food=dogfood;
    }
    void showDogDetails(){
        cout << " As the animal is a "<< animalType<<" ,it eats "<< dog_food<<endl;
    }
};
int main(){
    string a_food,a_type,d_food;
    Animal A1;
    Dog d1;
    cout << "Enter the animal details as follows:";
    cout << "1.FoodType(Herbivore,Carnivore & omnivore):";
    cin>> a_food;
    cout << "2.AnimalType(Wild/Pet Animal): "<<endl;
    cin >>a_type;
    cout << "3.Type of food(Ex:Pedigree)"<<endl;
    cin>>d_food;
    A1.setAnimalDetails(a_food,a_type);
    A1.showAnimalDetails();
    d1.feedDog(d_food);

d1.animalType=a_type;
d1.showDogDetails();

}