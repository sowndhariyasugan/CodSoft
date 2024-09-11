package ATM;


public class ATM {
	
	private String BranchName;

	public ATM(String branchName) {
		super();
		BranchName = branchName;
	}

	public String getBranchName() {
		return BranchName;
	}
	
	public void withdraw(User U,int withdrawAMT) {
		if(U.getBalance()<withdrawAMT)
		{
			System.out.println("...   Insufficient Funds   ...");
		}
		else
		{
			U.setBalance(U.getBalance()-withdrawAMT);
			System.out.println("<<<---   Amount Sucessfully dispenced   --->>>");
		}
		return;
	}
	
	public void deposit(User U,int depositAMT) {
		if(depositAMT>0) {
			U.setBalance(U.getBalance()+depositAMT);
			System.out.println("<<<---   DEpositted Successfully   --->>>");
		}
		else
		{
		System.out.println("...   Deposit Failed   ...");	
		}
		return ;
	}

	public void checkBalance(User U) {
		
		System.out.println(U.toString());
		return;
		
	}
}
