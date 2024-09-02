package ca.sheridancollege.oladega.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
   private long addressId;
   private String street;
   private String city;
   private String province;
   private String country;
   private String postalCode;
   private String email;

   
}
