package leetcode.shirishFavsList.tries;

public class ActionCode {
	private final ActionCodeType actionCodeType;
	private final String requestActionType;
	private final String messageType;

	private static final String CREATE = "Create";
	private static final String UPDATE = "Update";

	public ActionCode(ActionCodeType actionCodeType, String requestActionType) {
		this.actionCodeType = actionCodeType;
		this.requestActionType = requestActionType;
		this.messageType = actionToMessageType(actionCodeType);
	}

	public String getMessage() {
		if ("".equals(messageType))
			return "";

		return messageType + requestActionType;
	}

	private String actionToMessageType(ActionCodeType actionCode) {
		if (actionCode == ActionCodeType.ADD)
			return CREATE;
		if (actionCode == ActionCodeType.CHANGE)
			return UPDATE;
		return "";
	}

	public ActionCodeType getAction() {
		return actionCodeType;
	}
}
