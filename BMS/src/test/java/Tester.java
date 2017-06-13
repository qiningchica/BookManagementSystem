import org.junit.Test;

import model.Book;
import model.Member;

public class Tester {
	
	private Book book1,book2,book3,book4;
	private Member member1,member2,member3;	
	/*
	 * ����û�
	 */
	public void addMember(){
		member1 = new Member();
		member1.setId("0001");
		member1.setName("AAA");
	}
	/*
	 * ���ͼ��
	 */
	public void addBook(){
		book1 = new Book();
		book2 = new Book();
		book3 = new Book();
		book4 = new Book();
		book1.setId("0001");
		book1.setISBN("ISBN-001");
		book1.setTitle("ϵͳ���������");
		book1.setLoanTo(null);
		book2.setId("0002");
		book2.setISBN("ISBN-002");
		book2.setTitle("��ҳ��ƻ���");
		book2.setLoanTo(null);
		book3.setId("0003");
		book3.setISBN("ISBN-003");
		book3.setTitle("������Ϣϵͳ");
		book3.setLoanTo(null);

	}
	/*
	 * ����ɹ�
	 */
	@Test
	public void loanSuccess(){
		this.addMember(); 
		this.addBook();
		member1.Loan(book1);
		member1.Loan(book2);
		member1.Loan(book3);
		System.out.println("***********�����¼***********");
		System.out.println("������" + member1.getName());
		System.out.println("������" + book1.getTitle() + "��" + book2.getTitle() + "��" + book3.getTitle());
		System.out.println("����ʱ�䣺" + member1.getLoans().get(0).getLoanDate());
		System.out.println("�黹ʱ�䣺" + member1.getLoans().get(0).getDateForReturn());
		
	}
	/*
	 * ����ʧ��
	 */
	@Test
	public void loanFail(){
		this.loanSuccess();
		member1.Loan(book1);
		if(member1.validate(book1)==false){
			System.out.println("***********����ʧ��***********");
			System.out.println("����ʧ�ܣ�");
		}
	}
	/*
	 * ����
	 */
	@Test
	public void returnBook(){
		this.loanSuccess();
		member1.Return(book1);
		System.out.println("***********�����¼***********");
		System.out.println("������" + member1.getName());
		System.out.println("������" + book1.getTitle());
	}
}
