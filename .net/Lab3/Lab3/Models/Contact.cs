using System.ComponentModel;
namespace Lab3.Models
{
    public class Contact
    {
        [DisplayName("Identyfikator") ]
        public int Id { get; set; }

        [DisplayName("Imię")]
        public String Name { get; set; }

        [DisplayName("Nazwisko")]
        public String Surname { get; set; }

        [DisplayName("Email")]
        public String Email { get; set; }

        [DisplayName("Miasto")]
        public String City { get; set; }

        [DisplayName("Numer telefonu")]
        public String PhoneNumber { get; set; }

    }
}
