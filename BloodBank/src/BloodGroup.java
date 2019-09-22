
public class BloodGroup {
	String blood_type;
	
	public BloodGroup(String blood_type)
	{
		this.blood_type = blood_type;
	}
	
	public String getBloodType()
	{
		return this.blood_type;
	}
	public String toString()
	{
		return ""+ getBloodType();
	}

}
