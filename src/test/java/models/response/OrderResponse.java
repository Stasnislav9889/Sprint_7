package models.response;

import java.util.List;

public class OrderResponse {
	private PageInfo pageInfo;
	private List<AvailableStationsItem> availableStations;
	private List<OrdersItem> orders;

	public PageInfo getPageInfo(){
		return pageInfo;
	}

	public List<AvailableStationsItem> getAvailableStations(){
		return availableStations;
	}

	public List<OrdersItem> getOrders(){
		return orders;
	}
}