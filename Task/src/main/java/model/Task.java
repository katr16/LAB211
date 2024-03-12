package model;
public class Task {
    private int id;
    private String taskTypeId;
    private String requirementName;
    private String date;
    private String planFrom;
    private String planTo;

    public Task(int id, String taskTypeId, String requirementName, String date, String planFrom, String planTo, String assign, String reviewer) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public int getId() {
        return id;
    }

    public String getTaskTypeId() {
        return taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public String getDate() {
        return date;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public String getPlanTo() {
        return planTo;
    }

    public String getAssign() {
        return assign;
    }

    public String getReviewer() {
        return reviewer;
    }
    private String assign;
    private String reviewer;

}