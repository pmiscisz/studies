using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Localization;
using Microsoft.EntityFrameworkCore;
using System.Globalization;
using Web_App_DB_First.Areas.Identity.Data;
using Web_App_DB_First.Data;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection") ?? throw new InvalidOperationException("Connection string 'DefaultConnection' not found.");
builder.Services.AddDbContext<ApplicationDbContext>(options =>
    options.UseSqlite(connectionString));
builder.Services.AddDatabaseDeveloperPageExceptionFilter();

builder.Services.AddLocalization();

builder.Services.AddDefaultIdentity<ApplicationUser>(options => options.SignIn.RequireConfirmedAccount = true)
    .AddEntityFrameworkStores<ApplicationDbContext>();
builder.Services.AddControllersWithViews();

builder.Services.AddDbContext<ChinookDbContext>();



var app = builder.Build();


var supportedCultures = new[] { new CultureInfo("en-US") };
app.UseRequestLocalization(
new RequestLocalizationOptions
{
    DefaultRequestCulture = new RequestCulture("en-US"),
    SupportedCultures = supportedCultures,
    FallBackToParentCultures = false
}
);
CultureInfo.DefaultThreadCurrentCulture =
CultureInfo.CreateSpecificCulture("en-US");



// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseMigrationsEndPoint();
}
else
{
    app.UseExceptionHandler("/Home/Error");
}
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "orderslist",
    pattern: "orders",
    defaults: new { controller = "Home", action = "MyOrders" }
);


app.MapControllerRoute(
    name: "order",
    pattern: "orders/{id}",
    defaults: new { controller = "Home", action = "OrderDetails" }
);


app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");
app.MapRazorPages();

using (var scope = app.Services.CreateScope())
{
    using (var context = scope.ServiceProvider.GetService<ChinookDbContext>())
    {
        var userManager =
        scope.ServiceProvider.GetService<UserManager<ApplicationUser>>
        ();
        if (
        await userManager.FindByEmailAsync(
        context.Customers.OrderBy(x =>
        x.CustomerId).First().Email
        ) == null
        )
        {
            foreach (var item in context.Customers)
            {
                var user = new ApplicationUser
                {
                    UserName = item.Email,
                    NormalizedUserName = item.Email,
                    Email = item.Email,
                    NormalizedEmail = item.Email,
                    EmailConfirmed = true,
                    LockoutEnabled = false,
                    SecurityStamp = Guid.NewGuid().ToString(),
                    CustomerId = item.CustomerId
                };
                await userManager.CreateAsync(user,
                "P@ssw0rd");
            }
        }
    }
}


app.Run();
