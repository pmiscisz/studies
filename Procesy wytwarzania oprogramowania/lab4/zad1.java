
//1

public Date d; // data rejestracji użytkownika
public List<Item> getItemsPurchasedByUser(User user){…}; //znajdź przedmioty
 //kupione przez użytkownika
//2
public Payments[] Payments;
private int pi;
protected ArrayList<Member> memberList; 
//3
public URL url;
private List<User> users;
public double[] dTable; 
//4
public class TemperatureLoader{
 public double[] loade(File f){…}
 public File save(double[] t){…}
}
class WeatherDataCreater{
 private WindData wind(){…}
 private PressureData getPressure(){…}
 private TemperatureLoad loadTemperature(double[] t){…}
} 
//5
public class HospitalVisit{
 public Patient createPatient(String name, String identity)
 {…}
 public Visit createVisit(Date d, Patient p){…}
 public VisitReport createVisitReport(Date d, Patient p,
 Visit v){…}
}
//6
public class Shop extends RestController{…}
public interface Drivers extends CrudRepository{…}
public class FoodS extends Service{…}
public class Payment extend Facade{…}
//7
public class Car extends Vehicle{
private String carBrand;
private String carType;
private String carPlateNumber;
public Car get(){
return this;
}
public void set(Car c){
this.carPlateNumber = c.getPlateNumber();
}
public void modify(Car c){
this.carBrand = c.getBrand();
}
public void change(Car c){
this.carType = c.getModel();
}
//Setters and getters
}
//8
public class Animals {…}
private class SecretPersistance {…}
public String getNameOfNewUser(Date t){…}
//9
Używajmy stałych, wyliczeń zamiast „magicznych” liczb i skrótów. Popraw poniższy
kod:

int jakasLiczba = 2022;
double pi = 3.14;
if(i=pi && r>0){
p=2*i*r;
}
int secondsInHour = 3600;
int alarmType = 4;
int uS = 3;
int r;
if(uS=1 || us>2 && us<5 || us=8){
System.out.println(“User has appropriate permissions”);
r = alarm(3, 9, 15, “user”);
switch(r){
case 0:
doFirstProcess();
break;
case 1:
doSecondProcess(r);
break
case 3:
doFifthProcess(secondsInHour);
default:
doThirdProcess(jakasLiczba);
}
}
