using Humanizer;
using Newtonsoft.Json.Serialization;
using System.ComponentModel.DataAnnotations;

namespace Lab6.Models
{
    public class Movie
    {
        [Key]
        public int Id { get; set; }

        [Required][MaxLength(50,ErrorMessage = "Maksymalna iloœæ znaków to 50")]
        public string Title { get; set; }

        [Required][UIHint("LongText")]
        public string Description { get; set; }

        [UIHint("Stars")][Range(1, 5,ErrorMessage ="Ocena filmu musi byæ liczb¹ pomiêdzy 1 a 5")]
        public int Rating { get; set; }
        public string? TrailerLink { get; set; }
        public Genre? Genre { get; set; }
    }
}
