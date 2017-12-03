package bms.entity;

public class Book {
	private int id;
	private String title;
	private String author;
	private String publish;
	private String date;
	private String score;
	private String person;
	private String price;
	private String tag;
	public Book(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}
	//重写，不受藏相同书籍
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getId()+this.getTitle().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
		{
			return true;
		}
		if(obj instanceof Book) //obj是Book的对象
		{
			Book i = (Book)obj;
			if(this.getId()==i.getId()&&this.getTitle().equals(i.getTitle()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
}
