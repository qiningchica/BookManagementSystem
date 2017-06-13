package model;

import java.util.List;

public class LoanOnlyOneSpecification implements ISpecification<Member>{
	
	private Book wantBook;
	
	public LoanOnlyOneSpecification(Book wantbook){
		this.wantBook = wantbook;
	}

	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		boolean a = false;
		List<Loan> list = member.getLoans();
		if(list == null){
			a=true; 
		}else{
			for(Loan loan:list){
				if(loan.getBook().getISBN()!=wantBook.getISBN()){
					a=true;
				}
			}
		}		
		return a;
	}
	
}
