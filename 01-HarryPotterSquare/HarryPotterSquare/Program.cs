using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HarryPotterSquare
{
    internal class Program
    {
        static void Main(string[] args)
        {
            for(int x = 0; x < 25; ++x)
            {
                for (int y = 0; y < 25; ++y)
                    Console.Write(x * x + y * y <= 401 ? "# " : ". ");
                Console.WriteLine();
            }
            Console.ReadKey();
        }
    }
}
