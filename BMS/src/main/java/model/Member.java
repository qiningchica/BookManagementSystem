package model;

import java.util.ArrayList;

public class Member {
	private String Id;
	private String Name;
	private ArrayList<Loan> Loans;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ArrayList<Loan> getLoans() {
		return Loans;
	}
	public void setLoans(ArrayList<Loan> loans) {
		Loans = loans;
	}
	
	public Loan FindCurrentLoanFor(Book book){
		for(int i=0 ; i<Loans.size() ; i++){
			if(Loans.get(i).getBook().equals(book)){
				Loan bookLoan = Loans.get(i);
				return bookLoan;
			}
		}
		return null;
	}
	
	public final void Return(Book book){
		model.Loan loan = FindCurrentLoanFor(book);
		if(loan != null){
			loan.MarkAsReturned();
			book.setLoanTo(null);
		}
	}
	
	public final boolean CanLoad(Book book){
		return book.getLoanTo() == null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final Loan Loan(Book book){
		Loan loan = null;
		if(CanLoad(book) && validate(book)){
			loan = LoanFactory.CreateLoan(book, this);
			if(Loans == null){
				Loans = new ArrayList();
				Loans.add(loan);
			}else{
				Loans.add(loan);
			}
		}
		return loan;
	}
	
	public boolean validate(Book wantbook){
		HasReachMaxSpecification hrms = new HasReachMaxSpecification();
		LoanOnlyOneSpecification loos = new LoanOnlyOneSpecification(wantbook);
		return (hrms.IsSatisfiedBy(this) && loos.IsSatisfiedBy(this));
	}

}
