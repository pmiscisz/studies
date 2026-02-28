
using Lab2;

UsdCourse.Current = await UsdCourse.GetUsdCourseAsync();
List<Fruit> fruits = new List<Fruit>();

for (int i = 0; i < 15; i++)
{
    fruits.Add(Fruit.Create());
}

Console.WriteLine("All Fruits:");
foreach (var fruit in fruits)
{
    Console.WriteLine(fruit.ToString());
}

var sweetFruits = fruits.Where(f => f.IsSweet).OrderByDescending(f => f.Price);

Console.WriteLine("All sweet fruits sorted by price:");
foreach (var fruit in sweetFruits)
{
    Console.WriteLine(fruit.ToString());
}