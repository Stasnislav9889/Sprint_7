package models.response;

import java.util.List;

public class OrdersItem{
	private String lastName;
	private String address;
	private List<String> color;
	private String firstName;
	private String createdAt;
	private String phone;
	private Object courierId;
	private String comment;
	private Integer id;
	private Integer rentTime;
	private String deliveryDate;
	private Integer track;
	private String metroStation;
	private String updatedAt;
	private Integer status;

	public String getLastName(){
		return lastName;
	}

	public String getAddress(){
		return address;
	}

	public List<String> getColor(){
		return color;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getPhone(){
		return phone;
	}

	public Object getCourierId(){
		return courierId;
	}

	public String getComment(){
		return comment;
	}

	public Integer getId(){
		return id;
	}

	public Integer getRentTime(){
		return rentTime;
	}

	public String getDeliveryDate(){
		return deliveryDate;
	}

	public Integer getTrack(){
		return track;
	}

	public String getMetroStation(){
		return metroStation;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public Integer getStatus(){
		return status;
	}
}