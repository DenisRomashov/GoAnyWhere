package ga.goanywhere.model;

import ga.goanywhere.dbutils.SessionFactoryUtil;
import ga.goanywhere.entities.AddressEntity;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

@NoArgsConstructor
public class AddressManagerImpl implements AddressManager {
    private final static Logger log = LogManager.getLogger(AddressManagerImpl.class);

    @Override
    public Long createOrGetAddress(AddressEntity addressEntity) {
        Session session = SessionFactoryUtil.getSession();
        try {
            return (Long) session.save(addressEntity);
        } finally {
            session.close();
        }
    }
}
