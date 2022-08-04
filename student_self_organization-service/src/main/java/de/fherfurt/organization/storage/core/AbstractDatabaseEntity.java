package de.fherfurt.organization.storage.core;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class AbstractDatabaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.TABLE )
    private int id;

    @Version
    private int version;

    @Temporal( TemporalType.TIMESTAMP )
    private Date created;
    @Temporal( TemporalType.TIMESTAMP )
    private Date modified;

    public AbstractDatabaseEntity () {}

    @PrePersist
    void onCreate() {
        this.setCreated( new Date() );
    }

    @PreUpdate
    void onUpdate() {
        this.setModified( new Date( ));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "AbstractDatabaseEntity{" +
                "id=" + id +
                ", version=" + version +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}