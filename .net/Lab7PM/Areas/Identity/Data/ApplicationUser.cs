using Microsoft.AspNetCore.Identity;

namespace Web_App_DB_First.Areas.Identity.Data
{
    public class ApplicationUser : IdentityUser 
    {

        public long CustomerId { get; set; }



    }
}
