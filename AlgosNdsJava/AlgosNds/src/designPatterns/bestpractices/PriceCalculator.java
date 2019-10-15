package designPatterns.bestpractices;

public class PriceCalculator {
	public int CalculateDiscountPercentage(Vehicle vehicle)
    {
        decimal discount = 0;
        if (vehicle.DateInStock < DateTime.Now.AddYears(-65))
        {
            
            discount = .05m;
        }

        if (vehicle.DateInStock.Day == DateTime.Today.Day &&
            vehicle.DateInStock.Month == DateTime.Today.Month)
        {
         
            discount = Math.Max(discount, .10m);
        }

        if (vehicle.DateOfFirstPurchase.HasValue)
        {
            if (vehicle.DateOfFirstPurchase.Value < DateTime.Now.AddYears(-1))
            {
              
                discount = Math.Max(discount, .10m);
                if (vehicle.DateOfFirstPurchase.Value < DateTime.Now.AddYears(-5))
                {
               
                    discount = Math.Max(discount, .12m);
                    if (vehicle.DateOfFirstPurchase.Value < DateTime.Now.AddYears(-10))
                    {
                        
                        discount = Math.Max(discount, .2m);
                    }
                }

                if (vehicle.DateInStock.Day == DateTime.Today.Day &&
                    vehicle.DateInStock.Month == DateTime.Today.Month)
                {
             
                    discount += .10m;
                }
            }
        }
        else
        {
            
            discount = Math.Max(discount, .15m);
        }
        if (vehicle.IsNew)
        {
     
            discount = Math.Max(discount, .10m);
        }

        return discount;
    }
}