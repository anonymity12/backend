package com.xj.family.bean;

public class Routine {
    String routineContent;
    Integer routineId;
    Integer routineOwner;

    public Routine() {
    }

    public Routine(String routineContent, Integer routineId, Integer routineOwner) {
        this.routineContent = routineContent;
        this.routineId = routineId;
        this.routineOwner = routineOwner;
    }

    public String getRoutineContent() {
        return routineContent;
    }

    public void setRoutineContent(String routineContent) {
        this.routineContent = routineContent;
    }

    public Integer getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
    }

    public Integer getRoutineOwner() {
        return routineOwner;
    }

    public void setRoutineOwner(Integer routineOwner) {
        this.routineOwner = routineOwner;
    }

    @Override
    public String toString() {
        return "Routine{" +
                "routineContent='" + routineContent + '\'' +
                ", routineId=" + routineId +
                ", routineOwner=" + routineOwner +
                '}';
    }
}
