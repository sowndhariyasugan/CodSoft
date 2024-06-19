package ATM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_ATMInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//user sample data
		User u1= new User(988553211,754218);
		User u2= new User(354547411,857421);
		User u3= new User(546854254,574218);
		User u4= new User(545182974,542156);
		User u5= new User(854858628,654633);
		
		List<User> UserData=new ArrayList<User>();
		UserData.add(u1);
		UserData.add(u2);
		UserData.add(u3);
		UserData.add(u4);
		UserData.add(u5);
		
		// Sample ATM
		ATM a1=new ATM("Coimbatre Branch");
		Scanner sc=new Scanner(System.in);
		String Quit;
			
			System.out.println("<---   Welcome to JavaBank ATM   --->");
			System.out.println("<<<---   "+a1.getBranchName()+"   --->>>");
		
			System.out.println("Enter ATM Card");
			if(sc.next().equals("y")) 
			{
				System.out.println("Enter Account No :");
				long AccountNo=sc.nextLong();
				User SelectedUser=null;
				for(User U:UserData) 
				{
					if(U.getAccountNo()==AccountNo) 
					{
						SelectedUser=U;
					}
				}
			
				if(SelectedUser==null)
				{
					System.out.println("Invalid Account Number : (");
				}
				else 
				{
					
					System.out.println("Enter Pin:");
					int EnteredPin=sc.nextInt();
					if(SelectedUser.getPin()==EnteredPin) 
					{
						do
						{
						
						System.out.println("... Enter the Option ...");
						System.out.println("{ <1> Withdraw }");
						System.out.println("{ <2> Deposit }");
						System.out.println("{ <3> Check Balance }");
						int Option =sc.nextInt();
				
						switch(Option)
						{
							case 1:
								System.out.println("Enter The Withdrawal amount:");
								int withdrawAMT=sc.nextInt();
								a1.withdraw(SelectedUser,withdrawAMT);
								break;
							case 2:
								System.out.println("Enter Amount to deposit:");
								int depositAMT=sc.nextInt();
								a1.deposit(SelectedUser,depositAMT);
								break;
							case 3:
								a1.checkBalance(SelectedUser);
								break;
						}
						
						System.out.println("Enter \n <y> ---> Quit \n <n> ---> Continue");
						Quit=sc.next();
						if(Quit.equals("y")) 
						{
							break;
						}
						else
						{
							Quit="n";
						}
					}while(Quit.equals("n"));
					}
					else 
					{
						System.out.println("...   Invalid PIN   ...");
					}
					
				
				}
			}
			else 
			{
				System.out.println("ATM Card Not Detected : (");
			}
		
		
		
		
		System.out.println("Thank You For visiting.");
		System.out.println("<<<---   Visit Again   --->>>");
		sc.close();
		}

}
