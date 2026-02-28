using Web_Api_Provider.Models;

namespace Web_Api_Provider.Data
{
    public interface IFoxesRepository
    {

        void Add(Fox f);
        Fox Get(int id);
        IEnumerable<Fox> GetAll();
        void Update(int id, Fox f);

    }


}
