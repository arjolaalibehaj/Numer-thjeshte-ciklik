public class CyclicPrimeNumbers { 
    
    // Funksioni qe kontrollon nese nje numer eshte numer i thjeshte apo jo 
    static boolean isPrime(int n) { 
        if (n <= 1) 
            return false; 
        if (n <= 3) 
            return true; 
  
        // Kontrollojme nese numri eshte i thjeshte 
        
        if (n % 2 == 0 || n % 3 == 0) 
            return false; 
  
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 
  
        return true; 
    } 
  
     // Funksioni qe kontrollon nese nje numer eshte numer ciklik i thjeshte apo jo
    static boolean checkCircular(int n) { 
        // Numerojme shifrat e numrit kryesor 
        
        int count = 0, temp = n; 
        while (temp>0) { 
            count++; 
            temp /= 10; 
        } 
  
        int currentNumber = n; 
        while (isPrime(currentNumber)) { 
  
        // Krijojme numrin e ardhshem ciklik te numrit kryesor duke leviur shifren e fundit te paren 
        
            int rem = currentNumber % 10; 
            int div = currentNumber / 10; 
            currentNumber = (int)((Math.pow(10, count - 1)) * rem) + div; 
  
        // Nese rikthehemi te numri origjinal dhe te gjitha kombinimet jane te thjeshta kthejme true
        
            if (currentNumber == n) 
            return true; 
        } 
  
        return false; 
    } 
  
        // Programi kryesor (main)
    
    public static void main (String[] args) { 
        int n = 1000000; 
        int count = 0;
        
        //Kontrollojme nga 1 deri ne 1 milion nese numri eshte ciklik i thjeshte dhe mbeldhim sa here e gjejme te tille
        
        for (int i = 1; i<=n; i++) {
            
        if (checkCircular(i) == true)
        count = count + 1;
        
        }
        
    System.out.println("Total cyclic number from 1 to 1 million is: "  + count); 
    } 
} 
