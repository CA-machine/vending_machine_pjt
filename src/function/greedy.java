package function;

public class Greedy {
	
	int change = 0, totalChange = 0;
	int hamburger, rice, noodle, paid;
	
	public Greedy(int paid, int hamburger,int rice, int noodle) {
		this.paid = paid;
		this.hamburger = hamburger;
		this.rice = rice;
		this.noodle = noodle;
	}
	
	public int getChange() {
		return change;
	}

	public int getTotalChange() {
		return totalChange;
	}

	public int getPaid() {
		return paid;
	}
	
	public int TotalCost () {
		return hamburger*5700 + rice*4500 + noodle*2340;
	}
	
	public int GreedyChange() {
		int totalCost = 0, totalMoney = 0;
		totalCost = TotalCost();
		change = paid - totalCost; // 음식들 가격
		totalChange = change;
		int  n10000 = 0, n5000 = 0, n1000 = 0, n500 = 0 ,n100 = 0, n50 = 0 ,n10 = 0;
		
		while(change>=10000)
        {
            change = change - 10000;
            n10000++;
        }
        while(change>=5000)
        {
            change = change - 5000;
            n5000++;
        }
        while(change>=1000)
        {
            change = change - 1000;
            n1000++;
        }
        while(change >= 500) {
            change = change - 500;
            n500++;
        }
        while(change >= 100) {
            change = change - 100;
            n100++;
        }
        while(change >= 50) {
            change = change - 50;
            n50++;
        }
        while(change >= 10) {
            change = change - 10;
            n10++;
        }
        totalMoney = n10000 + n5000 + n1000 + n500 + n100 + n50 + n10;
        return totalMoney;
	}

}
