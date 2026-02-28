using System;
using System.Threading.Tasks;
using ServiceReference1;
namespace ServiceReference1;
class Program
{
    static async Task Main(string[] args)
    {
        MyFirstSOAPInterfaceClient client = new MyFirstSOAPInterfaceClient();
        string response = await client.getHelloWorldAsStringAsync("Karol");
        Console.WriteLine(response);

        long days = await client.getDaysBetweenDatesAsync("01 01 2023", "10 01 2023");
        Console.WriteLine($"Liczba dni: {days}");
    }
}
