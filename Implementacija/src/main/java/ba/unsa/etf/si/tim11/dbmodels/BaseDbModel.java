package ba.unsa.etf.si.tim11.dbmodels;

/**
 * Created by ensar on 4/26/16.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.logging.Logger;

@Entity
public class BaseDbModel implements Serializable {
    private static final Logger logger =
            Logger.getLogger(BaseDbModel.class.getName());

    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
