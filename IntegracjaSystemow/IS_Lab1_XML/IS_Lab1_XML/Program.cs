using System.IO;

// See https://aka.ms/new-console-template for more information
string xmlpath = Path.Combine("Assets", "data.xml");
// odczyt danych z wykorzystaniem DOM
Console.WriteLine("XML loaded by DOM Approach");
IS_Lab1_XML.XMLReadWithDOMApproach.Read(xmlpath);
Console.WriteLine("XML loaded by SAX Approach");
IS_Lab1_XML.XMLReadWithSAXApproach.Read(xmlpath);

// odczyt danych z wykorzystaniem XPath i DOM
Console.WriteLine("XML loaded with XPath");
IS_Lab1_XML.XMLReadWithXLSTDOM.Read(xmlpath);
Console.ReadLine();