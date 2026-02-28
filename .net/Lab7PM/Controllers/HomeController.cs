using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Diagnostics;
using Web_App_DB_First.Areas.Identity.Data;
using Web_App_DB_First.Data;
using Web_App_DB_First.Models;

namespace Web_App_DB_First.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    private readonly ChinookDbContext _chinook;

    private readonly UserManager<ApplicationUser> _userManager;


    public HomeController(ILogger<HomeController> logger, ChinookDbContext chinook, UserManager<ApplicationUser> userManager)
    {
        _logger = logger;
        _chinook = chinook;
        _userManager = userManager;
    }

    public IActionResult Index()
    {
        return View(_chinook.Customers.ToList());
    }

    public IActionResult Privacy()
    {
        return View();
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }


    [Authorize]
    public async Task<IActionResult> MyOrders()
    {
        var user = await _userManager.GetUserAsync(User);
        var customerId = user.CustomerId;
        return View(await _chinook.Invoices.Where(x => x.CustomerId == customerId).ToListAsync());
    }

    [Authorize]
    public async Task<IActionResult> OrderDetails(int? id)
    {


        if (id == null)
        {
            return NotFound();
        }

        var user = await _userManager.GetUserAsync(User);
        var customerId = user.CustomerId;



        var invoice = await _chinook.Invoices
        .Where(i => i.InvoiceId == id && i.CustomerId == customerId)
        .Include(i => i.InvoiceLines)
            .ThenInclude(il => il.Track)
        .FirstOrDefaultAsync();

        if (invoice == null)
        {
            return NotFound();
        }



        return View(invoice);


    }







}


