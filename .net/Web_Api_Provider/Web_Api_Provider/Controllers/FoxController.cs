using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Web_Api_Provider.Data;
using Web_Api_Provider.Models;

namespace Web_Api_Provider.Controllers
{
    [Route("api/fox")]
    [ApiController]
    public class FoxController : ControllerBase
    {

        private IFoxesRepository repository;

        public FoxController(IFoxesRepository _repository)
        {
            repository = _repository;
        }


        [HttpGet]
        public IActionResult Get()
        {
            var foxes = repository.GetAll();

            var sortedFoxes = foxes
                .OrderByDescending(x => x.Loves) 
                .ThenBy(x => x.Hates);

            return Ok(sortedFoxes);
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var fox = repository.Get(id);

            if (fox == null)
            {
                return NotFound($"Nie znaleziono lisa o id {id}");
            }
            return Ok(fox);
        }


        [HttpPost]
        [Authorize]
        public IActionResult Post([FromBody] Fox fox)
        {
            repository.Add(fox);
            return CreatedAtAction(nameof(Get), new { id = fox.Id }, fox);
        }



        [HttpPut("love/{id}")]
        public IActionResult Love(int id)
        {
            var fox = repository.Get(id);

            if (fox == null)
            {
                return NotFound($"Nie znaleziono lisa o id {id}");
            }

            fox.Loves++;

            repository.Update(id, fox);

            return Ok(fox);
        }


        [HttpPut("hate/{id}")]
        public IActionResult Hate(int id)
        {
            var fox = repository.Get(id);

            if (fox == null)
            {
                return NotFound($"Nie znaleziono lisa o id {id}");
            }

            fox.Hates++;
            repository.Update(id, fox);
            return Ok(fox);
        }


    }
}
