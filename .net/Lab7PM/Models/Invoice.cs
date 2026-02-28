using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace Web_App_DB_First.Models;

public partial class Invoice
{
    public int InvoiceId { get; set; }

    public int CustomerId { get; set; }

    [DataType(DataType.DateTime)]
    public DateTime InvoiceDate { get; set; }

    [Display(Name = "Billing Address")]

    public string? BillingAddress { get; set; }

    public string? BillingCity { get; set; }

    public string? BillingState { get; set; }

    public string? BillingCountry { get; set; }

    public string? BillingPostalCode { get; set; }

    [DataType(DataType.Currency)]
    public double Total { get; set; }

    public virtual Customer Customer { get; set; } = null!;

    public virtual ICollection<InvoiceLine> InvoiceLines { get; set; } = new List<InvoiceLine>();
}
