package pojo;

public class UserAddress {  
private String plotNumber;  
private String street;  
private String state;  
private String country;  
private String zipCode;  

public UserAddress (String plotNumber, String street, String state, String country, String zipCode) {  
this.plotNumber=plotNumber;  
this.street=street;  
this.state=state;  
this.country=country;  
this.zipCode=zipCode;  
}  

public UserAddress() {  
}  
public String getPlotNumber() {  
return plotNumber;  
}  
public void setPlotNumber (String plotNumber) {  
this.plotNumber = plotNumber;  
}  
public String getStreet() {  
return street;  
}  
public void setStreet(String street) {  
this.street = street;  
}  
public String getState() {  
return state;  
}  
public void setState(String state) {  
this.state = state;  
}  
public String getCountry() {  
return country;  
}  
public void setCountry (String country) {  
this.country = country;  
}  
public String getZipCode(){  
return zipCode;  
}  
public void setZipCode (String zipCode) {  
this.zipCode = zipCode;  
}
}
