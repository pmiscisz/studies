using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace IS_Lab1_XML
{
    internal class XMLReadWithDOMApproach
    {
        internal static void Read(string filepath)
        {
            // odczyt zawartości dokumentu
            XmlDocument doc = new XmlDocument();
            doc.Load(filepath);
            string postac;
            string sc;
            string podmiot;
            int count = 0;
            var warehouse = doc.GetElementsByTagName("produktLeczniczy");

            // Słownik: klucz to nazwa powszechna, wartość to zbiór postaci farmaceutycznych
            Dictionary<string, HashSet<string>> substances = new Dictionary<string, HashSet<string>>();
            Dictionary<string, int> kremProducent = new Dictionary<string, int>();
            Dictionary<string, int> tabletkiProducent = new Dictionary<string, int>();

            foreach (XmlNode w in warehouse)
            {
                postac = w.Attributes.GetNamedItem("nazwaPostaciFarmaceutycznej").Value;
                sc = w.Attributes.GetNamedItem("nazwaPowszechnieStosowana").Value;
                podmiot = w.Attributes.GetNamedItem("podmiotOdpowiedzialny").Value;

                if (postac == "Krem" && sc == "Mometasoni furoas")
                    count++;

                // Dodawanie postaci farmaceutycznej do odpowiedniej substancji
                if (!substances.ContainsKey(sc))
                    substances[sc] = new HashSet<string>();

                substances[sc].Add(postac);

                // Liczenie liczby kremów i tabletek na producenta
                if (postac == "Krem")
                {
                    if (!kremProducent.ContainsKey(podmiot))
                        kremProducent[podmiot] = 0;
                    kremProducent[podmiot]++;
                }

                if (postac == "Tabletki")
                {
                    if (!tabletkiProducent.ContainsKey(podmiot))
                        tabletkiProducent[podmiot] = 0;
                    tabletkiProducent[podmiot]++;
                }
            }

            // Liczenie substancji występujących w więcej niż jednej postaci
            int count2 = substances.Count(kv => kv.Value.Count > 1);

            // Znalezienie producentów z największą liczbą kremów i tabletek
            string topKremProducent = kremProducent.OrderByDescending(kv => kv.Value).FirstOrDefault().Key ?? "Brak danych";
            int topKremCount = kremProducent.Values.DefaultIfEmpty(0).Max();

            string topTabletkiProducent = tabletkiProducent.OrderByDescending(kv => kv.Value).FirstOrDefault().Key ?? "Brak danych";
            int topTabletkiCount = tabletkiProducent.Values.DefaultIfEmpty(0).Max();

            Console.WriteLine("DOM Liczba produktów leczniczych w postaci kremu, których jedyną substancją czynną jest Mometasoni furoas: {0}", count);
            Console.WriteLine("DOM Liczba preparatów leczniczych o tej samej nazwie powszechnej, ale różnych postaciach: {0}", count2);
            Console.WriteLine("DOM Producent z największą liczbą kremów: {0} ({1})", topKremProducent, topKremCount);
            Console.WriteLine("DOM Producent z największą liczbą tabletek: {0} ({1})", topTabletkiProducent, topTabletkiCount);
        }


    }
}
