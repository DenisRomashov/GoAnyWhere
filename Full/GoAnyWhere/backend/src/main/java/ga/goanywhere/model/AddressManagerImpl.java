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
    public Long getOrCreateAddress(AddressEntity addressEntity) {
        log.info("Finding or creating new address");
        Session session = SessionFactoryUtil.getSession();
        try {
            synchronized (this) {
                AddressEntity addressEntity1 = (AddressEntity) session.createQuery("from AddressEntity where locality = :locality and " +
                        "street = :street and house = :house and latitude = :latitude and longitude = :longitude")
                        .setParameter("locality", addressEntity.getLocality()).setParameter("street", addressEntity.getStreet())
                        .setParameter("house", addressEntity.getHouse()).setParameter("latitude", addressEntity.getLatitude())
                        .setParameter("longitude", addressEntity.getLongitude()).uniqueResult();
                if (addressEntity1 == null) {
                    return (Long) session.save(addressEntity);
                } else {
                    return addressEntity1.getId();
                }
            }
        } finally {
            session.close();
        }
    }
}
