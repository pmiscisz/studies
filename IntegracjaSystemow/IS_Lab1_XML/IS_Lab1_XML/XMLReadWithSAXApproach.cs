using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace IS_Lab1_XML
{
    internal class XMLReadWithSAXApproach
    {
        internal static void Read(string filepath)
        {
            // konfiguracja początkowa dla XmlReadera
            XmlReaderSettings settings = new XmlReaderSettings();
            settings.IgnoreComments = true;
            settings.IgnoreProcessingInstructions = true;
            settings.IgnoreWhitespace = true;
            // odczyt zawartości dokumentu
            XmlReader reader = XmlReader.Create(filepath, settings);
            // zmienne pomocnicze
            int count = 0;
            string postac = "";
            string sc = "";
            string podmiot = "";

            Dictionary<string, HashSet<string>> substances = new Dictionary<string, HashSet<string>>();
            Dictionary<string, int> kremProducent = new Dictionary<string, int>();
            Dictionary<string, int> tabletkiProducent = new Dictionary<string, int>();

            reader.MoveToContent();
            // analiza każdego z węzłów dokumentu
            while (reader.Read())
            {
                if (reader.NodeType == XmlNodeType.Element && reader.Name == "produktLeczniczy")
                {
                    postac = reader.GetAttribute("nazwaPostaciFarmaceutycznej");
                    sc = reader.GetAttribute("nazwaPowszechnieStosowana");
                    podmiot = reader.GetAttribute("podmiotOdpowiedzialny");

                    if (postac == "Krem" && sc == "Mometasoni furoas")
                        count++;

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
            }

            int count2 = substances.Count(kv => kv.Value.Count > 1);

            // Znalezienie producentów z największą liczbą kremów i tabletek
            string topKremProducent = kremProducent.OrderByDescending(kv => kv.Value).FirstOrDefault().Key ?? "Brak danych";
            int topKremCount = kremProducent.Values.DefaultIfEmpty(0).Max();

            string topTabletkiProducent = tabletkiProducent.OrderByDescending(kv => kv.Value).FirstOrDefault().Key ?? "Brak danych";
            int topTabletkiCount = tabletkiProducent.Values.DefaultIfEmpty(0).Max();

            Console.WriteLine("SAX Liczba produktów leczniczych w postaci kremu, których jedyną substancją czynną jest Mometasoni furoas: {0}", count);
            Console.WriteLine("SAX Liczba preparatów leczniczych o tej samej nazwie powszechnej, ale różnych postaciach: {0}", count2);
            Console.WriteLine("SAX Producent z największą liczbą kremów: {0} ({1})", topKremProducent, topKremCount);
            Console.WriteLine("SAX Producent z największą liczbą tabletek: {0} ({1})", topTabletkiProducent, topTabletkiCount);
        }
    }
}
