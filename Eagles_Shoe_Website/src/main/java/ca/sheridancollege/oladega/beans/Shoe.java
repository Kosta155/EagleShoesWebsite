package ca.sheridancollege.oladega.beans;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shoe {

	    private int shoeId;
	    private String shoeName;
	    private String shoeBrand;
	    private String shoeType;
	    private String gender;
	    private long price;
	    private Date shoeDate;
	    private Long discount;
	    private String color;
	    private String shoeStatus;
	    private long quantity;
	    private long size;
	    private long orderId;
	    private String pictureURL;
	    private String picture2URL;
	    private String picture3URL;
	    private String picture4URL;
}
