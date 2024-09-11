package Scores;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int Score=0;
		int NoOfSubjects=0;
		int TotalScore=0;
		double AverageScore=0.0;
		char Grade='X';
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No of Subjects:");
		NoOfSubjects=sc.nextInt();
		System.out.println("Enter Scores out of 100");
		for(int i=0;i<NoOfSubjects;i++) {
			System.out.println("Enter Score of Subject-"+(i+1));
			Score=sc.nextInt();
			TotalScore+=Score;
		}
		AverageScore=TotalScore/NoOfSubjects;
		if(AverageScore<=100.00 & AverageScore>90.00) {
			Grade='A';
		}
		else if(AverageScore<=90.00 & AverageScore>80.00) {
			Grade='B';
		}
		else if(AverageScore<=80.00 & AverageScore>70.00) {
			Grade='C';
		}
		else if(AverageScore<=70.00 & AverageScore>60.00) {
			Grade='D';
		}
		else if(AverageScore<=60.00 & AverageScore>50.00) {
			Grade='B';
		}
		else {
			Grade='F';
		}
		
		System.out.println("\n   ---*** RESULTS ***---   ");
		System.out.println("\n"+"Total:"+TotalScore+"\n"+"Average Score:"+AverageScore+"\n"+"Grade:"+Grade);
		sc.close();
	}

}
