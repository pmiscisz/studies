// See https://aka.ms/new-console-template for more information
using Lab1;
using System.Xml.Linq;
using System.Text.Json;

//Zad1_3
for (int i = 0; i <= 100; i++)
{
    if (i % 3 == 0 && i % 5 == 0)
    {
        Console.WriteLine("FizzBuzz");
    }
    else if (i % 3 == 0)
    {
        Console.WriteLine("Fizz");
    }
    else if (i % 5 == 0)
    {
        Console.WriteLine("Buzz");
    }
    else
    {
        Console.WriteLine(i);
    }
}
//Zad1_4 - 1_6
var rand = new Random();
var value = rand.Next(1, 101);
Console.WriteLine("Zgadnij liczbe od 1 do 100\n");
int guess;
int trials = 0;
string name = "";
do
{
    trials += 1;
    
    guess = Convert.ToInt32(Console.ReadLine());
    if (guess < value)
    {
        Console.WriteLine("Liczba jest większa");
    }
    else if (guess > value)
    {
        Console.WriteLine("Liczba jest mniejsza");
    }
    else
    {
        Console.WriteLine("Zgadłeś za " + trials + " podejściem!\nPodaj swoję imię: ");
        name = Convert.ToString(Console.ReadLine());
    }
}
while (guess != value);

var hs = new HighScore { Name = name, Trials = trials };

List<HighScore> highScores;
const string FileName = "highscores.json";
if (File.Exists(FileName))
    highScores =
    JsonSerializer.Deserialize<List<HighScore>>(File.ReadAllText(FileName));
else
    highScores = new List<HighScore>();

highScores.Add(hs);
File.WriteAllText(FileName,JsonSerializer.Serialize(highScores));

var sortedScores = highScores.OrderBy(h => h.Trials).ToList();

foreach (var item in sortedScores)
{
    Console.WriteLine($"{item.Name} -- {item.Trials} prób");
}