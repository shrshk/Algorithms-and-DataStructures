package leetcode30DayChallenge.may;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FieldMapping {
	String inventoryField;
	String openmateField;

	FieldMapping(String inventoryField, String openmateField) {
		this.inventoryField = inventoryField;
		this.openmateField = openmateField;
	}

}

class InvVehicle {
	String invAdv;
	String invRetail;

	public String getInvAdv() {
		return invAdv;
	}

	public String getInvRetail() {
		return invRetail;
	}

	public void setInvAdv(String invAdv) {
		this.invAdv = invAdv;
	}

	public void setInvRetail(String invRetail) {
		this.invRetail = invRetail;
	}

	@Override
	public String toString() {
		return "InvVehicle [invAdv=" + invAdv + ", invRetail=" + invRetail + "]";
	}
}

class OpenVehicle {
	public String openAdv;
	public String openRetail;

	public String getOpenAdv() {
		return openAdv;
	}

	public String getOpenRetail() {
		return openRetail;
	}

	public void setOpenAdv(String openAdv) {
		this.openAdv = openAdv;
	}

	public void setOpenRetail(String openRetail) {
		this.openRetail = openRetail;
	}

	@Override
	public String toString() {
		return "OpenVehicle [openAdv=" + openAdv + ", openRetail=" + openRetail + "]";
	}

}

public class OpenMateInventoryMapping {
	Set<FieldMapping> mapping;

	OpenMateInventoryMapping() {
		this.mapping = new HashSet<>();
		mapping.add(new FieldMapping("invAdv", "openAdv"));
		mapping.add(new FieldMapping("invRetail", "openRetail"));
	}

	public OpenVehicle buildOpenVehicle(InvVehicle invVehicle)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Map<String, String> invToOpenMate = new HashMap<>();
		for (FieldMapping fieldMapping : mapping) {
			invToOpenMate.put(fieldMapping.inventoryField, fieldMapping.openmateField);
		}

		OpenVehicle openVehicle = new OpenVehicle();
		for (String key : invToOpenMate.keySet()) {
			Field openField = openVehicle.getClass().getDeclaredField(invToOpenMate.get(key));
			Field invField = invVehicle.getClass().getDeclaredField(key);
			String invValue = (String) invField.get(invVehicle);
			openField.set(openVehicle, invValue);
		}

		return openVehicle;

	}

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		InvVehicle invVehicle = new InvVehicle();
		invVehicle.invAdv = "2000";
		invVehicle.invRetail = "4000";

		System.out.println(new OpenMateInventoryMapping().buildOpenVehicle(invVehicle));
	}

}
