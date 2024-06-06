package Game;

import java.security.SecureRandom;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("\n <---Random Number game---> \n");
		int choice=1;
		int RoundNo=0;
		int RoundsWon=0;
		int TotalScore=0;
		Scanner sc=new Scanner(System.in);
		while(choice==1) {
			RoundNo++;
			System.out.println("Round:"+RoundNo);
			
			SecureRandom SecureRandomNum=new SecureRandom();
			int RandomNumber=SecureRandomNum.nextInt(10);
			
			
			int attempts;
			int guess=0;
			
			for (attempts = 5;  attempts> 0; attempts--) 
			{
				System.out.println("Enter the guess within range(0,10):");
				guess=sc.nextInt();
				if(guess==RandomNumber) {
					RoundsWon++;
					System.out.println("!!!--Correct Guess--!!!");
					int Score=assignScore(attempts);
					System.out.println("<---   +"+Score+"   --->");
					TotalScore+=Score;
					break;
				}
				else {
					System.out.println(attempts-1+"   Attempts Left..");
					if(guess>RandomNumber) {
						System.out.println("Try Lower...");
					}
					else {
						System.out.println("Try Higher...");
					}
				}
				
			}
			
			System.out.println("The Number is:"+RandomNumber);
			System.out.println("Enter \n 1 for Next Round \n 0 to Quit");
			choice=sc.nextInt();
		}
		sc.close();
		TotalScore=CalculateTotalScore(TotalScore,RoundsWon);
		System.out.println("<---   Total Score :"+TotalScore+"   --->");

	}
	
	public static int assignScore(int attempts) {
		if(attempts==5) {
			return 100;
		}
		else if(attempts==4) {
			return 75;
		}
		else if(attempts==3) {
			return 50;
		}else if(attempts==4) {
			return 35;
		}else {
			return 20;
		}
		
	}

	public static int CalculateTotalScore(int TotalScore,int RoundsWon) {
		System.out.println("!!!...Bonus For Each Round Won...!!!");
		int Bonus=RoundsWon*100;
		int Total=TotalScore+Bonus;
		return Total;
	}
}
