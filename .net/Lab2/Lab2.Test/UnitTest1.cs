using Microsoft.VisualStudio.TestPlatform.ObjectModel;
using System.Globalization;
using System.Xml.Linq;

namespace Lab2.Test
{
    public class UnitTest1
    {
        [Fact]
        public void Fruit_ProperFormat_ShouldStartWithFruit()
        {
            var fruit = new Fruit { Name = "Apple" };
            var result = fruit.ToString();
            Assert.StartsWith("Fruit", result);
        }

        [Fact]
        public void Fruit_ProperToStringFormat()
        {
            UsdCourse.Current = 4.0f;
            var fruit = new Fruit
            {
                Name = "Apple",
                IsSweet = true,
                Price = 6.0
            };
            var result = fruit.ToString();

            string expectedPln = fruit.Price.ToString("C2", new CultureInfo("pl-PL"));
            string expectedUsd = (fruit.Price / UsdCourse.Current).ToString("C2", new CultureInfo("en-US"));
            string expected = "Fruit: Name = " + fruit.Name + ", IsSweet = " + fruit.IsSweet + ", Price= " + expectedPln + ", UsdPrice: " + expectedUsd;
            Assert.Equal(expected, result);
        }

        [Fact]
        public void Fruit_Create_GenerateMoreThenOneFruitName()
        {
            List<Fruit> fruits = new List<Fruit>();

            for (int i = 0; i < 20; i++)
            {
                fruits.Add(Fruit.Create());
            }

            foreach(var fruit in fruits)
            {
                Console.WriteLine(fruit.Name);
            }

            var uniqueNames = fruits.Select(f => f.Name).Distinct().ToList();

            
            Assert.True(uniqueNames.Count > 1);
        }
    }
}
