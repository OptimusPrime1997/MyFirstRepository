package edu.nju.model.po;

public class StatisticPO {

	private int littleWins;
	private int littleSum;
	private int middleWins;
	private int middleSum;
	private int largeWins;
	private int largeSum;
	private int customerWins;
	private int customerSum;

	public StatisticPO() {
		super();
	}

	public StatisticPO(int littleWins, int littleSum, int middleWins,
			int middleSum, int largeWins, int largeSum, int customerWins,
			int customerSum) {
		super();
		this.littleWins = littleWins;
		this.littleSum = littleSum;
		this.middleWins = middleWins;
		this.middleSum = middleSum;
		this.largeWins = largeWins;
		this.largeSum = largeSum;
		this.customerWins = customerWins;

		this.customerSum = customerSum;

	}

	public int getlittleWins() {
		return littleWins;
	}

	public void setlittleWins(int littleWins) {
		this.littleWins = littleWins;
	}

	public int getmiddleWins() {
		return middleWins;
	}

	public void setmiddleWins(int middleWins) {
		this.middleWins = middleWins;
	}

	public int getlargeWins() {
		return largeWins;
	}

	public void setlargeWins(int largeWins) {
		this.largeWins = largeWins;
	}

	public int getcustomerWins() {
		return customerWins;
	}

	public void setcustomerWins(int customerWins) {
		this.customerWins = customerWins;
	}

	public int getlittleSum() {
		return littleSum;
	}

	public void setlittleSum(int littleSum) {
		this.littleSum = littleSum;
	}

	public int getmiddleSum() {
		return middleSum;
	}

	public void setmiddleSum(int middleSum) {
		this.middleSum = middleSum;
	}

	public int getlargeSum() {
		return largeSum;
	}

	public void setlargeSum(int largeSum) {
		this.largeSum = largeSum;
	}

	public int getcustomerSum() {
		return customerSum;
	}

	public void setcustomerSum(int customerSum) {
		this.customerSum = customerSum;
	}
}
