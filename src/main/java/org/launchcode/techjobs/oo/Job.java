package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    //
@Override
    public String toString() {
        if(this.getName() == null) {
            return "\nOOPS! This job does not seem to exist.\n";
        } if (this.getEmployer().toString() == null || this.getEmployer().toString().trim() == "") {
            this.getEmployer().setValue("Data not available");
        } if (this.getLocation().toString() == null || this.getLocation().toString().trim() == "") {
            this.getLocation().setValue("Data not available");
        } if (this.getPositionType().toString() == null || this.getPositionType().toString().trim() == "") {
            this.getPositionType().setValue("Data not available");
        } if (this.getCoreCompetency().toString() == null || this.getCoreCompetency().toString().trim() == "") {
            this.getCoreCompetency().setValue("Data not available");
        }
            return "\nID: " + this.id + "\nName: " + this.name + "\nEmployer: " + this.employer.toString() + "\nLocation: " + this.location.toString() + "\nPosition Type: " + this.positionType.toString() + "\nCore Competency: " + this.coreCompetency.toString() + "\n";
}


@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Job)) {
            return false;
        }
        Job j = (Job) o;
        return getId() == j.getId();
}

@Override
    public int hashCode(){
        return Objects.hash(getId());
}

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer){
        this.employer = employer;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
