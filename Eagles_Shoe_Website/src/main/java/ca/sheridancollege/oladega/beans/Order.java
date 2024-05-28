package ca.sheridancollege.oladega.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	private long orderId;
	private Date orderTime;
	private String email;
	private long addressId;
}


