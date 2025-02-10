package pojo;

public class UserPojo {
		private Integer user_id;
		private String user_first_name;
		private String user_last_name;
		private String user_contact_number;
		private String user_email_id;
		private UserAddress userAddress;
		public UserPojo(Integer user_id, String user_first_name, String user_last_name, String user_contact_number,
		String user_email_id, UserAddress userAddress) {
		//this.setUser_id(user_id);
		this.user_first_name=user_first_name;
		this.user_last_name=user_last_name;
		this.user_contact_number=user_contact_number;
		this.user_email_id=user_email_id;
		this.userAddress=userAddress;
		}
		public UserPojo() {
		}
		public String getUser_first_name() {
		return user_first_name;
		}
		public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
		}
		public String getUser_last_name() {
		return user_last_name;
		}
		public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
		}
		public String getUser_contact_number() {
		return user_contact_number;
		}
		public void setUser_contact_number(String user_contact_number) {
		this.user_contact_number = user_contact_number;
		}
		public String getUser_email_id() {
		return user_email_id;
		}
		public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
		}
		public UserAddress getUserAddress() {
		return userAddress;
		}
		public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
		}
//		public Integer getUser_id() {
//			return user_id;
//		}
//		public void setUser_id(Integer user_id) {
//			this.user_id = user_id;
//		}
}
