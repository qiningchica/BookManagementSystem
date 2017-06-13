package model;

import java.util.List;

public class HasReachMaxSpecification implements ISpecification<Member>{
		
	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		boolean a = false;
		List<Loan> list = member.getLoans();
		if(list == null || list.size()<3){
			a=true;
		}
		return a;		
	}

}
