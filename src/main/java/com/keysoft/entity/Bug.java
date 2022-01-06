package com.keysoft.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Bug.findSevereBugs",query = "Select t from Ticket t where t.severity = 1")
public class Bug extends Ticket {

    private Integer severity;
    private String rootCause;

    public  Bug () {}

    public Bug (Integer severity,String rootCause) {
        this.severity = severity;
        this.rootCause = rootCause;
    }

    public Bug (Integer id, String title,String description,Application application,Release release,String status,
                Integer severity,String rootCause) {
        super(id,title,description,application,release,status);
        this.severity = severity;
        this.rootCause = rootCause;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public String getRootCause() {
        return rootCause;
    }

    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }
}
