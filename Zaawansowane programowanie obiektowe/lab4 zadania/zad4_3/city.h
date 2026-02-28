#ifndef CITY_H
#define CITY_H
#include<vector>
#include"citizen.h"
#include<iostream>
#include<algorithm>
using namespace std;


class City
{
private:
    vector<Citizen> citizens;
    string city_name;
public:
    City(string name) : city_name(name){}

    void addCitizen(Citizen &citizen){
        citizens.push_back(citizen);
    }
    void deleteCitizen(string &surname, int age) {
            citizens.erase(remove_if(citizens.begin(), citizens.end(),[&surname, age](Citizen &citizen) {
                    return citizen.getSurname() == surname && citizen.getAge() == age;
                }), citizens.end());
        }
};

#endif // CITY_H
