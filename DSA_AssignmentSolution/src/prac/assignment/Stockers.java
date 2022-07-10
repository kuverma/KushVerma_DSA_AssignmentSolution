package prac.assignment;

import java.util.Scanner;

public class Stockers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N;
		System.out.println("Enter the no of companies");
		N = sc.nextInt();

		Company[] com = new Company[N];

		for (int i = 0; i < N; i++) {
			System.out.println("Enter current stock price of the company " + (i + 1));
			double temp = sc.nextDouble();
			// com[i].setSharePrice(temp);
			System.out.println("Whether the company's stock price rose today compared to yesterday?");
			boolean temp1 = sc.nextBoolean();
			com[i] = new Company(temp, temp1);
			// com[i].setUpdatePrice(sc.nextBoolean());
		}

		Sort(com, 0, com.length - 1);
		int select = 0;

		do {
			System.out.println(
					"Enter the operation that you want to perform\n1. Display the companies stock prices in ascending order\n2. Display the companies stock prices in descending order\n3. Display the total no of companies for which stock prices rose today\n4. Display the total no of companies for which stock prices declined today\n5. Search a specific stock price\n6. press 0 to exit");
			select = sc.nextInt();
			switch (select) {

			case 0:
				System.out.println("Exited successfully");
				break;
			case 1:
				displayAsc(com);
				break;
			case 2:
				displayDes(com);
				break;
			case 3:
				displayUpStock(com);
				break;
			case 4:
				displaydownStock(com);
				break;
			case 5:
				System.out.println("enter the key value");
				searchStock(com, sc.nextDouble());
				break;
			case 6:
				select = 0;
				System.out.println("Exited successfully");
				break;
			default:
				System.out.println("please select right option.");
				break;
			}
		} while (select != 0);

		sc.close();
	}

	private static void Sort(Company[] com, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			Sort(com, l, m);
			Sort(com, m + 1, r);
			merge(com, l, m, r);
		}
	}

	private static void merge(Company[] com, int l, int m, int r) {

		int n1 = m - l + 1;
		int n2 = r - m;
		Company[] leftarr = new Company[n1];
		Company[] rightarr = new Company[n2];
		for (int i = 0; i < n1; ++i)
			leftarr[i] = com[l + i];
		for (int j = 0; j < n2; ++j)
			rightarr[j] = com[m + 1 + j];

		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (leftarr[i].getSharePrice() <= rightarr[j].getSharePrice()) {
				com[k] = leftarr[i];
				i++;
			} else {
				com[k] = leftarr[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			com[k] = leftarr[i];
			i++;
			k++;
		}

		while (j < n2) {
			com[k] = rightarr[j];
			j++;
			k++;
		}
	}

	private static void searchStock(Company[] com, double value) {
		boolean flag = true;
		for (int i = 0; i < com.length; i++)
			if (com[i].getSharePrice() == value) {
				System.out.println("Stock of value " + com[i].getSharePrice() + " is present");
				flag = false;
				break;

			}
		if (flag)
			System.out.println("Stock of value " + value + " is not present");
	}

	private static void displaydownStock(Company[] com) {
		int count = 0;
		for (int i = 0; i < com.length; i++)
			if (!com[i].isUpdatePrice())
				count++;
		System.out.println("Total no of companies whose stock price rose today :" + count);
	}

	private static void displayUpStock(Company[] com) {
		int count = 0;
		for (int i = 0; i < com.length; i++)
			if (com[i].isUpdatePrice())
				count++;
		System.out.println("Total no of companies whose stock price rose today :" + count);
	}

	private static void displayDes(Company[] com) {
		for (int i = com.length - 1; i >= 0; i--)
			System.out.println(com[i].getSharePrice());

	}

	private static void displayAsc(Company[] com) {
		for (int i = 0; i < com.length; i++)
			System.out.println(com[i].getSharePrice());
	}

}
