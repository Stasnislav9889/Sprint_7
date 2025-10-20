package models.response;

public class PageInfo{
	private Integer total;
	private Integer limit;
	private Integer page;

	public Integer getTotal(){
		return total;
	}

	public Integer getLimit(){
		return limit;
	}

	public Integer getPage(){
		return page;
	}
}
