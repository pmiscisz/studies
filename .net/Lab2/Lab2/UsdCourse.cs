using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Lab2
{
    public class UsdCourse
    {
        public static float Current = 0;
        public async static Task<float> GetUsdCourseAsync()
        {
            var wc = new HttpClient();
            var response = await
           wc.GetAsync("https://api.nbp.pl/api/exchangerates/tables/a/?format=xml");
        if (!response.IsSuccessStatusCode)
                throw new InvalidOperationException();
            XDocument doc = XDocument.Parse(await response.Content.ReadAsStringAsync());
            var midUsdValue = doc.Descendants("Rate").Where(rate =>(string)rate.Element("Code") == "USD").Select(rate =>(string)rate.Element("Mid")).FirstOrDefault();
            return Convert.ToSingle(midUsdValue,System.Globalization.CultureInfo.InvariantCulture);
            throw new InvalidOperationException();
        }
    }
}

