package modle;

public class BookModle {
	
	private int id;
	private String bookname;
	private String writer;
	private double price;
	
	public   BookModle(){
		//�޲ι��췽��
	}
	
	public BookModle(String bookname,String writer,double price){
		this.bookname=bookname;
		this.writer=writer;
		this.price=price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_name() {
		return bookname;
	}

	public void setBook_name(String bookname) {
		this.bookname = bookname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString(){
		return "ͼ����Ϣ:"+"id="+id+"   "+" booname:"+bookname+"   "+" writer:"+writer+"   "+" price:"+price;
	}
}
