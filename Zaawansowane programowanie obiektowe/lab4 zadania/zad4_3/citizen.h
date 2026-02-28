#ifndef CITIZEN_H
#define CITIZEN_H
#include <iostream>
using namespace std;

class Citizen
{
private:
    string name;
    string surname;
    int age;
    char sex;
    string postal_code;

public:
    Citizen();
    Citizen(string name, string surname,int age, char sex, string postal_code) : name(name),surname(surname),age(age),sex(sex),postal_code(postal_code){}


void show(){
    cout << "Imię: " << name << ", Nazwisko: " << surname << ", Wiek: " << age << ", Płeć: " << sex << ", Kod pocztowy: " << postal_code << endl;
}
string getSurname(){
    return surname;
}
int getAge(){
    return age;
}

char getSex(){
    return sex;
}
string getPostalCode(){
    return postal_code;
}
};
#endif // CITIZEN_H
