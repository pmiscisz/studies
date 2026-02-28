using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab2
{
    public class Fruit
    {
        public String Name { get; set; }
        public bool IsSweet { get; set; }
        public double Price { get; set; }

        public static Fruit Create()
        {
            Random r = new Random();
            string[] names = new string[] { "Apple", "Banana",
            "Cherry", "Durian", "Edelberry", "Grape", "Jackfruit" };
            return new Fruit
            {
                Name = names[r.Next(names.Length)],
                IsSweet = r.NextDouble() > 0.5,
                Price = r.NextDouble() * 10
            };
        }
        public static string FormatUsdPrice(double price)
        {
            var usc = new CultureInfo("en-us");
            return price.ToString("C2", usc);
        }

        public override string ToString()
        {
            string priceAfterFormat = Price.ToString("C2");
            return "Fruit: Name = " + Name + ", IsSweet = " + IsSweet + ", Price= " + priceAfterFormat + ", UsdPrice: "+ FormatUsdPrice(UsdPrice);

        }
        public double UsdPrice => Price / UsdCourse.Current;
    }
}
