package model;

import java.util.UUID;
import java.time.LocalDate;

public class LoanFactory {

	public static model.Loan CreateLoan(Book book, Member member) {
		Loan loan = new Loan();
		loan.Id = UUID.randomUUID().toString();
		loan.Book = book;
		loan.Member = member;
		loan.LoanDate = LocalDate.now();
		loan.DateForReturn = LocalDate.now().plusDays(30);
		book.setLoanTo(member);
		return loan;
	}

}
