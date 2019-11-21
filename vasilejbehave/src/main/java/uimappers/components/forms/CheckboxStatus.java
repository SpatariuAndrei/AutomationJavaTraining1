package uimappers.components.forms;

public enum CheckboxStatus {
    CHECK("checked"),
    UNCHECK("unchecked");

    private String status;

    CheckboxStatus(String status) {
        this.status = status;
    }

    public String getCheckboxStatus() {
        return this.status;
    }
}