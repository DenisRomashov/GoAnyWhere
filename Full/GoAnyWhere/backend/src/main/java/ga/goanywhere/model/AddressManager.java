package ga.goanywhere.model;

import ga.goanywhere.entities.AddressEntity;

public interface AddressManager {

    Long createOrGetAddress(AddressEntity addressEntity);

}
