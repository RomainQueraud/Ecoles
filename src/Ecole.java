public class Ecole {

	private String id;
	private String name;
	private String role;
	private String phone;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getType(){
		if(this.role.equals("MAT")){
			return "Maternelle";
		}
		else{
			return "Elementaire";
		}
	}

	@Override
	public String toString(){
		return getId()+"\t"+getName()+"\t"+getRole()+"\t"+getPhone();
	}
}