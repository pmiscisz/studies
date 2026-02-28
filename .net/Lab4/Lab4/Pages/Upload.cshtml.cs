using ImageMagick;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace Lab4.Pages
{
    public class UploadModel : PageModel
    {
        private string imagesDir;

        [BindProperty]
        public IFormFile Upload { get; set; }
        public UploadModel(IWebHostEnvironment environment)
        {
            
            imagesDir = Path.Combine(environment.WebRootPath, "images");

        }

        public void OnGet()
        {
        }
        
        public IActionResult OnPost()
        {
            if (Upload != null)
            {
                if (Upload.Length > 1_048_576)
                {
                    ModelState.AddModelError("Upload", "Plik jest za du¿y (max. 1 MB)");
                    return Page();
                }
                string extension = ".jpg";
                switch (Upload.ContentType)
                {
                    case "image/png":
                        extension = ".png";
                        break;
                    case "image/gif":
                        extension = ".gif";
                        break;
                }
                var fileName =Path.GetFileNameWithoutExtension(Path.GetRandomFileName()) +extension;
                var outputPath = Path.Combine(imagesDir, fileName);

           
                using var image = new MagickImage(Upload.OpenReadStream());
                using var watermark = new MagickImage("watermark.png");

                // przezroczystosc znaku wodnego
                watermark.Evaluate(Channels.Alpha, EvaluateOperator.Divide, 4);

                // narysowanie znaku wodnego
                image.Composite(watermark, Gravity.Southeast, CompositeOperator.Over);

     
                image.Write(outputPath);
            }
            return RedirectToPage("Index");
        }
    }
}
